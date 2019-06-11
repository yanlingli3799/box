package com.javas.algorithms.no2.bit;

/**
 * Created by liyanling on 2019/1/29.
 * <p>
 * 题目：不用任何比较判断找出两个数中较大的数
 */
public class Numeric2Max {

  public static void main(String[] args) {

    int x = -1;
    int y = 2;

    System.out.println("-------方法1------------");
    function1(x, y);

    System.out.println("-------方法2------------");
    function2(x, y);


  }

  // 存在的问题是，若x-y的结果溢出，则计算结果就不正确。
  private static void function1(int x, int y) {

    int z = x - y;

    System.out.println("原始，x=" + x + ",y=" + y);
    System.out.println("减法，z=x-y=" + z);

    int scX = sign(z);
    int scY = flip(scX);
    System.out.println("x的系数，scX=" + scX);
    System.out.println("y的系数，scY=" + scY);

    int max = scX * x + scY * y;

    System.out.println("max=" + max);
  }


  private static void function2(int x, int y) {

    int z = x - y;
    int max;

    System.out.println("原始，x=" + x + ",y=" + y);
    System.out.println("减法，z=x-y=" + z);

    int sx = sign(x);
    int sy = sign(y);
    int sz = sign(z);
    System.out.println("x的符号位（1正0负），sx=" + sx);
    System.out.println("y的符号位（1正0负），sy=" + sy);
    System.out.println("z的符号位（1正0负），sz=" + sz);

    int sameSxy = flip(sx ^ sy);
    System.out.println("x和y符号位是否相同（1 true，0 false)，sameSxy=" + sameSxy);

    if (sameSxy == 1) {
      System.out.println("x和y符号位相同，则一定不会溢出，直接用公式计算");
      System.out.println("x的系数：" + sz);
      System.out.println("x的系数：" + flip(sz));
      max = sz * x + flip(sz) * y;
    } else {
      System.out.println("x和y符号位不同，则返回符号位为1的那个就可以了");
      max = sx * x + sy * y;
    }

    System.out.println("max=" + max);
  }


  // 右移31位再&1（其实是 & 000...1），最终得到的是一个符号位，正数或0位0，负数为1.
  // 再用异或转一下，则正数或0返回1，负数返回0
  public static int sign(int n) {
    return flip(n >> 31 & 1);
  }

  // 0变成1，1变成0
  public static int flip(int n) {
    return n ^ 1;
  }

}
