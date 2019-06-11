package com.javas.algorithms.no2.bit;

import java.util.Arrays;

/**
 * Created by liyanling on 2019/2/5.
 * <p>
 * 题目：在其他数都出现偶数次的数组中找出出现奇数次的数字
 */
public class Numeric5FindOdd {

  public static void main(String[] args) {
    int[] arr = {9, 3, 1, 7, 1, 3, 9};
    int odd = findOdd(arr);
    System.out.println("数组：" + Arrays.toString(arr) + ", 出现奇数次的数字是：" + odd);
  }

  // 原理：整数n与0异或的结果是n；整数n与整数n异或的结果是0。
  // 做法：申请一个整型变量eO=0，在遍历数组过程中，把eO与每个数异或（eO=eO^当前数），最后eO的值就是出现了奇数次的那个数。
  private static int findOdd(int[] arr) {
    int eO = 0;
    for (int x : arr) {
      eO = eO ^ x;
    }
    return eO;
  }
}
