package com.javas.patterns.observer.round1;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyanling on 2018/11/8.
 */
public class User {

  private String name;// 姓名
  private List<String> messageInbox = new ArrayList<>();// 收件箱

  public User(String name) {
    this.name = name;
  }


  // 接收消息
  public void update(String message) {
    messageInbox.add(message);
  }

  // 查看收件箱消息
  public void readInboxMessage() {
    System.out.println(name + "的收件箱：");
    for (String message : messageInbox) {
      System.out.println(message);
    }
  }

  public String getName() {
    return name;
  }

}
