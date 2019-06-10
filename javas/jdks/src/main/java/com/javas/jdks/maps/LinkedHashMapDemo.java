package com.javas.jdks.maps;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {
  public static void main( String[] args )
  {



    // 插入序
    LinkedHashMap<Integer,Integer> mapFalse = new LinkedHashMap<Integer, Integer>(16, 0.75f, false);

    mapFalse.put(1,1);
    mapFalse.put(2,2);
    mapFalse.put(3,3);
    mapFalse.put(4,4);
    mapFalse.put(5,5);
    mapFalse.put(6,6);
    mapFalse.get(3);

    System.out.println( mapFalse.toString());


    // 访问序
    LinkedHashMap<Integer,Integer> mapTrue = new LinkedHashMap<Integer, Integer>(16, 0.75f, true);

    mapTrue.put(1,1);
    mapTrue.put(2,2);
    mapTrue.put(3,3);
    mapTrue.put(4,4);
    mapTrue.put(5,5);
    mapTrue.put(6,6);
    mapTrue.get(3);
    mapTrue.get(4);

    System.out.println( mapTrue.toString());
  }
}
