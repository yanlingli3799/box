package com.javas.utils.identity;

import java.util.ArrayList;
import java.util.List;

public class IdNoValidator {

  private static int LEN_18 = 18;

  // 18位身份证号的权值

  private static int power_18[] = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1};


  /**
   * 18位身份证号校验
   *
   * @param idNo18
   * @return
   */
  public static boolean verifyIdNo18(String idNo18) {
    List<Integer> list = idNo18ToArrayList(idNo18);
    if (null == list) {
      return false;
    }

    if (list.size() != power_18.length) {
      return false;
    }

    int sum = calcIdNo18Sum(list);
    return sum % 11 == 1;
  }


  // 计算18为身份证号加权和
  private static int calcIdNo18Sum(List<Integer> idNo18) {
    int sum = 0;

    for (int i = 0; i < idNo18.size(); i++) {
      sum += power_18[i] * idNo18.get(i);
    }
    return sum;
  }

  // 18位身份证号正则格式检查
  private static boolean matchIdNo18Reg(String idNo18) {
    String reg = "[0-9]{17}[0-9,x,X]{1}";
    return idNo18.matches(reg);
  }


  // 计算18位身份证号最后一位数字
  private static int parseIdNo18LastChar(char c) {
    if (c == 'X' || c == 'x') {
      return 10;
    }
    return Integer.parseInt(String.valueOf(c));
  }


  // 18位身份证号（string字符串）转 ArrayList（x=10）
  private static List<Integer> idNo18ToArrayList(String idNo18) {

    if (idNo18.length() != LEN_18) {
      return null;
    }

    if (!matchIdNo18Reg(idNo18)) {
      return null;
    }

    List<Integer> list = new ArrayList<>();

    // 前17位
    String idNo17 = idNo18.substring(0, 17);
    for (int i = 0; i < idNo17.length(); i++) {
      list.add(Integer.parseInt(String.valueOf(idNo17.substring(i, i + 1))));
    }

    // 最后一位
    list.add(parseIdNo18LastChar(idNo18.charAt(LEN_18 - 1)));

    return list;
  }




}
