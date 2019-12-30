package com.javas.algorithms.classic.sort;


import java.util.Arrays;

/*

堆排序：
- [百度百科-堆排序](https://baike.baidu.com/item/%E5%A0%86%E6%8E%92%E5%BA%8F/2840151?fr=aladdin)
- [排序六-堆排序](https://www.cnblogs.com/jingmoxukong/p/4303826.html)

要点：
1. 按堆的定义将数组R[0..n]调整为堆（这个过程称为创建初始堆——构建一个完全二叉树，保证所有的父结点都比它的孩子结点数值大），交换R[0]和R[n]；
2. 然后，将R[0..n-1]调整为堆，交换R[0]和R[n-1]；
3. 如此反复，直到交换了R[0]和R[1]为止。

关系
- 完全二叉树，其最后一个非叶节点是 R[n/2-1]【原因：若一根完全二叉树有n个节点，则n-1为最后一个叶子节点的下标，而完全二叉树中一个节点的父亲节点的下标为此节点下标减去1再除2.于是二叉树的最后一个非终端节点的下标就为(n-2)/2】
- 当前元素 R[i]，则：左孩子 R[2*i+1]，右孩子 R[2*i+2]，父节点 R[(i-1)/2]。
- Ri <= R2i+1 且 Ri <= R2i+2 (小顶堆)，不关心孩子节点的左右顺序
- Ri >= R2i+1 且 Ri >= R2i+2 (大顶堆)，不关心孩子节点的左右顺序

复杂度：
- 时间复杂度（平均）：O(n*log2n)
- 时间复杂度（最坏）：O(n*log2n)
- 时间复杂度（最好）：O(n*log2n)
- 空间复杂度：O(1)
- 稳定性：不稳定

 */
public class Sort6Heap {

  public static void main(String[] args) {

    // 大顶堆排序
    int[] arr1 = {4, 6, 8, 5, 9};
    System.out.println("sortBiggerHeapSort 前："+Arrays.toString(arr1));
    sortBiggerHeapSort(arr1);
    System.out.println("sortBiggerHeapSort 后："+Arrays.toString(arr1));
    System.out.println("------------------");

    int[] arr2 = {1, 3, 4, 5, 2, 6, 9, 7, 8, 0};
    System.out.println("sortBiggerHeapSort 前："+Arrays.toString(arr2));
    sortBiggerHeapSort(arr2);
    System.out.println("sortBiggerHeapSort 后："+Arrays.toString(arr2));
    System.out.println("------------------");

    // 小顶堆排序，略（需要辅助数组）

  }


  // 大顶堆堆排序
  public static void sortBiggerHeapSort(int[] arr) {
    System.out.println("原始堆：" + Arrays.toString(arr));

    if (arr.length <= 1) {
      return;
    }

    // i表示当前调整堆的父节点位置。
    for (int i = arr.length / 2 - 1; i >= 0; i--) {
      adjustLargeHeap(arr, i, arr.length);
    }
    System.out.println("初始大顶堆：" + Arrays.toString(arr));

    // j用来计数，也用来表示当前调整堆的最后一个元素的位置。
    for (int j = arr.length - 1; j > 0; j--) {
      swap(arr, 0, j); // 将堆顶元素与末尾元素进行交换
      adjustLargeHeap(arr, 0, j); // 重新对堆进行调整
      System.out.println("调整，j=" + j + "，arr=" + Arrays.toString(arr));
    }

  }


  // 调整以 parent 为父节点、以 length 为长度的堆为大顶堆
  public static void adjustLargeHeap(int[] arr, int parent, int length) {
    if (parent > arr.length || length > arr.length) {
      return;
    }
    // 大顶堆，父节点比字节点大，所以找子节点中较大的那一个和父节点比：
    // - 如果较大子节点<=父节点，则两个节点都<=父节点，不需要调整。
    // - 如果较大子节点>父节点，则将较大子节点和父节点交换即可，较小子节点不需要调整，因为它比较大子节点和父节点都要小。
    // 可以这么想：
    // - 其实是从1父2子中选最大的调整到上面，则可以先在子节点中选出较大的一个，再用较大的这一个和父节点对比，进行调整；
    // - 1次调整完成后，再以调整后的子节点为根节点进行子树的调整。
    int childBiggerIndex = parent * 2 + 1;

    while (childBiggerIndex < length) {
      // 选子节点中较大的那个
      if (childBiggerIndex + 1 < length && arr[childBiggerIndex + 1] > arr[childBiggerIndex]) {
        childBiggerIndex++;
      }

      // 若父节点>较大子节点，则已经是个大顶堆，不需要调整
      if (arr[parent] > arr[childBiggerIndex]) {
        return;
      }

      // 交换元素位置
      swap(arr, parent, childBiggerIndex);

      // 然后再从较大子节点的位置继续向下调整，length不变，但parent和childBiggerIndex需要变。
      parent = childBiggerIndex;
      childBiggerIndex = childBiggerIndex * 2 + 1;

    }
  }

  public static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }


}
