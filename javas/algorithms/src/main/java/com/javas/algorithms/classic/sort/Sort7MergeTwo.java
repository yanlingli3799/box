package com.javas.algorithms.classic.sort;

import java.util.Arrays;

/*

二路归并排序

二路归并排序主旨是“分解”与“归并”

分解：　　
1. 将一个数组分成两个数组，分别对两个数组进行排序。
2. 循环第一步，直到划分出来的“小数组”只包含一个元素，只有一个元素的数组默认为已经排好序。

归并：
1. 将两个有序的数组合并到一个大的数组中。
2. 从最小的只包含一个元素的数组开始两两合并。此时，合并好的数组也是有序的。

实现要点：
- 两个有序数组合并后还是有序数组的实现=>这两个有序数组是拼在一个数组里的。
- 将原始序列分为两块，利用递归分别对这两部分进行二路归并排序，然后将两个有序数组合并。
- 仅有一个元素时递归结束，即：start>=end

复杂度：
- 时间复杂度（平均）：O(n*log2n)
- 时间复杂度（最坏）：O(n*log2n)
- 时间复杂度（最好）：O(n*log2n)
- 空间复杂度：O(n)
- 稳定性：稳定

 */
public class Sort7MergeTwo {


  public static void main(String[] args) {

    int[] arr1 = {1, 3, 4, 5, 2, 6, 9, 7, 8, 0};
    System.out.println("sortMergeTwo 前：" + Arrays.toString(arr1));
    sortMergeTwo(arr1);
    System.out.println("sortMergeTwo 后：" + Arrays.toString(arr1));


  }


  // 二路归并排序
  public static void sortMergeTwo(int[] arr) {
    if (arr.length <= 1) {
      return;
    }
    int[] tmp = new int[arr.length];
    sortMergeTwo(arr, 0, arr.length - 1, tmp);
  }

  private static void sortMergeTwo(int[] arr, int start, int end, int[] tmp) {
    if (start >= end) {
      return;
    }
    int middle = (end + start) /2;
    sortMergeTwo(arr, start, middle, tmp);
    sortMergeTwo(arr, middle + 1, end, tmp);
    mergeTwo(arr, start, middle, end, tmp);
  }

  // 两个有序数组合并，合并后还是有序的
  private static void mergeTwo(int[] arr, int start, int middle, int end,int[] tmp) {

    // 第一个有序数组索引
    int i = start;

    // 第二个有序数组索引
    int j = middle + 1;

    // tmp 索引
    int index = start;

    // 小的放前面
    while ((i <= middle) && (j <= end)) {
      if (arr[i] >= arr[j]) {
        tmp[index++] = arr[j++];
      } else {
        tmp[index++] = arr[i++];
      }
    }

    // 剩下的直接最佳到 tmp 就行了
    while (i <= middle) {
      tmp[index++] = arr[i++];
    }
    while (j <= end) {
      tmp[index++] = arr[j++];
    }

    for (i = start; i <= end; i++) {
      arr[i] = tmp[i];
    }
    System.out.println("start="+start+",middle="+middle+",end="+end+",arr="+Arrays.toString(arr)+",tmp="+Arrays.toString(tmp));

  }


}
