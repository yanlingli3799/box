package com.javas.java8.defaultable;

public interface Defaultable {
    /**
     * 加了 default 修饰后，可以直接在接口定义的时候实现方法
     */
    default void doSomething(){
        System.out.println("This is default function:doSomething");
    }
}
