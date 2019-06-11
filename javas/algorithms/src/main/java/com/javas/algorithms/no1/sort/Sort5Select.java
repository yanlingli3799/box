package com.javas.algorithms.no1.sort;

import java.util.Arrays;

/*

选择排序

关键点：
- 每次都是选中一个待排序元素里最小的
- 把选中元素放到有序数组的后面

复杂度：
- 时间复杂度（平均）：O(n*n)
- 时间复杂度（最坏）：O(n*n)
- 时间复杂度（最好）：O(n*n)
- 空间复杂度：O(1)
- 稳定性：不稳定

 */
public class Sort5Select {

  public static void main(String[] args) {

    // 左侧选择排序（从左侧开始放最小的，向右扩展）
    int[] arr1 = {1, 4, 6, 2, 7, 2, 10, 34, 23};
    System.out.println("sortSelectFromLeft 排序前：" + Arrays.toString(arr1));
    sortSelectFromLeft(arr1);
    System.out.println("sortSelectFromLeft 排序后：" + Arrays.toString(arr1));
    System.out.println("--------------------------------------");

    // 右侧选择排序，略

  }

  public static void sortSelectFromLeft(int[] arr) {
    if (arr.length <= 1) {
      System.out.println("len of arr <=1,already ranged");
      return;
    }
    for (int i = 0; i < arr.length; i++) {
      // 开始，认为 i 位置的为最小数
      int minIndex = i;
      int minValue = arr[i];
      // 从 i+1 开始找比 minValue 更小的值及其索引
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < minValue) {
          minIndex = j;
          minValue = arr[j];
        }
      }
      swap(arr, minIndex, i);
      System.out.println("arr=" + Arrays.toString(arr) + " when i=" + i);
    }
  }

  public static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

}
