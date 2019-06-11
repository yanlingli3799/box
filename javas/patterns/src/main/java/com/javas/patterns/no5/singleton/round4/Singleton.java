package com.javas.patterns.no5.singleton.round4;

/**
 * Created by liyanling on 2018/11/20.
 *
 * 懒汉式，线程安全，效率低，不推荐用
 */
public class Singleton {

  private static Singleton INSTANCE;

  public static synchronized Singleton getInstance(){
    if(null == INSTANCE){
      INSTANCE = new Singleton();
    }
    return INSTANCE;
  }

  private Singleton() {
  }


}
