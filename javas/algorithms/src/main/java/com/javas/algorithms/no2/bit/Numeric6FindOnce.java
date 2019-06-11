package com.javas.algorithms.no2.bit;

import java.util.Arrays;

/**
 * Created by liyanling on 2019/2/10.
 * <p>
 * 题目：在其他都出现了k次的数中找出只出现1次的数
 */
public class Numeric6FindOnce {

  public static void main(String[] args) {
    int[] arr = {1, 1, 2, 3, 5, 7, 2, 3, 7};
    int k = 2;
    int once = findOnce(arr, k);
    System.out.println("数组：" + Arrays.toString(arr) + ", 其他都出现了k=" + k + "次，只出现1次的是：" + once);


  }

  // 原理：
  // - k进制的两个数 c 和 d，在 i 位上无进位相加的结果就是 (c(i)+d(i))%k；
  // - 则 若k个相同的k进制数进行无进位相加，相加的结果一定是每一位上都是0的k进制数。
  // 做法：
  // - 设置一个变量eO，它是一个32位的k进制数，且每个位置上都是0。
  // - 然后遍历arr，把遍历到的每一个整数都转换为k进制数，然后与eO进行无进位相加。
  // - 遍历结束时，把 32位的k进制数eORes 转换为十进制数就是想要的结果。
  // - 因为k个相同的k进制数无进位相加，结果一定是每一位上都是0的k进制数，所以只出现一次的那个数最终就会剩下来。
  private static int findOnce(int[] arr, int k) {
    int[] eO = new int[32];
    for (int i = 0; i < arr.length; i++) {
      noCarryAccumulation(eO, arr[i], k);
    }
    return fromK(eO, k);
  }

  // 无进位累加
  private static void noCarryAccumulation(int[] eO, int value, int k) {
    int[] valueToK = toK(value, k);
    for (int i = 0; i < eO.length; i++) {
      eO[i] = (eO[i] + valueToK[i]) % k;
    }
  }

  // 10进制数字转为k进制数组
  // 数组：[0]是最低位，然后往上堆
  private static int[] toK(int value, int k) {
    int[] res = new int[32];
    int index = 0;
    while (value != 0) {
      res[index++] = value % k;
      value = value / k;
    }
    return res;
  }

  // k进制数组转10进制数字
  private static int fromK(int[] arr, int k) {
    int res = 0;
    for (int i = arr.length - 1; i >= 0; i--) {
      res = res * k + arr[i];
    }
    return res;
  }
}

