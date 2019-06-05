package com.javas.jdks.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class ReferenceDemo {

  public static void main(String[] args){

    SoftReference<String> srStr = new SoftReference<>("123");
    System.out.println((srStr.get()));

    WeakReference<String> wrStr = new WeakReference<>("456");
    System.out.println((wrStr.get()));


    // 虚引用必须和队列结合使用
    ReferenceQueue<String> refQueue = new ReferenceQueue<String>();
    PhantomReference<String> prStr = new PhantomReference<String>(new String("789"), refQueue);
    System.out.println(prStr.get());// null

  }
}
