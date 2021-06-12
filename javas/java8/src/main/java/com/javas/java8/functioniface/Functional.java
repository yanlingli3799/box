package com.javas.java8.functioniface;

/**
 * @FunctionalInterface 只能标记在"有且仅有一个抽象方法"的接口上
 *
 * 该注解不是必须的：
 * - 如果一个接口符合"函数式接口"定义，那么加不加该注解都没有影响；加上该注解能够更好地让编译器进行检查。
 * - 如果编写的不是函数式接口，但是加上了@FunctionInterface，那么编译器会报错。
 *
 */
@FunctionalInterface
public interface Functional {

    public void test();

}
