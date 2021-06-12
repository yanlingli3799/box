package com.javas.jdks.maps;

import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
  public static void main( String[] args )
  {

    ConcurrentHashMap<Integer,Integer> cMap = new ConcurrentHashMap<Integer, Integer>();

    cMap.put(1,1);
    cMap.put(2,2);
    cMap.put(3,3);
    cMap.put(4,4);
    cMap.put(5,5);
    cMap.put(6,6);
    cMap.get(3);

    System.out.println( cMap.toString());


  }
}
