package com.javas.patterns.chain_of_responsibility.round2;

/**
 * Created by liyanling on 2018/11/10.
 *
 * 班主任
 */
public class LeaveHandlerClassAdvisor extends LeaveHandler{

  private final static int HOUR=24;
  @Override
  boolean handle(LeaveRequest request) {
    if(request.getLeaveHour() <= HOUR){
      System.out.println("班主任审批通过");
      return true;
    }else{
      System.out.println("班主任无权限审批超过"+HOUR+"的请假单");
      return this.next.handle(request);
    }
  }
}
