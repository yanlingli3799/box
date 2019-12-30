package com.javas.algorithms.zuochengyun;

/**
 * Created by liyanling on 2019/2/13.
 * <p>
 * 题目：判断两个字符串是否互为旋转词
 */
public class Zuo_Chap_5_04 {

  public static void main(String[] args) {

    String tmpl = "s1=%s,s2=%s,是否互为旋转词：%s";

    String s1 = "123456";
    String s2 = "456123";
    System.out.print(String.format(tmpl, s1, s2, isRotation(s1, s2)));
  }

  private static boolean isRotation(String str1, String str2) {
    //任意一个为null 或长度不一样，则false
    if(null==str1 || null==str2 || str1.length() != str2.length()){
      return false;
    }

    String str222 = str2 + str2;
    // todo 如果有时间复杂度的限制，可以手动写一个方法判断 str222 中是否包含 str1 子串
    return str222.contains(str1);
  }
}
