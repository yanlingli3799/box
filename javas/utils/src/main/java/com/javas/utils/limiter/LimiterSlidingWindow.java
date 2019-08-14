package com.javas.utils.limiter;


import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 方法2：滑动窗口
 */
public class LimiterSlidingWindow {

  // 限制 windowTime ms 内最多允许 maxCount 个请求通过

  private long startedTimestamp;// 计数起始时间，初始化后不变。
  private int  maxCount;// 总计数限制，初始化后不变。

  private       long duration;//每个格子的时长（单位：毫秒）
  private       int  bucketSize;//总格子数
  private final long windowTime;// 所有格子占用的时长（单位：毫秒） = 格子数 * 每个格子占用时长

  private          AtomicInteger[] buckets;// 一组格子，共 bucketSize 个。作为循环队列使用。
  private volatile int             head;// 指向循环数组的头，是最靠前的格子。


  private final ScheduledExecutorService scheduledExecutor;// 一个单独的线程，用来定时移动格子

  public LimiterSlidingWindow(long duration, int bucketSize, int maxCount) {
    this.duration = duration;
    this.bucketSize = bucketSize;
    this.scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    this.windowTime = duration * bucketSize;
    this.buckets = new AtomicInteger[bucketSize];
    this.maxCount = maxCount;
    init();
  }

  protected void init() {
    // 初始化起始时间点
    this.startedTimestamp = System.currentTimeMillis();

    // 初始化格子里的计数器
    for (int i = 0; i < bucketSize; i++) {
      this.buckets[i] = new AtomicInteger(0);
    }

    // 队列头指向第一个格子
    this.head = 0;

    // 按照 duration 滚动格子
    scheduledExecutor.scheduleAtFixedRate(new Runnable() {
      @Override
      public void run() {
        timeRolling();
      }
    }, duration / 2, duration, TimeUnit.MILLISECONDS);
  }

  /**
   * 时间滚动
   * <p>
   * head 往前滚动一格，被滚掉的那一格计数重置为0。
   */
  private void timeRolling() {
    int last = head;
    head = (head + 1) % bucketSize;
    buckets[last].set(0);
    System.out.println("----时间轮滚动至" + head + " " + Arrays.toString(buckets));
  }

  /**
   * 获取当前总计数
   *
   * @return
   */
  private int getCurrentCount() {
    return Arrays.stream(buckets).mapToInt(AtomicInteger::get).sum();
  }

  /**
   * 获取许可
   *
   * @return
   */
  private boolean acquire() {
    long now = System.currentTimeMillis();
    long timestampDiff = now - startedTimestamp;// 当前时间到计数开始时间的时间差
    long mask = timestampDiff % (windowTime);// 时间差 % 窗口可以计的总时间

    //相对于head的位置
    int idx = getBucketIndex(mask);
    if (idx == -1) {
      throw new IllegalStateException("illegalState");
    }
    buckets[idx].incrementAndGet();
    int count = getCurrentCount();
    System.out.print(" idx=" + idx + " arr=" + Arrays.toString(buckets) + " counter=" + count);
    return count <= maxCount;
  }

  /**
   * 查找距离 startedTimeStamp 取余为 mask 的 应该放到哪个位置。
   * <p>
   * 给定一个时间差，判断应该放到哪个格子。
   *
   * @param mask
   * @return
   */
  private int getBucketIndex(long mask) {

    // 如果 mask <= duration，则直接把它放到 head 指向的格子中
    if (mask <= duration) {
      return head;
    }

    // 否则，要去 head 后面找。
    int cursor = head;
    int stopIndex = cursor;
    long d = duration;
    while (true) {
      cursor = (cursor + 1) % bucketSize;
      if (cursor == stopIndex) {
        return -1;
      }
      d = d + duration;
      if (mask <= d) {
        return cursor;
      }
    }
  }


  /**
   * 关闭
   *
   * @throws InterruptedException
   */
  protected void shutdown() throws InterruptedException {
    scheduledExecutor.shutdown();
    scheduledExecutor.awaitTermination(5, TimeUnit.SECONDS);
  }

  // -----------------------------------

  public static void main(String[] args) throws InterruptedException {
    LimiterSlidingWindow limiter = new LimiterSlidingWindow(100, 10, 100);
    for (int i = 0; i < 300; i++) {
      System.out.println("  ->i=" + i + "  ->" + limiter.acquire());
      Thread.sleep(Math.abs((new Random()).nextInt()) % 10);
    }
    limiter.shutdown();
  }
}
