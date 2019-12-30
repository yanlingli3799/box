package com.javas.algorithms.classic.sort;


import java.util.Arrays;

/*

希尔排序，又称"缩小增量排序"
- [百度百科-希尔排序](https://baike.baidu.com/item/%E5%B8%8C%E5%B0%94%E6%8E%92%E5%BA%8F/3229428?fr=aladdin)

关键点：
- gap 选取和缩小增量策略
- 确定 gap 的直接插入排序

复杂度：
- 时间复杂度（平均）：O(n的1.3次方)=>怎么算的？？？
- 时间复杂度（最坏）：O(n*n)
- 时间复杂度（最好）：O(n)
- 空间复杂度：O(1)
- 稳定性：不稳定

 */
public class Sort4Shell {


  public static void main(String[] args) {

    // 左侧有序希尔排序（左侧有序，向右扩展）
    int[] arr1 = {1, 4, 6, 2, 7, 2, 10, 34, 23};
    System.out.println("sortShellFromLeft 排序前：" + Arrays.toString(arr1));
    sortShellFromLeft(arr1);
    System.out.println("sortShellFromLeft 排序后：" + Arrays.toString(arr1));
    System.out.println("--------------------------------------");

  }


  // 直接插入排序可以看做是 gap=1 的情况，那希尔其实就是多几个gap值，多排序几次而已。
  public static void sortShellFromLeft(int[] arr) {
    if (arr.length <= 1) {
      System.out.println("len of arr <=1,already ranged");
      return;
    }
    // gap 随机取值，然后逐渐减小
    for (int gap = arr.length / 3; gap > 0; gap = gap / 2) {
      // 从这儿开始其实是把直接插入排序的 1 都换成了 gap
      for (int i = gap; i < arr.length - gap; i += gap) {
        int j = i + gap;
        while (j > 0 && (arr[j] < arr[j - gap])) {
          swap(arr, j, j - gap);
          j--;
        }
        System.out.println("arr=" + Arrays.toString(arr) + " when gap=" + gap + ",i=" + i);
      }
    }

  }


  public static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

}
