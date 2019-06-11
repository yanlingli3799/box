package com.javas.patterns.chain_of_responsibility.round2;

/**
 * Created by liyanling on 2018/11/10.
 */
public abstract class LeaveHandler {

  protected LeaveHandler next;

  abstract boolean handle(LeaveRequest request);

  public LeaveHandler getNext() {
    return next;
  }

  public void setNext(LeaveHandler next) {
    this.next = next;
  }
}
