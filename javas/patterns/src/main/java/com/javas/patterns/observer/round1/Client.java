package com.javas.patterns.observer.round1;

/**
 * Created by liyanling on 2018/11/8.
 */
public class Client {

  public static void main(String[] args) {

    User zhangsan = new User("张三");
    User lisi = new User("李四");
    Subject subject = new Subject("社会新闻");

    System.out.println("【1】" + zhangsan.getName() + " 和 " + lisi.getName() + " 订阅" + subject.getSubjectName());
    subject.addPerson(zhangsan);
    subject.addPerson(lisi);

    System.out.println("【2】发布新闻");
    subject.publishMessage("1.江南皮革厂倒闭了");
    zhangsan.readInboxMessage();
    lisi.readInboxMessage();
    subject.readOutboxMessage();

    System.out.println("【3】" + zhangsan.getName() + "取消订阅" + subject.getSubjectName());
    subject.removePerson(zhangsan);

    System.out.println("【4】发布新闻");
    subject.publishMessage("2.吐槽大会第三季来了");
    zhangsan.readInboxMessage();
    lisi.readInboxMessage();
    subject.readOutboxMessage();

    System.out.println("【5】" + lisi.getName() + "取消订阅" + subject.getSubjectName());
    subject.removePerson(lisi);

    System.out.println("【6】发布新闻");
    subject.publishMessage("3.听说90后都开始脱发了");
    zhangsan.readInboxMessage();
    lisi.readInboxMessage();
    subject.readOutboxMessage();

  }


}
