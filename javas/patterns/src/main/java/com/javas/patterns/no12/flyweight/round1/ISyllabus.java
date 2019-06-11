package com.javas.patterns.no12.flyweight.round1;

public interface ISyllabus {

  // 展示所有课程
  void showAllCourses();

  // 增加选修课
  void addElectiveCourses(String courseName);

  // 移除选修课
  void removeElectiveCoursed(String courseName);
}
