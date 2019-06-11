package com.javas.patterns.no5.singleton.round4;

/**
 * Created by liyanling on 2018/11/20.
 */
public class Client {
  public static void main(String[] args){
    for(int i=0;i<10;i++){
      new Thread() {
        @Override
        public void run() {
          System.out.println(Singleton.getInstance().hashCode());
        }
      }.start();

      System.out.println(Singleton.getInstance().hashCode());

    }
  }
}
