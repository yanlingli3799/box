package com.javas.utils.limiter;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 方法1：计数器
 * 从某一时刻开始的 INTERVAL 时间（单位：毫秒）内最多只允许 MAX_COUNT 个请求通过。
 * <p>
 * 问题：时间节点重置的时隙里可能被突发请求超限，即某个 intervalMillis 时间内，被通过的请求量超过 maxCount。
 */
public class LimiterCounter {

  // 时间戳 和 计数器。用来描述 timestamp 开始到现在，已经有多少请求被放行
  private long          timestamp;
  private AtomicInteger counter;

  // 限制 intervalMillis ms 内最多允许 maxCount 个请求通过
  private int maxCount       ;
  private int intervalMillis ;

  public LimiterCounter(int maxCount, int intervalMillis) {
    this.maxCount = maxCount;
    this.intervalMillis = intervalMillis;
    this.timestamp = System.currentTimeMillis();
    this.counter = new AtomicInteger();
  }

  public boolean grant() {
    long now = System.currentTimeMillis();
    System.out.print("gap=" + (now - timestamp) + " counter=" + counter);

    // 当前时间 < 当前时间+跨度 ，则表示还在 timestamp + interval 这个区间内，要在原来的 counter 上累计
    // 否则表示已经到新的时间区间，counter 和 timestamp 重置
    if (now < timestamp + this.intervalMillis) {
      return counter.getAndIncrement() < this.maxCount;
    } else {
      timestamp = now;
      counter.set(0);
      return true;
    }
  }

  // -----------------------------------------------------------------

  public static void main(String[] args) throws InterruptedException {
    LimiterCounter limiter = new LimiterCounter(100, 1000);
    for (int i = 0; i < 300; i++) {
      System.out.println("  ->i=" + i + "  ->" + limiter.grant());
      Thread.sleep(Math.abs((new Random()).nextInt()) % 10);
    }
  }

}
