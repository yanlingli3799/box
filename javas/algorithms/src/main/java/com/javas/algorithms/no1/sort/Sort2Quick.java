package com.javas.algorithms.no1.sort;

import java.util.Arrays;

/*

参考：
- [百度百科-快速排序](https://baike.baidu.com/item/%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95/369842?fr=aladdin)
- [快速排序（三种算法实现和非递归实现）](https://blog.csdn.net/qq_36528114/article/details/78667034)

关键点：
1. 中位数的选择。
2. 元素交换的交换时机。

复杂度：
- 时间复杂度（平均）：O(n*log2n)
- 时间复杂度（最坏）：O(n*n)
- 时间复杂度（最好）：O(n*log2n)
- 空间复杂度：O(n*log2n)
- 稳定性：不稳定

 */
public class Sort2Quick {

  public static void main(String[] args) {

    // 快速排序-取左挖坑法（取左侧元素为中位数，从右侧开始挖坑）
    int[] arr1 = {5, 4, 6, 1, 7, 2, 10, 34, 23, 19, 19};
    System.out.println("sortQuickHoleFromLeft 排序前：" + Arrays.toString(arr1));
    sortQuickHoleFromLeft(arr1);
    System.out.println("sortQuickHoleFromLeft 排序后：" + Arrays.toString(arr1));

    // 快速排序-取右挖坑法（取右侧元素为中位数，从左侧开始挖坑）
    int[] arr2 = {5, 4, 6, 1, 7, 2, 10, 34, 23, 19, 19};
    System.out.println("sortQuickHoleSelectRight 排序前：" + Arrays.toString(arr2));
    sortQuickHoleSelectRight(arr2);
    System.out.println("sortQuickHoleSelectRight 排序后：" + Arrays.toString(arr2));

    // 快速排序-取左前后指针法
    int[] arr3 = {5, 4, 6, 1, 7, 2, 10, 34, 23, 19, 19};
    System.out.println("sortQuickPointerSelectLeft 排序前：" + Arrays.toString(arr3));
    sortQuickPointerSelectLeft(arr3);
    System.out.println("sortQuickPointerSelectLeft 排序后：" + Arrays.toString(arr3));

    // 快速排序-取右前后指针法

    // 非递归方式，略（用栈保存子区间范围）

  }


  /**
   * 快速排序（取左挖坑法）
   * <p>
   * 一次排序的逻辑：
   * 1. 选最左元素为中位数，key = arr[left]。
   * 2. 先从右向左（right--）找符合 arr[right] < key 条件的元素，令 arr[left] = arr[right]，此前 arr[left] 保存到了 key，arr[right] 占了 arr[left] 的坑。
   * 3. 再从左向右（left++） 找符合 arr[left] > key 条件的元素，令 arr[right] = arr[left]，arr[left] 占 arr[right] 的坑。
   * 4. 如此循环，直到 left>=right 为止。
   * 5. 最后，令 arr[left] = key。
   * <p>
   * PS：你会发现，最早是把中位数挖出来单独放，然后每次循环都把反向的元素拿出来填坑，最后空出来的坑就是中位数应该在的位置。
   */
  public static void sortQuickHoleFromLeft(int[] arr) {
    if (arr.length <= 1) {
      System.out.println("len of arr <=1,already ranged");
      return;
    }
    int left = 0;
    int right = arr.length - 1;
    sortQuickHoleFromLeft(arr, left, right);
  }

  private static void sortQuickHoleFromLeft(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }
    int mid = sortQuickHoleFromLeftOnce(arr, left, right);
    sortQuickHoleFromLeft(arr, left, mid - 1);
    sortQuickHoleFromLeft(arr, mid + 1, right);
  }

  public static int sortQuickHoleFromLeftOnce(int[] arr, int left, int right) {
    // 取最左元素做中位数
    int key = arr[left];
    // 先从右向左扫描，再从左向右扫描
    while (left < right) {
      while (left < right && arr[right] >= key) {
        right--;
      }
      arr[left] = arr[right];
      while (left < right && arr[left] <= key) {
        left++;
      }
      arr[right] = arr[left];
    }
    arr[left] = key;
    return left;
  }


  /**
   * 快速排序（取右挖坑法）
   * <p>
   * 和向左挖坑法的区别是：
   * 1. 取元素的位置相反
   * 2. 扫描方向相反
   */
  public static void sortQuickHoleSelectRight(int[] arr) {
    if (arr.length <= 0) {
      System.out.println("len of arr <=1,already ranged");
      return;
    }
    int left = 0;
    int right = arr.length - 1;
    sortQuickHoleSelectRight(arr, left, right);
  }

  private static void sortQuickHoleSelectRight(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }
    int mid = sortQuickHoleSelectRightOnce(arr, left, right);
    sortQuickHoleSelectRight(arr, left, mid - 1);
    sortQuickHoleSelectRight(arr, mid + 1, right);
  }

  public static int sortQuickHoleSelectRightOnce(int[] arr, int left, int right) {
    int key = arr[right];
    while (left < right) {
      while (left < right && arr[left] <= key) {
        left++;
      }
      arr[right] = arr[left];
      while (left < right && arr[right] >= key) {
        right--;
      }
      arr[left] = arr[right];
    }
    arr[right] = key;
    return right;
  }


  /**
   * 快速排序（取左双指针法）
   * 与挖坑法不同的是，同时找到 < key 和 > key 的 两个元素，然后交换。
   * 最后再把 key 交换到中间合适的位置去。
   */
  public static void sortQuickPointerSelectLeft(int[] arr) {
    if (arr.length <= 1) {
      System.out.println("len of arr <=1,already ranged");
      return;
    }
    int left = 0;
    int right = arr.length - 1;
    sortQuickPointerSelectLeft(arr, left, right);
  }

  private static void sortQuickPointerSelectLeft(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }
    int mid = sortQuickPointerSelectLeftOnce(arr, left, right);
    sortQuickPointerSelectLeft(arr, left, mid - 1);
    sortQuickPointerSelectLeft(arr, mid + 1, right);
  }

  public static int sortQuickPointerSelectLeftOnce(int[] arr, int left, int right) {
    int start = left;
    int key = arr[left];
    while (left < right) {
      while (left < right && arr[right] >= key) {
        right--;
      }
      while (left < right && arr[left] <= key) {
        left++;
      }
      swap(arr, left, right);
    }
    // 因为前面是最左取的中位数，所以要把中位数丢到中间，然后小于中位数的那个丢到最左去
    swap(arr, left, start);
    return left;
  }

  public static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }


}
