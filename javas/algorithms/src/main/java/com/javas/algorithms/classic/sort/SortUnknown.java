package com.javas.algorithms.classic.sort;

import java.util.Arrays;

/*

感觉像是冒泡和选择的结合体

 */

public class SortUnknown {


  public static void main(String[] args) {

    int[] arr1 = {1, 4, 6, 2, 7, 2, 10, 34, 23};
    System.out.println("toLeft排序前：" + Arrays.toString(arr1));
    sortToLeft(arr1);
    System.out.println("toLeft排序后：" + Arrays.toString(arr1));

    int[] arr2 = {1, 4, 6, 2, 7, 2, 10, 34, 23};
    System.out.println("toRight排序前：" + Arrays.toString(arr2));
    sortToRight(arr2);
    System.out.println("toRight排序后：" + Arrays.toString(arr2));

  }

  /**
   * 从右往左先冒小的，则：
   * 1. 第一轮是 从 arr[0] VS arr[1]~arr[len-1] 逐个对比，冒个最小的出来 放在 arr[0]。
   * 2. 第二轮是 从 arr[1] VS arr[2]~arr[len-1] 逐个对比，冒个次小的出来 放在 arr[1]。
   * 3. ......
   * 4. 最后一轮就剩下 arr[len-1] 自己了，它就是最大的
   *
   * @param arr
   */

  public static void sortToLeft(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] > arr[j]) {
          int tmp = arr[j];
          arr[j] = arr[i];
          arr[i] = tmp;
        }
      }
    }
  }

  /**
   * 从左往右先冒大的，则：
   * 1. 第一轮是 从 arr[len-1] VS arr[len-2]~arr[0] 逐个对比，冒个最大的到 arr[len-1]。
   * 2. 第二轮是 从 arr[len-2] VS arr[len-3]~arr[0] 逐个对比，冒个次大的到 arr[len-2]。
   * 3. ......
   * 4. 最后一轮就剩下 arr[0] 自己，它就是最小的
   *
   * @param arr
   */
  public static void sortToRight(int[] arr) {
    for (int i = arr.length - 1; i >= 0; i--) {
      for (int j = i - 1; j >= 0; j--) {
        if (arr[i] < arr[j]) {
          int tmp = arr[j];
          arr[j] = arr[i];
          arr[i] = tmp;
        }
      }
    }
  }



}
