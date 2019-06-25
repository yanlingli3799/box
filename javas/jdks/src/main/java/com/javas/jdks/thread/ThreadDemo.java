package com.javas.jdks.thread;

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


  }

  // synchronized 实现交替执行
  private static void test_range_3() {

    final ThreadDemo demo = new ThreadDemo();
    Thread t1 = new Thread(demo::print1);
    Thread t2 = new Thread(demo::print2);

    t1.start();
    t2.start();

  }

  private synchronized void print1() {
    for (int i = 0; i <= 10; i += 2) {
      System.out.println(Thread.currentThread().getName() + " " + i);
      this.notify();
      try {
        if (i != 10) {
          this.wait();
        }
      } catch (InterruptedException ignored) {
      }
    }
  }

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


  // 预期：1和2交替输出，无顺序
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


  // 预期：前面都是3，后面都是4
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


}
