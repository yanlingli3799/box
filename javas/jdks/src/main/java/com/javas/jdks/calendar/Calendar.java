package com.javas.jdks.calendar;

public class Calendar {

  public static void main(String[] args) {
    java.util.Calendar calendar = java.util.Calendar.getInstance();
    int year = calendar.get(java.util.Calendar.YEAR);
    int month = calendar.get(java.util.Calendar.MONTH); // java的月份是从0开始的
    int date = calendar.get(java.util.Calendar.DATE);
    int year_10 = year + 10;
    System.out.println("年：" + year);
    System.out.println("月：" + month);
    System.out.println("日：" + date);
    System.out.println("当前时间：" + calendar.getTime());
    calendar.set(year_10, month, date);
    System.out.println("当前时间10年后："+calendar.getTime());
  }

}
