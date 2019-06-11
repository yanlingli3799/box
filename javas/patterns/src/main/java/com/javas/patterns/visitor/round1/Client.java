package com.javas.patterns.visitor.round1;

/**
 * Created by liyanling on 2018/11/3.
 */
public class Client {

  public static void main(String[] args){

    PersonMale male = buildMale();
    PersonFemale female = buildFemale();

    MerchantCosmetic cosmetic = new MerchantCosmetic();
    MerchantGame game = new MerchantGame();

    cosmetic.view(male);
    cosmetic.view(female);

    game.view(male);
    game.view(female);

  }



  public static PersonMale buildMale(){
    PersonMale male = new PersonMale();
    male.setIndustry("木匠");
    male.setAge(23);
    male.setInterests(null);
    male.setSingle(false);
    return male;
  }

  public static PersonFemale buildFemale(){
    PersonFemale female = new PersonFemale();
    female.setIndustry("理发师");
    female.setAge(18);
    female.setInterests(null);
    return female;
  }
}
