package com.javas.patterns.chain_of_responsibility.round2;

/**
 * Created by liyanling on 2018/11/10.
 *
 * 班长
 */
public class LeaveHandlerMonitor extends LeaveHandler{

  @Override
  boolean handle(LeaveRequest request) {
    System.out.println("班长没有审批权限");
    return this.next.handle(request);
  }
}
