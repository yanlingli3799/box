package com.javas.java8.lambda;

/**
 * 双目运算的 lambda 实现
 */
public class OperationEnum {

    // 加
    static final Operation Addition = Integer::sum;

    // 减
    static final Operation Subtraction = (int a, int b) -> a-b;

    // 乘
    static final Operation Multiplication = (a, b) -> {
        return a*b;
    };

}
