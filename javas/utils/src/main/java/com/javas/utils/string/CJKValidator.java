package com.javas.utils.string;

public class CJKValidator {


  /**
   * CJK = Chinese & Japanese & Korean
   *
   * unicode：
   * http://www.unicode.org/charts/
   *
   * Character.UnicodeBlock 说明：
   * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.UnicodeBlock.html
   *
   * Character.UnicodeScript 说明：
   * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.UnicodeBlock.html
   *
   *
   */


  // 全部是汉字（仅文字，不包括标点符号）
  public static boolean isAllCJKLetter(String strName) {
    char[] ch = strName.toCharArray();
    for (char c : ch) {
      if (!isCJKLetter(c)) {
        return false;
      }
    }
    return true;
  }



  // 汉字文字（不包含符号）
  private static boolean isCJKLetter(char c){
    Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
    return Character.isDefined(c) && ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS;
  }



  // 全部是汉字（汉字文字+符号）
  public static boolean isAllCJK(String strName) {
    char[] ch = strName.toCharArray();
    for (char c : ch) {
      if (!isCJK(c)) {
        return false;
      }
    }
    return true;
  }

  // 汉字（文字+符号）
  private static boolean isCJK(char c){
    Character.UnicodeScript uc = Character.UnicodeScript.of(c);
    return Character.isDefined(c) && uc == Character.UnicodeScript.HAN;
  }

}
