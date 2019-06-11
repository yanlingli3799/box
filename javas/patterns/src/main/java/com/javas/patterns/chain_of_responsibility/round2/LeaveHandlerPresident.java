package com.javas.patterns.chain_of_responsibility.round2;

/**
 * Created by liyanling on 2018/11/10.
 *
 * 校长
 */
public class LeaveHandlerPresident extends LeaveHandler{

  @Override
  boolean handle(LeaveRequest request) {
    System.out.println("校长审批通过");
    return true;
  }
}
