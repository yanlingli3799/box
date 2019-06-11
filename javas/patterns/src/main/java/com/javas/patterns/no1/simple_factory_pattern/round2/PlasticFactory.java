package com.javas.patterns.no1.simple_factory_pattern.round2;

/**
 * Created by liyanling on 2018/11/15.
 */
public class PlasticFactory {


  public static Plastic manufacture(String name) throws Exception{
   switch (name){
     case PlasticCup.name:{
       return new PlasticCup();
     }
     case PlasticBottle.name:{
       return new PlasticBottle();
     }
     case PlasticBucket.name:{
       return new PlasticBucket();
     }
     default:{
       throw new Exception("不支持");
     }
   }
  }

}
