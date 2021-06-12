package com.javas.java8.functioniface;

public class AppForFunctional {

    public static void main(String[] args) {
        Functional functional = () -> System.out.println("hi");
        functional.test();
    }
}
