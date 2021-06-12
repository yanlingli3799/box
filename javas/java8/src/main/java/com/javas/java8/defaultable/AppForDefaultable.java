package com.javas.java8.defaultable;

public class AppForDefaultable {
    public static void main(String[] args) {

        // 使用默认方法 + 不适用静态方法
        Defaultable impl1 = new DefaultableImpl1();
        impl1.doSomething();

        // 覆盖默认方法 + 使用静态方法
        Defaultable impl2 = DefaultableFactory.create(DefaultableImpl2::new);
        impl2.doSomething();

    }
}
