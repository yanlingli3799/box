package com.javas.patterns.no5.singleton.round1;

/**
 * Created by liyanling on 2018/11/20.
 *
 * 饿汉式，线程安全
 */
public class Singleton {

  private static Singleton INSTANCE = new Singleton();

  public static synchronized Singleton getInstance(){
    return INSTANCE;
  }

  private Singleton() {
  }


}
