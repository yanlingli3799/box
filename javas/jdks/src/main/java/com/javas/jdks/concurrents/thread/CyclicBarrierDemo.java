package com.javas.jdks.concurrents.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

  public static void main(String[] args) throws InterruptedException {

    System.out.println("---1. start两个线程，简单测试 CyclicBarrier");
    test1();
    Thread.sleep(1000);
    System.out.println();

    System.out.println("---2. start两个线程，测试 CyclicBarrier 自动重置");
    test2();


  }

  private static void test1(){
    CyclicBarrier cyclicBarrier = new CyclicBarrier(1, new Runnable() {
      @Override
      public void run() {
        System.out.println("   计数归0时执行这个方法");
      }
    });

    Thread thread1 = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("   我是第 1 个线程的检查点");
        try {
          cyclicBarrier.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (BrokenBarrierException e) {
          e.printStackTrace();
        }
        System.out.println("   我是第 1 个线程，过了检查点随便说点啥");
      }
    });
    thread1.start();

    Thread thread2 = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("   我是第 2 个线程的检查点");
        try {
          cyclicBarrier.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (BrokenBarrierException e) {
          e.printStackTrace();
        }
        System.out.println("   我是第 2 个线程，过了检查点随便说点啥");
      }
    });
    thread2.start();
  }


  private static void test2(){
    CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
      @Override
      public void run() {
        System.out.println("   计数归 0 时执行这个方法");
      }
    });

    Thread thread1 = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("   我是第 1 个线程的检查点 A");
        try {
          cyclicBarrier.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (BrokenBarrierException e) {
          e.printStackTrace();
        }
        System.out.println("   我是第 1 个线程，过了检查点 A 随便说点啥");
        System.out.println("   我是第 1 个线程的检查点 B");
        try {
          cyclicBarrier.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (BrokenBarrierException e) {
          e.printStackTrace();
        }
        System.out.println("   我是第 1 个线程，过了检查点 B 随便说点啥");
      }
    });
    thread1.start();

    Thread thread2 = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("   我是第 2 个线程的检查点 A ");
        try {
          cyclicBarrier.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (BrokenBarrierException e) {
          e.printStackTrace();
        }
        System.out.println("   我是第 2 个线程，过了检查点 A 随便说点啥");
        System.out.println("   我是第 2 个线程的检查点 B ");
        try {
          cyclicBarrier.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (BrokenBarrierException e) {
          e.printStackTrace();
        }
        System.out.println("   我是第 2 个线程，过了检查点 B 随便说点啥");
      }
    });
    thread2.start();
  }


}
