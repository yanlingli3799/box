package com.javas.patterns.no5.singleton.round3;

/**
 * Created by liyanling on 2018/11/20.
 *
 * 懒汉式，线程不安全
 */
public class Singleton {

  private static Singleton INSTANCE;

  public static Singleton getInstance(){
    if(null == INSTANCE){
      INSTANCE = new Singleton();
    }
    return INSTANCE;
  }

  private Singleton() {
  }


}
