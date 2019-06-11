package com.javas.patterns.no12.flyweight.round1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SyllabusFactory {

  private static final Map<String, Syllabus> syllabusMap = new HashMap<>();


  public static Syllabus addSyllabusFor(String name) {
    Syllabus syllabus = syllabusMap.get(name);
    if (null == syllabus) {
      syllabus = new Syllabus();
      syllabusMap.put(name, syllabus);
    }
    return syllabus;
  }

  public static int size(){
    return syllabusMap.size();
  }

  public static Set<String> forNames(){
    return syllabusMap.keySet();
  }

  public static Syllabus getSyllabusFor(String name){
    return syllabusMap.get(name);
  }
}
