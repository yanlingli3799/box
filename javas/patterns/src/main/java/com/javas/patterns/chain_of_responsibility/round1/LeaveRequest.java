package com.javas.patterns.chain_of_responsibility.round1;

public class LeaveRequest {

  private int leaveHour;// 请假时长
  private String leaveReason;// 原因

  public LeaveRequest(int leaveHour, String leaveReason) {
    this.leaveHour = leaveHour;
    this.leaveReason = leaveReason;
  }

  public int getLeaveHour() {
    return leaveHour;
  }

  public void setLeaveHour(int leaveHour) {
    this.leaveHour = leaveHour;
  }

  public String getLeaveReason() {
    return leaveReason;
  }

  public void setLeaveReason(String leaveReason) {
    this.leaveReason = leaveReason;
  }

  @Override
  public String toString() {
    return "LeaveRequest{" +
           "leaveHour=" + leaveHour +
           ", leaveReason='" + leaveReason + '\'' +
           '}';
  }
}
