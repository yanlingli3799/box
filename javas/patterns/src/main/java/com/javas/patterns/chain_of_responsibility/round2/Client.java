package com.javas.patterns.chain_of_responsibility.round2;

/**
 * Created by liyanling on 2018/11/10.
 */
public class Client {

  public static void main(String[] args) throws Exception{

    test1();
    test2();

  }

  public static void test1(){
    System.out.println("审批顺序：班长->任课老师->班主任->校长");

    // 班长
    LeaveHandler monitor = new LeaveHandlerMonitor();

    // 任课老师
    LeaveHandler classTeacher = new LeaveHandlerClassTeacher();

    // 班主任
    LeaveHandler classAdvisor = new LeaveHandlerClassAdvisor();

    // 校长
    LeaveHandler president = new LeaveHandlerPresident();


    // 顺序：班长->任课老师->班主任->校长
    monitor.setNext(classTeacher);
    classTeacher.setNext(classAdvisor);
    classAdvisor.setNext(president);

    System.out.println("-------------");
    LeaveRequest leaveRequest1 = new LeaveRequest(2,"上厕所");
    monitor.handle(leaveRequest1);

    System.out.println("-------------");
    LeaveRequest leaveRequest2 = new LeaveRequest(4,"输液");
    monitor.handle(leaveRequest2);

    System.out.println("-------------");
    LeaveRequest leaveRequest3 = new LeaveRequest(12,"回家割稻子");
    monitor.handle(leaveRequest3);

    System.out.println("-------------");
    LeaveRequest leaveRequest4 = new LeaveRequest(48,"阑尾炎手术");
    monitor.handle(leaveRequest4);

    System.out.println("-------------");
  }

  public static void test2(){
    System.out.println("审批顺序：班主任->校长");

    // 班主任
    LeaveHandler classAdvisor = new LeaveHandlerClassAdvisor();

    // 校长
    LeaveHandler president = new LeaveHandlerPresident();

    // 顺序：班主任->校长
    classAdvisor.setNext(president);

    System.out.println("-------------");
    LeaveRequest leaveRequest1 = new LeaveRequest(2,"上厕所");
    classAdvisor.handle(leaveRequest1);

    System.out.println("-------------");
    LeaveRequest leaveRequest2 = new LeaveRequest(4,"输液");
    classAdvisor.handle(leaveRequest2);

    System.out.println("-------------");
    LeaveRequest leaveRequest3 = new LeaveRequest(12,"回家割稻子");
    classAdvisor.handle(leaveRequest3);

    System.out.println("-------------");
    LeaveRequest leaveRequest4 = new LeaveRequest(48,"阑尾炎手术");
    classAdvisor.handle(leaveRequest4);

    System.out.println("-------------");
  }
}
