package com.javas.utils.limiter;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 方法3：漏桶
 */
public class LimiterLeakBucket {

  private int                          capacity;// 漏桶容量
  private LinkedBlockingQueue<Integer> bucket;// 用共享阻塞队列来实现 桶

  private int flowOutNum;//以恒定的速率流出
  private int flowOutTimeUnit;

  private static final int     VALUE = 1;
  private              Thread  thread;
  private volatile     boolean stop  = false;

  public LimiterLeakBucket(int capacity, int flowOutNum, int flowOutTimeUnit) {
    this.capacity = capacity;
    this.flowOutNum = flowOutNum;
    this.flowOutTimeUnit = flowOutTimeUnit;
    this.bucket = new LinkedBlockingQueue<>(capacity);
    this.thread = new Thread(new Worker());
    init();
  }

  /**
   * init
   */
  public void init() {
    thread.start();
  }

  /**
   * 获取许可
   *
   * @return
   */
  protected boolean acquire() {
    System.out.print("size=" + bucket.size());
    return bucket.offer(VALUE);
  }

  /**
   * shutdown
   */
  public void shutdown() {
    stop = true;
    thread.interrupt();
    System.out.println("当前漏桶的容量：" + bucket.size());
  }

  /**
   * 内部worker
   */
  class Worker implements Runnable {

    @Override
    public void run() {
      while (!Thread.currentThread().isInterrupted() && !stop) {
        try {
          TimeUnit.MILLISECONDS.sleep(flowOutTimeUnit);
          for (int i = 1; i <= flowOutNum; i++) {
            bucket.take();
          }
          System.out.println("----漏桶容量：" + bucket.size());
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
    }
  }

  // -----------------------------------

  public static void main(String[] args) throws InterruptedException {
    LimiterLeakBucket limiter = new LimiterLeakBucket(10, 5, 100);
    for (int i = 0; i < 300; i++) {
      System.out.println("  ->i=" + i + "  ->" + limiter.acquire());
      Thread.sleep(Math.abs((new Random()).nextInt()) % 9);
    }
    limiter.shutdown();
  }
}
