package com.javas.jdks.concurrents.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {

  public static void main(String[] args) throws InterruptedException {

    ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 12, TimeUnit.MICROSECONDS, new LinkedBlockingDeque<>(3));

    System.out.println("--1. 最简单的CountDownLatch，等待线程池执行完 1 个任务");
    test1(executor);

    Thread.sleep(1000);
    executor.shutdown();
  }

  private static void test1(ThreadPoolExecutor executor) throws InterruptedException {
    CountDownLatch latch = new CountDownLatch(1);
    executor.execute(new Runnable() {
      @Override
      public void run() {
        System.out.println("   456");
        // countDown() 执行完成后，计数器归0，会唤醒主线程，但子线程自己接下来的任务照样执行不耽误
        latch.countDown();
        for(int i=0;i<100;i++){
          System.out.print(i);
        }
        System.out.println();
      }
    });
    latch.await();
    System.out.println("   这一行一定打印在456后面");
  }
}
