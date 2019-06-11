package com.javas.patterns.no12.flyweight.round1;

public class Client {

  public static void main(String[] args) {

    SyllabusFactory.addSyllabusFor("小明");
    SyllabusFactory.addSyllabusFor("小明");

    SyllabusFactory.addSyllabusFor("大熊");

    SyllabusFactory.addSyllabusFor("兰兰");
    SyllabusFactory.addSyllabusFor("兰兰");
    SyllabusFactory.addSyllabusFor("兰兰");
    SyllabusFactory.addSyllabusFor("兰兰");

    System.out.println("RealSubject 中课程表数目：" + SyllabusFactory.size());
    System.out.println("RealSubject 中课程表所有人名单：" + SyllabusFactory.forNames());
    System.out.println("----------------------");

    System.out.println("兰兰的课程表：");
    SyllabusFactory.getSyllabusFor("兰兰").showAllCourses();

    System.out.println("大熊的课程表：");
    SyllabusFactory.getSyllabusFor("大熊").showAllCourses();

    System.out.println("小明的课程表：");
    SyllabusFactory.getSyllabusFor("小明").showAllCourses();

    SyllabusFactory.getSyllabusFor("兰兰").addElectiveCourses("自然");
    SyllabusFactory.getSyllabusFor("大熊").addElectiveCourses("物理");

    System.out.println("----------------------");
    System.out.println("兰兰的课程表：");
    SyllabusFactory.getSyllabusFor("兰兰").showAllCourses();

    System.out.println("大熊的课程表：");
    SyllabusFactory.getSyllabusFor("大熊").showAllCourses();

    System.out.println("小明的课程表：");
    SyllabusFactory.getSyllabusFor("小明").showAllCourses();


  }

}
