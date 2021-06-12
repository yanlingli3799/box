package com.javas.java8.functionref;

import java.util.function.Supplier;

public class Car {

    // 静态方法 + 带 final Supplier 入参
    public static Car create(final Supplier<Car> supplier){
        return supplier.get();
    }

    // 静态方法 + 带 final 入参
    public static void collide( final Car car ) {
        System.out.println( "Collided " + car.toString() );
    }

    // 非静态方法 + 带 final 入参
    public void follow( final Car another ) {
        System.out.println( this.toString() + " Following the " + another.toString() );
    }

    // 非静态方法 + 无参数
    public void repair() {
        System.out.println( "Repaired 1 " + this.toString() );
    }

    // 非静态方法 + 非 final 参数
    public void repair(Car car) {
        System.out.println( "Repaired 2 " + this.toString() );
    }
}
