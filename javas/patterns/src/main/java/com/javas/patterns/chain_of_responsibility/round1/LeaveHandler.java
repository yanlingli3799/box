package com.javas.patterns.chain_of_responsibility.round1;

public class LeaveHandler {

  public boolean canLeave(LeaveRequest leaveRequest) {
    if (leaveRequest.getLeaveHour() <= 2) {
      System.out.println("课任老师审批通过：" + leaveRequest);
      return true;
    } else if (leaveRequest.getLeaveHour() <= 24) {
      System.out.println("班主任审批通过：" + leaveRequest);
      return true;
    } else {
      System.out.println("校长审批通过：" + leaveRequest);
      return true;
    }
  }

}
