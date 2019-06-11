package com.javas.patterns.no5.singleton.round5;

/**
 * Created by liyanling on 2018/11/20.
 *
 * 懒汉式，双重检查，线程安全。
 */
public class Singleton {

  private static volatile Singleton INSTANCE;

  private Singleton() {}

  public static Singleton getInstance() {
    if (INSTANCE == null) {
      synchronized (Singleton.class) {
        if (INSTANCE == null) {
          INSTANCE = new Singleton();
        }
      }
    }
    return INSTANCE;
  }

}
