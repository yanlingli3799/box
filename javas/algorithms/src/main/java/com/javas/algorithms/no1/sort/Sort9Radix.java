package com.javas.algorithms.no1.sort;

import java.util.Arrays;

/*

基数排序
- [百度百科-基数排序](https://baike.baidu.com/item/%E5%9F%BA%E6%95%B0%E6%8E%92%E5%BA%8F/7875498?fr=aladdin)

基数排序（radix sort），属于"分配式排序"（distribution sort），又称"桶子法"（bucket sort）或 bin sort。

基数排序有两种实现：
- 最低位优先(Least Significant Digit first)法，简称 LSD 法：
  - 先从 kd 开始排序，再对 kd-1 进行排序。
  - 依次重复，直到对 k1 排序后便得到一个有序序列。
  - 适用于位数小的序列。
- 最高位优先(Most Significant Digit first)法，简称 MSD 法：
  - 先按 k1 排序分组，同一组中记录，关键码 k1 相等，再对各组按 k2 排序分成子组。
  - 之后，对后面的关键码继续这样的排序分组，直到按最次位关键码 kd 对各子组排序后。
  - 再将各组连接起来，便得到一个有序序列。


注意：
- 个位=1，十位=2，百位=3，千位=4.
- 取一个数字的指定位数，公式：x/pow(10,index-1)%10。
- 除数 = 10 的 (index-1) 次方
- 个位数：x/1%10，百位数：x/10%10，千位数：x/100%10，万位数：x/1000%10


 */
public class Sort9Radix {

  public static void main(String[] args) {
    int[] arr1 = {1, 3, 4, 5, 2, 6, 9, 7, 8, 0};
    System.out.println("sortRadixLSD 前：" + Arrays.toString(arr1));
    sortRadixLSD(arr1);
    System.out.println("sortRadixLSD 后：" + Arrays.toString(arr1));
    System.out.println("---------------------------------------");

    int[] arr2 = {14, 22, 28, 39, 43, 55, 65, 73, 81, 93};
    System.out.println("sortRadixLSD 前：" + Arrays.toString(arr2));
    sortRadixLSD(arr2);
    System.out.println("sortRadixLSD 后：" + Arrays.toString(arr2));
  }

  // LSD 基数排序
  public static void sortRadixLSD(int[] arr) {

    // 1. 获取所有数字的"最大位数宽度"
    int digitWidth = getWidth(arr);

    // 2. counter[i] 用来表示该位为 i 的数的个数，i 范围：0-9。bucket[i][xxx]用来表示数组中该位为 i 的第 xxx 个数字。
    int[] counter = new int[10];
    int[][] bucket = new int[10][arr.length];

    // 3. 从 1->"最大位数宽度" LSD 取各位数字。
    int index = 1;
    while (index <= digitWidth) {

      // 数组中的每个元素取余，然后往 tmp 和 order 里塞。
      int divisor = (int) Math.pow(10, index - 1); // 除数
      for (int element : arr) {
        int remainder = element / divisor % 10;
        bucket[remainder][counter[remainder]] = element;
        counter[remainder]++;
      }

      // 从 bucket 里顺序取数，塞到 arr 里。
      int arrIndex = 0;
      for (int i = 0; i < counter.length; i++) {
        if (counter[i] != 0) {
          for (int j = 0; j < counter[i]; j++) {
            arr[arrIndex++] = bucket[i][j];
          }
        }
        counter[i]=0;// 要记得清零，不然下一趟会受影响
      }

      System.out.println("LSD index="+index+",arr="+Arrays.toString(arr));
      index++; // 别忘了 index++
    }

  }

  public static int getWidth(int[] arr) {
    int width = 0;
    for (int ele : arr) {
      width = Math.max(width, ("" + ele).length());
    }
    return width;
  }

}
