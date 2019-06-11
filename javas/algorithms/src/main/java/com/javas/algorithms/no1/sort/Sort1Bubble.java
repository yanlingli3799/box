package com.javas.algorithms.no1.sort;

import java.util.Arrays;


/*

参考：
- [百度百科-冒泡排序](https://baike.baidu.com/item/%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F/4602306?fr=aladdin)

关键点：
1. 两层循环的方向，也就是先冒大的还是先冒小的。
2. 相邻元素的交换条件，也就是大或小的的往哪个方向冒。

复杂度：
- 时间复杂度（平均）：O(n*n)
- 时间复杂度（最坏）：O(n*n)
- 时间复杂度（最好）：O(n)
- 空间复杂度：O(1)
- 稳定性：稳定

思考：
- 为啥最好时间复杂度是O(n)？
    - 优化：若某一趟冒泡没发生过元素交换，则表示已经是有序的，不需要再冒泡。
    - 则：数组元素已有序的情况下，可达到最好时间复杂度


 */
public class Sort1Bubble {

  public static void main(String[] args) {

    // 先右冒泡排序（先把大的冒泡到右边）
    int[] arr1 = {1, 4, 6, 2, 7, 2, 10, 34, 23};
    System.out.println("sortBubbleRightFirst 排序前：" + Arrays.toString(arr1));
    sortBubbleRightFirst(arr1);
    System.out.println("sortBubbleRightFirst 排序后：" + Arrays.toString(arr1));
    System.out.println("--------------------------------------");

    // 先右冒泡排序优化
    int[] arr2 = {1, 4, 6, 2, 7, 2, 10, 34, 23};
    System.out.println("sortBubbleRightFirstOptimized 排序前：" + Arrays.toString(arr2));
    sortBubbleRightFirstOptimized(arr2);
    System.out.println("sortBubbleRightFirstOptimized 排序后：" + Arrays.toString(arr2));
    System.out.println("--------------------------------------");

    // 先左冒泡排序
    int[] arr3 = {1, 4, 6, 2, 7, 2, 10, 34, 23};
    System.out.println("sortBubbleLeftFirst 排序前：" + Arrays.toString(arr3));
    sortBubbleLeftFirst(arr3);
    System.out.println("sortBubbleLeftFirst 排序后：" + Arrays.toString(arr3));
    System.out.println("--------------------------------------");

    // 先左冒泡优化，略

  }


  /**
   * 冒泡排序，从左往右先冒大的：
   * 1. 第一轮，arr[0]和arr[1]比，arr[1]和arr[2]比......arr[len-2]和arr[len-1]比，冒出个最大的到arr[len-1]。
   * 2. 第二轮，arr[0]和arr[1]比，arr[1]和arr[2]比......arr[len-3]和arr[len-2]比，冒出个次大的到arr[len-2]。
   * 3. ......
   * 4. 最后一轮，剩arr[0]，是最小的。
   * <p>
   * 每一轮对比的元素示意图：
   * - - - - -
   * - - - -
   * - - -
   * - -
   * -
   * <p>
   * 注意：j+1 不能越界。
   *
   * @param arr
   */
  public static void sortBubbleRightFirst(int[] arr) {
    if (arr.length <= 1) {
      System.out.println("len of arr <=1,already ranged");
      return;
    }

    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int tmp = arr[j + 1];
          arr[j + 1] = arr[j];
          arr[j] = tmp;
        }
      }
      System.out.println("arr=" + Arrays.toString(arr) + " when i=" + i);
    }
  }


  // 优化
  private static void sortBubbleRightFirstOptimized(int[] arr) {
    if (arr.length <= 1) {
      System.out.println("len of arr <=1,already ranged");
      return;
    }

    boolean canStop;// 标识是否可以停止冒泡了
    for (int i = 0; i < arr.length - 1; i++) {
      canStop = true;
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int tmp = arr[j + 1];
          arr[j + 1] = arr[j];
          arr[j] = tmp;
          canStop = false;
        }
      }
      System.out.println("arr=" + Arrays.toString(arr) + " when i=" + i);
      if (canStop) {
        System.out.println("can stop bubble when i=" + i);
        return;
      }
    }
  }

  /**
   * 冒泡排序，从右往左先冒小的：
   * 1. 第一轮，arr[len-1]和arr[len-2]比，arr[len-2]和arr[len-3]比......arr[1]和arr[0]比，冒出个最小的到 arr[0]。
   * 2. 第二轮，arr[len-1]和arr[len-2]比，arr[len-2]和arr[len-3]比......arr[2]和arr[1]比，冒出个次小的到 arr[1]。
   * 3. ......
   * 4. 最后一轮，剩 arr[len-1]，是最大的。
   * <p>
   * 每一轮对比的元素示意图：
   * - - - - -
   * - - - -
   * - - -
   * - -
   * -
   * <p>
   * 注意：j-1 不能越界。
   *
   * @param arr
   */
  public static void sortBubbleLeftFirst(int[] arr) {
    if (arr.length <= 1) {
      System.out.println("len of arr <=1,already ranged");
      return;
    }

    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = arr.length - 1; j > i; j--) {
        if (arr[j] < arr[j - 1]) {
          int tmp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = tmp;
        }
      }
      System.out.println("arr=" + Arrays.toString(arr) + " when i=" + i);
    }
  }


}
