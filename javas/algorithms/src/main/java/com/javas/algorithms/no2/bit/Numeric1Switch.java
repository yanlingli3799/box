package com.javas.algorithms.no2.bit;

/**
 * Created by liyanling on 2019/1/29.
 *
 * 题目：不用额外变量交换两个整数的值
 *
 *
 */
public class Numeric1Switch {

  public static void main(String[] args) {
    int x = 1;
    int y = 2;

    System.out.println("交换前，x=" + x + ",y=" + y);
    x = x ^ y;
    y = x ^ y;
    x = x ^ y;
    System.out.println("交换后，x=" + x + ",y=" + y);

  }
}
