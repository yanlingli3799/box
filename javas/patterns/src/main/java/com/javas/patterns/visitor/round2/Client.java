package com.javas.patterns.visitor.round2;

/**
 * Created by liyanling on 2018/11/3.
 */
public class Client {


  public static void main(String[] args){

    PersonMale male = buildMale();
    PersonFemale female = buildFemale();

    IMerchant cosmetic = new MerchantCosmetic();
    IMerchant game = new MerchantGame();

    System.out.println("--甲方：商店----------");

    cosmetic.view(male);
    cosmetic.view(female);

    game.view(male);
    game.view(female);

    System.out.println("--甲方：客人----------");

    male.accept(cosmetic);
    male.accept(game);

    female.accept(cosmetic);
    female.accept(game);

  }



  public static PersonMale buildMale(){
    PersonMale male = new PersonMale();
    male.setIndustry("挖掘机");
    male.setAge(23);
    male.setInterests(null);
    male.setSingle(false);
    return male;
  }

  public static PersonFemale buildFemale(){
    PersonFemale female = new PersonFemale();
    female.setIndustry("互联网");
    female.setAge(18);
    female.setInterests(null);
    return female;
  }

}
