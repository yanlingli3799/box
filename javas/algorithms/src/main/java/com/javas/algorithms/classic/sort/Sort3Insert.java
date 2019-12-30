package com.javas.algorithms.classic.sort;

import java.util.Arrays;

/*

参考：
- [百度百科-插入排序](https://baike.baidu.com/item/%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F/7214992?fr=aladdin)

关键点：
1. 从哪个方向开始，即从哪开始认为是有序的。
2. 元素交换条件和停止时机，即什么时候做元素交换及什么时候停止元素交换。

复杂度：
- 时间复杂度（平均）：O(n*n)
- 时间复杂度（最坏）：O(n*n)
- 时间复杂度（最好）：O(n)
- 空间复杂度：O(1)
- 稳定性：稳定

思考：
- 为啥最好时间复杂度是O(n)？=>若已经是有序的，则每趟插入排序都不需要交换元素，直接进到下一轮了。

 */
public class Sort3Insert {

  public static void main(String[] args) {

    // 左侧有序简单插入排序（左侧有序，向右扩展）
    int[] arr1 = {1, 4, 6, 2, 7, 2, 10, 34, 23};
    System.out.println("sortInsertFromLeft 排序前：" + Arrays.toString(arr1));
    sortInsertFromLeft(arr1);
    System.out.println("sortInsertFromLeft 排序后：" + Arrays.toString(arr1));
    System.out.println("--------------------------------------");

    // 右侧有序简单插入排序，略

    // 二分插入排序，略（太麻烦了）

  }


  /**
   * 左侧简单插入排序
   * 1、i：0->n-1。
   * 2、j=i+1，j前面的都认为是有序的，若 arr[j] < arr[j-1] 则交换元素位置，直到没有元素交换为止。
   */
  public static void sortInsertFromLeft(int[] arr) {
    if (arr.length <= 1) {
      System.out.println("len of arr <=1,already ranged");
      return;
    }
    for (int i = 0; i < arr.length - 1; i++) {
      int j = i + 1;
      while (j > 0 && (arr[j] < arr[j - 1])) {
        swap(arr, j, j - 1);
        j--;
      }
      System.out.println("arr=" + Arrays.toString(arr) + " when i=" + i);
    }
  }


  public static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
