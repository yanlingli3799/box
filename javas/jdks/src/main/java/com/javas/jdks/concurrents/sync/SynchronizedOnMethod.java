package com.javas.jdks.concurrents.sync;

public class SynchronizedOnMethod {
  public static void main(String[] args){
    prints();
  }

  private synchronized static void prints() {
    System.out.println("测试");
  }
}
