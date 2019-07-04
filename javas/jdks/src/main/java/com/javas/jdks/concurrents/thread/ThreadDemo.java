package com.javas.jdks.concurrents.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo {

  private static int x = 0;

  public static void main(String[] args) throws Exception {

    System.out.println("---1. 各自执行");
    test_range_1();
    Thread.sleep(1000);
    System.out.println();

    System.out.println("---2. 顺序执行");
    test_range_2();
    Thread.sleep(1000);
    System.out.println();

    System.out.println("---3. 交替执行（synchronized）");
    test_range_3();
    Thread.sleep(1000);
    System.out.println();

    System.out.println("---4. 交替执行（CAS）");
    test_range_4();
  }



  /**
   * demo1：线程各自执行不影响
   * 预期：1和2交替输出，无顺序
   */
  private static void test_range_1() {

    Thread A = new Thread(() -> {
      for (int i = 0; i < 1000; i++) {
        System.out.print(1);
      }
    });

    Thread B = new Thread(() -> {
      for (int i = 0; i < 1000; i++) {
        System.out.print(2);
      }
    });

    // 分别启动 A 和 B，两个线程各自独立执行互不干扰。
    A.start();
    B.start();

  }


  /**
   * demo2：join 实现线程顺序执行
   * 预期：前面都是3，后面都是4
   */
  private static void test_range_2() throws InterruptedException {
    Thread A = new Thread(() -> {
      for (int i = 0; i < 1000; i++) {
        System.out.print(3);
      }
    });
    Thread B = new Thread(() -> {
      for (int i = 0; i < 1000; i++) {
        System.out.print(4);
      }
    });

    // 先启动 A 并 join，则主线程会等 A 执行完后，再执行下面的代码。
    A.start();
    A.join();

    B.start();
  }


  /**
   * demo3：synchronized 实现线程交替执行
   */
  private static void test_range_3() {

    final ThreadDemo demo = new ThreadDemo();
    Thread t1 = new Thread(demo::print1);
    Thread t2 = new Thread(demo::print2);

    t1.start();
    t2.start();

  }

  // 打印偶数 0 2 4 6 ...
  private synchronized void print1() {
    for (int i = 0; i <= 10; i += 2) {
      System.out.println(Thread.currentThread().getName() + " " + i);
      this.notify();// 通知等待当前锁的进程继续执行
      try {
        if (i != 10) {
          this.wait();// 若没到最后一个数，则
        }
      } catch (InterruptedException ignored) {
      }
    }
  }

  // 打印奇数 1 3 5 ...
  private synchronized void print2() {
    for (int i = 1; i <= 10; i += 2) {
      System.out.println(Thread.currentThread().getName() + " " + i);
      this.notify();
      try {
        if (i != 9) {
          this.wait();
        }
      } catch (InterruptedException ignored) {
      }
    }
  }

  /**
   * demo4：CAS 实现线程交替执行
   */

  static          AtomicInteger num  = new AtomicInteger(0);
  static volatile boolean       flag = true;

  private static void test_range_4() {

    // 打印偶数
    Thread A = new Thread(() -> {
      while (10 >= num.get()) {
        if (flag && num.get() % 2 == 0) {
          System.out.println(Thread.currentThread().getName() + " " + num.get());
          num.getAndIncrement();
          flag = false;
        }
      }
    });

    // 打印奇数
    Thread B = new Thread(() -> {
      while (10 >= num.get()) {
        if (!flag && num.get() % 2 != 0) {
          System.out.println(Thread.currentThread().getName() + " " + num.get());
          num.getAndIncrement();
          flag = true;
        }
      }
    });

    A.start();
    B.start();

  }

}
