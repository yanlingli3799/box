package com.javas.patterns.chain_of_responsibility.round1;

public class Client {

  public static void main(String[] args){
    LeaveHandler handler = new LeaveHandler();

    System.out.println("-------------");
    LeaveRequest leaveRequest1 = new LeaveRequest(2,"上厕所");
    handler.canLeave(leaveRequest1);

    System.out.println("-------------");
    LeaveRequest leaveRequest2 = new LeaveRequest(4,"输液");
    handler.canLeave(leaveRequest2);

    System.out.println("-------------");
    LeaveRequest leaveRequest3 = new LeaveRequest(12,"回家割稻子");
    handler.canLeave(leaveRequest3);

    System.out.println("-------------");
    LeaveRequest leaveRequest4 = new LeaveRequest(48,"阑尾炎手术");
    handler.canLeave(leaveRequest4);
  }

}
