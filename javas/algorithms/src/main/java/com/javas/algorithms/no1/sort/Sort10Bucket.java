package com.javas.algorithms.no1.sort;

import java.util.Arrays;

/*

桶排序：
- [百度百科-桶排序](https://baike.baidu.com/item/%E6%A1%B6%E6%8E%92%E5%BA%8F/4973777)
- [经典排序思想-桶排序](https://blog.csdn.net/YinhJiang/article/details/80397415)

 */
public class Sort10Bucket {


  public static void main(String[] args) {
    int[] arr1 = {14, 22, 28, 39, 23, 15, 26, 28, 19, 20};
    System.out.println("sortBucket 前：" + Arrays.toString(arr1));
    sortBucket(arr1);
    System.out.println("sortBucket 后：" + Arrays.toString(arr1));
  }

  /**
   * 1. 先计算 arr 数组元素的最大值 max
   * 2. new 一个 max+1 长度的临时数组 bucket，并初始化（全0）。这个数组的索引 i=[0~max+1] 就是 arr 元素，值 bucket[i] 是 arr 元素出现的次数
   * 3. 遍历 arr 数组，更新 bucket。
   * 4. 遍历 bucket，得到有序表。注意：bucket[i]，i 是 arr 元素，bucket[i] 是这个元素出现的次数
   *
   * @param arr
   */
  private static void sortBucket(int[] arr) {

    int max = 0;
    for (int x : arr) {
      max = max > x ? max : x;
    }
    System.out.println("arr 数组最大值，max=" + max);

    int[] bucket = new int[max + 1];
    for (int i = 0; i < bucket.length; i++) {
      bucket[i] = 0;
    }
    System.out.println("初始，bucket=" + Arrays.toString(bucket));

    for (int x : arr) {
      bucket[x]++;
    }
    System.out.println("遍历 arr 填充 bucket 后，bucket=" + Arrays.toString(bucket));

    int index = 0;
    for (int i = 0; i < bucket.length; i++) {
      if (bucket[i] != 0) {
        int j = bucket[i];
        while (j > 0) {
          arr[index++] = i;
          j--;
        }
      }
    }
    System.out.println("遍历 bucket 获得有序数组，arr=" + Arrays.toString(arr));

  }


}
