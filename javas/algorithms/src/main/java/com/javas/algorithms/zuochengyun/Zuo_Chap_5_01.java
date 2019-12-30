package com.javas.algorithms.zuochengyun;


/**
 * Created by liyanling on 2019/2/10.
 * <p>
 * 题目：判断两个字符串是否互为变形词
 */
public class Zuo_Chap_5_01 {

  public static void main(String[] args) {

    String tmpl = "s1=%s,s2=%s,是否互为变形词：%s";

    String s1 = "123";
    String s2 = "321";
    System.out.print(String.format(tmpl, s1, s2, isDeformation(s1, s2)));
  }

  private static boolean isDeformation(String str1, String str2) {
    //任意一个为null 或长度不一样，则false
    if(null==str1 || null==str2 || str1.length() != str2.length()){
      return false;
    }

    // 索引是字符编码，值是字符出现的次数
    // 这里map长度写的256，如果字符种类比较多的话，256不够可以直接换成哈希表
    int[] map = new int[256];

    // str1 +
    for (int i = 0; i < str1.length(); i++) {
      char key = str1.charAt(i);
      map[key]++;
    }

    // str2 -，如果减不到，直接返回false
    for (int i = 0; i < str2.length(); i++) {
      char key = str2.charAt(i);
      map[key]--;
    }

    // 循环，只要有一个不是0，则直接返回false
    for (int a : map) {
      if (a != 0) {
        return false;
      }
    }
    return true;
  }
}
