package com.javas.thrifts.demo.impl;

import com.javas.thrifts.demo.beans.BaseService;
import com.javas.thrifts.demo.beans.DemoService;
import com.javas.thrifts.demo.beans.Gender;
import com.javas.thrifts.demo.beans.UserInfo;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Created by liyanling on 2018/9/9.
 */
public class Demo4Client {
  private static Logger logger = LoggerFactory.getLogger(Demo4Client.class);

  public static String LOCAL_HOST = "127.0.0.1";
  public static Scanner scanner;


  public static void main(String[] args){
    scanner = new Scanner(System.in);
    callServer(LOCAL_HOST, Demo4Server.PORT);
    scanner.close();
  }


  /**
   * TSocket
   */
  public static void callServer(String IP, int PORT) {

    try {
      int count = 1;

      logger.info("{}：客户端，创建 TSocket 实例 (IP：{}，PORT：{})...", count++, IP, PORT);
      TTransport transport = new TSocket(LOCAL_HOST, PORT);
      transport.open();
      logger.info("{}：打开 socket 连接", count++);

      TProtocol protocol = new TBinaryProtocol(transport);
      logger.info("{}：创建 TBinaryProtocol 实例", count++);

      BaseService.Iface client = new BaseService.Client(protocol);
      logger.info("{}：创建 Demo1Service.Client 实例", count++);

      // 测试 alive
      String locateResult = client.alive();
      logger.info("{}：alive 返回值 {}",count++,locateResult);

      transport.close();
      logger.info("{}：关闭 socket 连接", count++);

    } catch (Throwable t) {
      t.printStackTrace();
    }

  }
}
