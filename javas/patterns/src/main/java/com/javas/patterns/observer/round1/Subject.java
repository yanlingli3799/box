package com.javas.patterns.observer.round1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyanling on 2018/11/8.
 */
public class Subject {

  private String subjectName;// 主题名
  private List<User> userList = new ArrayList<>();// 订阅人列表
  private List<String> messageOutbox = new ArrayList<>();// 发件箱

  public Subject(String subjectName) {
    this.subjectName = subjectName;
  }

  // 添加订阅
  public void addPerson(User user) {
    userList.add(user);
  }

  // 取消订阅
  public void removePerson(User user) {
    userList.remove(user);
  }

  // 发布消息
  public void publishMessage(String message) {
    messageOutbox.add(message);
    for (User user : userList) {
      user.update(message);
    }
  }

  // 查看发件箱消息
  public void readOutboxMessage() {
    System.out.println(subjectName + "的发件箱：");
    for (String message : messageOutbox) {
      System.out.println(message);
    }
  }

  public String getSubjectName() {
    return subjectName;
  }

}
