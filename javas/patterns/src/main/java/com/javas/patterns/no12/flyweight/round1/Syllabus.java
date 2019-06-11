package com.javas.patterns.no12.flyweight.round1;

import java.util.ArrayList;
import java.util.List;

public class Syllabus implements ISyllabus {

  // 必修课
  private List<String> requiredCourses;

  // 选修课
  private List<String> electiveCourses;

  public Syllabus() {
    requiredCourses = new ArrayList<>();
    electiveCourses = new ArrayList<>();
    requiredCourses.add("数学");
    requiredCourses.add("语文");
    requiredCourses.add("英语");
  }

  @Override
  public void showAllCourses() {
    System.out.println("必修课："+requiredCourses);
    System.out.println("选修课："+electiveCourses);
  }

  @Override
  public void addElectiveCourses(String courseName) {
    electiveCourses.add(courseName);
  }

  @Override
  public void removeElectiveCoursed(String courseName) {
    electiveCourses.remove(courseName);
  }

}
