package com.javas.algorithms.no2.bit;

/**
 * Created by liyanling on 2019/1/29.
 * <p>
 * 题目：整数的二进制表达中有多少个1
 * 注意：负数的符号位也是算进去的。正数的符号位是0，不算。
 *
 * TODO：有很多比较偏门奇怪的算法可以解决这个问题，有时间了解下
 * TODO：有很多比较偏门奇怪的算法可以解决这个问题，有时间了解下
 * TODO：有很多比较偏门奇怪的算法可以解决这个问题，有时间了解下
 */
public class Numeric4Count1 {

  public static void main(String[] args) {

    String str = "n=%d,%s=%d";

    int n = 1;
    System.out.println(String.format(str, n, "count1", count1(n)));
    System.out.println(String.format(str, n, "count2", count2(n)));
    System.out.println(String.format(str, n, "count3", count3(n)));

    n = 2;
    System.out.println(String.format(str, n, "count1", count1(n)));
    System.out.println(String.format(str, n, "count2", count2(n)));
    System.out.println(String.format(str, n, "count3", count3(n)));

    n = 3;
    System.out.println(String.format(str, n, "count1", count1(n)));
    System.out.println(String.format(str, n, "count2", count2(n)));
    System.out.println(String.format(str, n, "count3", count3(n)));

    n = 4;
    System.out.println(String.format(str, n, "count1", count1(n)));
    System.out.println(String.format(str, n, "count2", count2(n)));
    System.out.println(String.format(str, n, "count3", count3(n)));

    n = 5;
    System.out.println(String.format(str, n, "count1", count1(n)));
    System.out.println(String.format(str, n, "count2", count2(n)));
    System.out.println(String.format(str, n, "count3", count3(n)));

    n = 6;
    System.out.println(String.format(str, n, "count1", count1(n)));
    System.out.println(String.format(str, n, "count2", count2(n)));
    System.out.println(String.format(str, n, "count3", count3(n)));

    n = 7;
    System.out.println(String.format(str, n, "count1", count1(n)));
    System.out.println(String.format(str, n, "count2", count2(n)));
    System.out.println(String.format(str, n, "count3", count3(n)));

    n = 8;
    System.out.println(String.format(str, n, "count1", count1(n)));
    System.out.println(String.format(str, n, "count2", count2(n)));
    System.out.println(String.format(str, n, "count3", count3(n)));

  }

  // 每次无符号右移1位，检查最低位是否为1来进行统计
  private static int count1(int n) {
    int res = 0;
    while (n != 0) {
      res += n & 1;
      n >>>= 1;
    }
    return res;
  }

  // 每次 n=n&(n-1) 都去掉低位的一个1，直到n变成0结束
  private static int count2(int n) {
    int res = 0;
    while (n != 0) {
      n = n & (n - 1);
      res++;
    }
    return res;
  }

  private static int count3(int n) {
    int res = 0;
    while (n != 0) {
      n = n - (n & (~n + 1));// 《程序员代码面试指南》书上给出的方法，有点难理解。
      // ~n+1得到的是它的相反数，再 &n，得到的是n中最右侧的1，每减掉一个就少一个1，直到n变为0为止。
      res++;
    }
    return res;
  }


}
