package com.javas.patterns.visitor.round1;

/**
 * Created by liyanling on 2018/11/3.
 * <p>
 * 化妆品店
 */
public class MerchantCosmetic {

  public void view(PersonMale male) {
    System.out.println("化妆品店，关注男士是否单身...");
  }

  public void view(PersonFemale female) {
    System.out.println("化妆品店，关注女士年龄段...");
  }
}
