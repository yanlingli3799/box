package com.javas.jdks.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

  public static void main(String[] args) throws InterruptedException {

    // TODO：BlockingQueue 阻塞队列的实现
    ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 12, TimeUnit.MICROSECONDS, new LinkedBlockingDeque<>(3));

    System.out.println("---1. execute 执行 Runnable,不阻塞");
    test1(executor);
    Thread.sleep(1000);
    System.out.println();

    System.out.println("---2. execute 执行 Runnable,利用 CountDownLatch 阻塞等待线程全部执行完");
    test2(executor);
    Thread.sleep(1000);
    System.out.println();

    Thread.sleep(1000);
    executor.shutdown();
  }


  private static void test1(ThreadPoolExecutor executor) throws InterruptedException {
    executor.execute(new Runnable() {
      @Override
      public void run() {
        System.out.println("   123");
      }
    });
    System.out.println("   这一行可能打印在123前面");
  }


  private static void test2(ThreadPoolExecutor executor) throws InterruptedException {
    CountDownLatch latch = new CountDownLatch(1);
    executor.execute(new Runnable() {
      @Override
      public void run() {
        System.out.println("   456");
        latch.countDown();
      }
    });
    latch.await();
    System.out.println("   这一行一定打印在456后面");
  }

}
