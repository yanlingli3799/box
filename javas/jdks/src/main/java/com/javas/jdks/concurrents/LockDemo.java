package com.javas.jdks.concurrents;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo extends Thread{
  public static ReentrantLock lock = new ReentrantLock();
  public static int i = 0;

  public LockDemo(String name) {
    super.setName(name);
  }

  @Override
  public void run() {
    for (int j = 0; j < 10000000; j++) {
      lock.lock();
      try {
        i++;
      } finally {
        lock.unlock();
      }
    }
    System.out.println(this.getName() + " " + i);
  }


  public static void main(String[] args) throws InterruptedException {


    LockDemo test1 = new LockDemo("thread1");
    LockDemo test2 = new LockDemo("thread2");

    test1.start();
    test2.start();
    test1.join();
    test2.join();
    // thread2输出结果为 20000000，若去掉锁，则是一个小于 20000000 的数字

  }
}
