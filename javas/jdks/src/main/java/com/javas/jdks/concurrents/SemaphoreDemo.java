package com.javas.jdks.concurrents;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo extends Thread{
  public static final Semaphore semaphore = new Semaphore(1);
  public static int i = 0;

  public SemaphoreDemo(String name) {
    super.setName(name);
  }

  // 用 Semaphore 实现互斥锁
  @Override
  public void run() {
    for (int j = 0; j < 10000000; j++) {
      try {
        semaphore.acquire();
      } catch (InterruptedException e) {
        e.printStackTrace();
        semaphore.release();
      }
      try {
        i++;
      } finally {
        semaphore.release();
      }
    }
    System.out.println(this.getName() + " " + i);
  }


  public static void main(String[] args) throws ExecutionException, InterruptedException {


    SemaphoreDemo test1 = new SemaphoreDemo("thread1");
    SemaphoreDemo test2 = new SemaphoreDemo("thread2");

    test1.start();
    test2.start();
    test1.join();
    test2.join();
    // thread2输出结果为 20000000，若去掉锁，则是一个小于 20000000 的数字

  }
}
