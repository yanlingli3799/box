package com.javas.algorithms.no4.yuesu;

import java.util.ArrayList;
import java.util.List;

/**
 * 例题3：(1.3.2.5.7）找到比左边大比右边小的数组下标，要求复杂度为n
 *
 * 分析：
 * - 所求数字，一定是某一个点的 "左边最大" && "右边最小"
 * - 这样的数字，可能不止一个
 */
public class ProblemDemo3 {

  public static void main(String[] args) {
    System.out.println(find(new int[]{1, 3, 2, 5, 7}));
  }

  private static List<Integer> find(int[] arr) {
    int len = arr.length;
    List<Integer> result = new ArrayList<>();

    // 边界处理
    if (len <= 0) {
      return result;
    }
    if (len == 1) {
      result.add(0);
      return result;
    }

    int[] leftMax = new int[len];

    // 1. 从左到右，统计左边最大。保存起来。
    int max = arr[0];
    for (int i = 0; i < len; i++) {
      max = Math.max(max, arr[i]);
      leftMax[i] = max;
    }

    // 2. 从右到左，统计右边最小。
    // 若当前位置的 左边最大 和 右边最小一样，则为所求。
    int min = arr[len - 1];
    for (int i = len - 1; i >= 0; i--) {
      min = Math.min(min, arr[i]);
      if (min == leftMax[i]) {
        result.add(i);
      }
    }

    return result;
  }
}
