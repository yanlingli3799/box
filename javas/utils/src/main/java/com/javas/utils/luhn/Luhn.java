package com.javas.utils.luhn;

public class Luhn {
  /**
   * Luhn算法（可用于校验银行卡号）
   *
   * 注意：
   * com.javas.utils.luhn 算法能搞定大部分的银行卡校验，但是有一些银行卡卡号编码时就没按luhn的规则来，验不过也没办法
   * 所以，com.javas.utils.luhn 能告诉你"这个卡号没有通过luhn校验，可能是错的"，但不能保证"不符合luhn的就一定是错的"
   */
  //

  public static boolean luhn(String cardNo){

    int sum = 0;

    // 从右向左，奇数位相加
    for(int i = cardNo.length()-1 ; i>=0;i-=2){
      sum += Integer.valueOf(String.valueOf(cardNo.charAt(i)));
    }

    // 从右向左，偶数位*2%9，相加
    for(int i = cardNo.length()-2 ; i>=0;i-=2){
      sum += (Integer.valueOf(String.valueOf(cardNo.charAt(i)))*2)%9;
    }

    // 加和取余10
    return 0 == sum % 10;
  }


}
