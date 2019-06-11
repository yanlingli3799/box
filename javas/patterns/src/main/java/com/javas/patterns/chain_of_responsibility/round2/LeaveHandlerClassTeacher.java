package com.javas.patterns.chain_of_responsibility.round2;


/**
 * Created by liyanling on 2018/11/10.
 * <p>
 * 任课老师
 */
public class LeaveHandlerClassTeacher extends LeaveHandler {

  private final static int HOUR = 2;

  @Override
  boolean handle(LeaveRequest request) {
    if (request.getLeaveHour() <= HOUR) {
      System.out.println("任课老师审批通过");
      return true;
    } else {
      System.out.println("任课老师没权限审批超过" + HOUR + "小时的请假单");
      return this.next.handle(request);
    }
  }
}
