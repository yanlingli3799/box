package com.javas.algorithms.zuochengyun;


/**
 * Created by liyanling on 2019/1/29.
 * <p>
 * 题目：只用位运算不用算数运算实现整数的加减乘除运算
 */
public class Zuo_Chap_7_03 {

  public static void main(String[] args) {

    int a = -4;
    int b = 3;

    System.out.println("数字，a=" + a + ",b=" + b);

    System.out.println("sign（符号位）:a(" + a + ")=" + sign(a));
    System.out.println("sign（符号位）:b(" + b + ")=" + sign(b));

    System.out.println("neg（倒数）:a(" + a + ")=" + neg(a));
    System.out.println("neg（倒数）:b(" + b + ")=" + neg(b));

    System.out.println("add（加法）:a(" + a + ")+b(" + b + ")=" + add(a, b));
    System.out.println("minus（减法）:a(" + a + ")-b(" + b + ")=" + minus(a, b));

    System.out.println("abs（绝对值）:a(" + a + ")=" + abs(a));
    System.out.println("abs（绝对值）:b(" + b + ")=" + abs(b));

    System.out.println("multi1（乘法）:a(" + a + ")*b(" + b + ")=" + multi1(a, b));
    System.out.println("multi2（乘法）:a(" + a + ")*b(" + b + ")=" + multi2(a, b));
    System.out.println("multi3（乘法）:a(" + a + ")*b(" + b + ")=" + multi3(a, b));

    System.out.println("divide1（除法）:a(" + a + ")/b(" + b + ")=" + divide1(a, b));
    System.out.println("divide2（除法）:a(" + a + ")/b(" + b + ")=" + divide2(a, b));

    // TODO 书中对除法的边界处理做了相关说明，脑子不转了，先不管。
    // TODO 书中对除法的边界处理做了相关说明，脑子不转了，先不管。
    // TODO 书中对除法的边界处理做了相关说明，脑子不转了，先不管。

  }


  // 加法
  // 有两部分：
  // 1. 不考虑进位，a^b。
  // 2. 只算进位，(a&b)<<1。
  // 这两部分不断相加，知道没有进位（也就是(a&b)<<1为0）为止
  private static int add(int a, int b) {
    int sum = a ^ b;
    int carry = (a & b) << 1;
    while (carry != 0) {
      int x = sum;
      int y = carry;
      sum = x ^ y;
      carry = (x & y) << 1;
    }
    return sum;
  }


  // 相反数
  // 就是二进制按位取反再+1
  private static int neg(int a) {
    return add(~a, 1);
  }


  // 减法
  // a是减数，b是被减数
  // a-b 就是 a+(-b)
  private static int minus(int a, int b) {
    return add(a, neg(b));
  }


  // 乘法（乘法转换为加法，思路简单，但效率较低）
  // a是被乘数，b是乘数
  private static int multi1(int a, int b) {
    // 取绝对值　　
    int multiplicand = abs(a);
    int multiplier = abs(b);// 如果为负则取反加一得其补码，即正数　　
    // 计算绝对值的乘积　　
    int product = 0;
    int count = 0;
    while (count < multiplier) {
      product = add(product, multiplicand);
      count = add(count, 1);// 等价于 count++　
    }

    // 若同符号则直接返回，否则返回其负数
    int sameSn = flip(sign(a) ^ sign(b));
    return sameSn == 1 ? product : neg(product);
  }

  // 乘法（乘法转换为加法，优化版本）
  // (1) 判断乘数是否为0，为0跳转至步骤(4)
  // (2) 将乘数与1作与运算，确定末尾位为1还是为0，如果为1，则相加数为当前被乘数；如果为0，则相加数为0；将相加数加到最终结果中；
  // (3) 被乘数左移一位，乘数右移一位；回到步骤(1)
  // (4) 确定符号位，输出结果；
  private static int multi2(int a, int b) {
    //将乘数和被乘数都取绝对值
    int multiplicand = abs(a);
    int multiplier = abs(b);
    //计算绝对值的乘积　　
    int product = 0;
    while (multiplier > 0) {
      if ((multiplier & 0x1) > 0) {// 每次考察乘数的最后一位　　　　
        product = add(product, multiplicand);
      }
      multiplicand = multiplicand << 1;// 每运算一次，被乘数要左移一位　　　　
      multiplier = multiplier >> 1;// 每运算一次，乘数要右移一位（可对照上图理解）　　
    }
    // 若同符号则直接返回，否则返回其负数
    int sameSn = flip(sign(a) ^ sign(b));
    return sameSn == 1 ? product : neg(product);
  }


  // 乘法（《程序员代码面试指南》中给出的实现，是纯粹从二进制乘法的角度实现的）
  // b&1 为0时，表示b最低位为0；b&1 为1时，表示b最低位为1
  private static int multi3(int a, int b) {
    int multiplicand = a;
    int multiplier = b;
    int product = 0;
    // b=0时表示移完了
    while (multiplier != 0) {
      if ((multiplier & 1) == 1) {
        // multiplier最低位为1时，将multiplicand加到积上。
        product = add(product, multiplicand);
      }
      multiplicand <<= 1;// 等价于 a=a<<1，带符号左移一位
      multiplier >>>= 1;// 等价于 b=b>>>1，无符号右移一位
    }
    return product;
  }


  // 除法（除法转减法，同样有效率问题）
  // a是被除数，b是除数
  private static int divide1(int a, int b) {
    // 先取被除数和除数的绝对值
    int dividend = abs(a);
    int divisor = abs(b);

    int quotient = 0;// 商
    // 不断用除数去减被除数，直到被除数小于被除数（即除不尽了）
    while (dividend >= divisor) {// 直到商小于被除数
      quotient = add(quotient, 1);// 等价于 quotient++
      dividend = minus(dividend, divisor);
    }

    // 确定商的符号
    int sameSn = flip(sign(a) ^ sign(b));
    quotient = sameSn == 1 ? quotient : neg(quotient);

    // 确定余数的符号
    int remainder = b > 0 ? dividend : neg(dividend);

    return quotient;// 返回商
  }


  // 除法（除法转减法，优化版本）
  private static int divide2(int a, int b) {
    // 先取被除数和除数的绝对值
    int dividend = abs(a);
    int divisor = abs(b);

    int quotient = 0;// 商

    // 注意不要写 i--
    for (int i = 31; i >= 0; i = minus(i, 1)) {
      //比较 dividend 是否大于 divisor的(1<<i) 次方，不要将 dividend 与 (divisor<<i) 比较，而是用 (dividend>>i) 与 divisor 比较，
      //效果一样，但是可以避免因 (divisor<<i) 操作可能导致的溢出，如果溢出则会可能 dividend 本身小于 divisor ，但是溢出导致 dividend 大于 divisor
      if ((dividend >> i) >= divisor) {
        // 1<<i 就是2的i次方
        quotient = add(quotient, 1 << i);// 或 quotient |=  1 << i;
        dividend = minus(dividend, divisor << i);
      }
    }

    // 确定商的符号
    int sameSn = flip(sign(a) ^ sign(b));
    quotient = sameSn == 1 ? quotient : neg(quotient);

    // 确定余数符号
    int remainder = b > 0 ? dividend : neg(dividend);

    return quotient;// 返回商
  }


  private static int sign(int n) {
    return flip(n >> 31 & 1);
  }

  // 0变成1，1变成0
  private static int flip(int n) {
    return n ^ 1;
  }


  // 取绝对值
  private static int abs(int x) {
    int sign = sign(x);
    if (sign == 1) {
      return x;
    } else {
      return minus(0, x);
    }
  }

}
