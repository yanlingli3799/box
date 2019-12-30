package com.javas.algorithms.leetcode;

import java.util.List;

/**
 * 例题2：https://leetcode-cn.com/problems/word-ladder/
 */
public class Leetcode_127 {

  public static void main(String[] args) {

    System.out.println(dist1("abc","abx"));
    System.out.println(dist1("abc","axc"));
    System.out.println(dist1("abc","xbc"));
    System.out.println(dist1("axc","xbc"));
    System.out.println(dist1("xbc","xbc"));
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {



      return 0;

  }

  // 判断两个字符串是不是只相差一个字符
  public static boolean dist1(String A,String B){
    if(A.length()!=B.length()){
      return false;
    }
    int times = 0;
    for(int i=0;i<A.length();i++){
      if(A.charAt(i) !=B.charAt(i)){
        times++;
        if(times>1){
          return false;
        }
      }
    }
    return times == 1;
  }


}
