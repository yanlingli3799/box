package com.javas.algorithms.no4.yuesu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 例题1：统计一句话中各个单词的出现次数 按照出现次数由大至小输出
 * 思路：
 * - 构建邻接表
 * - 构建逆邻接表
 */
public class ProblemDemo1 {
  public static void main(String[] args){
    times("a b b c c");
  }

  // 统计出现次数
  private static void times(String str){
    String[] arr = str.split(" ");

    // 1. 统计各个单词的出现次数
    Map<String,Integer> map = new HashMap<>();
    int maxLen = 0;
    for (String s:arr) {
      map.put(s,null==map.get(s)?1:map.get(s)+1);
      maxLen = Math.max(maxLen,map.get(s));
    }

    // 2. 逆转
    List<String>[] lists = new ArrayList[maxLen];
    for (String key: map.keySet()) {
      int times = map.get(key) -1;// 次数是从1开始的
      List<String> list = lists[times];
      if(null == list){
        list = new ArrayList<>();
        lists[times]=list;
      }
      list.add(key);
    }


    // 3. 输出
    for (List<String> list : lists) {
      if (null != list) {
        for (String s:list) {
          System.out.print(s+" ");
        }
      }
    }

  }
}
