package com.javas.thrifts.demo.impl;

import com.javas.thrifts.demo.beans.DemoService;
import com.javas.thrifts.demo.beans.Gender;
import com.javas.thrifts.demo.beans.UserInfo;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Created by liyanling on 2018/9/9.
 */
public class Demo3Client {
  private static Logger logger = LoggerFactory.getLogger(Demo3Client.class);

  public static String LOCAL_HOST = "127.0.0.1";
  public static Scanner scanner;


  public static void main(String[] args){
    scanner = new Scanner(System.in);
    callServer(LOCAL_HOST, Demo3Server.PORT);
    scanner.close();
  }

  /**
   * TFramedTransport
   */
  public static void callServer(String IP, int PORT) {

    try {
      int count = 1;

      logger.info("{}：客户端，创建 TFramedTransport 实例 (IP：{}，PORT：{})...", count++, IP, PORT);
      // 注意，这里要用 TFramedTransport
      TTransport transport = new TFramedTransport(new TSocket(LOCAL_HOST, PORT));
      transport.open();
      logger.info("{}：打开 socket 连接", count++);

      TProtocol protocol = new TBinaryProtocol(transport);
      logger.info("{}：创建 TBinaryProtocol 实例", count++);

      DemoService.Iface client = new DemoService.Client(protocol);
      logger.info("{}：创建 Demo3Service.Client 实例", count++);

      // 测试 locate
      String locateResult = client.locate();
      logger.info("{}：locate 返回值 {}",count++,locateResult);

      // 测试 adsRecommendation
      String adsRecommendationResult = client.adsRecommendation();
      logger.info("{}：adsRecommendation 返回值 {}",count++,adsRecommendationResult);

      // 测试 sayHi
      logger.info("{}：请输入姓名：", count++);
      String name = scanner.nextLine();
      logger.info("{}：请输入性别（GIRL / BOY）：", count++);
      String gender = scanner.nextLine();
      logger.info("{}：请输入体重（单位：斤）：", count++);
      Integer weight = Integer.valueOf(scanner.nextLine());

      UserInfo userInfo = new UserInfo();
      userInfo.setName(name);
      userInfo.setGender(Gender.valueOf(gender));
      userInfo.setWeight(weight);

      String sayHiResult = client.sayHi(userInfo);
      logger.info("{}：sayHi 返回值 {}",count++,sayHiResult);

      transport.close();
      logger.info("{}：关闭 socket 连接", count++);

    } catch (Throwable t) {
      t.printStackTrace();
    }

  }
}
