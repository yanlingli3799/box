package com.javas.java8.lambda;

public class OperationProxy {
    public int operate(int a,int b,Operation operation){
        return operation.operate(a,b);
    }
}
