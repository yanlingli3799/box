package com.javas.patterns.visitor.round2;

/**
 * Created by liyanling on 2018/11/3.
 *
 * 游戏店
 */
public class MerchantGame implements IMerchant {


  @Override
  public void view(PersonMale male) {
    System.out.println("游戏店，欢迎所有男士");
  }

  @Override
  public void view(PersonFemale female) {
    System.out.println("游戏店，关注女士是否对游戏感兴趣");
  }
}
