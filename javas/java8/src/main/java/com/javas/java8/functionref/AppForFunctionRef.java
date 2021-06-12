package com.javas.java8.functionref;

import java.util.Arrays;
import java.util.List;

public class AppForFunctionRef {
    public static void main(String[] args){

        // 第1种方法引用的类型是构造器引用，语法是Class::new，或者更一般的形式：Class<T>::new
        // 注意：这个构造器没有参数
        final Car car1 = Car.create( Car::new );
        final Car car2 = Car.create( Car::new );
        final List< Car > cars = Arrays.asList( car1,car2 );

        System.out.println("-- 1 final 参数 + 静态方法 --");
        // 第2种方法引用的类型是静态方法引用，语法是Class::static_method
        // 注意：这个方法接受一个Car类型的参数
        cars.forEach( Car::collide );

        System.out.println("-- 2 final 参数 + 非静态方法 --");
        // 第3种方法引用的类型是某个实例对象的成员方法的引用，语法是instance::method。
        // 注意：这个方法接受一个Car类型的参数
        // 调用的是 police 的 follow 方法，cars 中的 car 被当做参数传入 follow 方法中
        final Car police = Car.create( Car::new );
        cars.forEach( police::follow );

        System.out.println("-- 3 无参数 + 非静态方法（但是可以用类名直接引用） --");
        // 第4种方法引用的类型是某个类的成员方法的引用，语法是Class::method
        // 注意，这个方法没有定义入参
        cars.forEach( Car::repair );

        System.out.println("-- 4 无参数 + 非静态方法（用对象名引用） --");
        // 第4种方法引用的类型是某个类的成员方法的引用，语法是Class::method
        // 注意，这个方法没有定义入参
        cars.forEach(car -> {
            car.repair(car);
        } );


    }
}
