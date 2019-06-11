package com.javas.patterns.no11.facade.round1;

public class Disk {
  public void start(){
    System.out.println("硬盘操作：start");
  }

  public void shutdown(){
    System.out.println("硬盘操作：shutdown");
  }

  public void read(){
    System.out.println("硬盘操作：read");
  }

  public void write(){
    System.out.println("硬盘操作：write");
  }

}
