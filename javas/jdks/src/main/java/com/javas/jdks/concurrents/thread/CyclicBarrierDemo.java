package com.javas.jdks.concurrents.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

  public static void main(String[] args){
    System.out.println("---1. start两个线程，测试CyclicBarrier");
    test1();
  }

  private static void test1(){
    CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
      @Override
      public void run() {
        System.out.println("   我也不知道这个是怎么搞的");
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
        System.out.println("  我是第 2 个线程的检查点");
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
}
