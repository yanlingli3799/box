package com.javas.jdks.socket.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by liyanling on 2018/6/27.
 */
public class V2SocketDemoClient {

  private static      Logger logger = LoggerFactory.getLogger(V2SocketDemoClient.class);
  public static final String IP     = "127.0.0.1";

  public static Scanner scanner;
  public static int count = 1;

  public static void main(String[] args) throws Exception {
    scanner = new Scanner(System.in);

    logger.info("{}：demo1-----------",count++);
    startClient(IP, V2SocketDemoServer.PORT);
    Thread.sleep(1000);
    logger.info("{}：demo2-----------",count++);
    startClient(IP, V2SocketDemoServer.PORT);

    scanner.close();
  }

  public static void startClient(String IP, int PORT) throws Exception {
    try {
      logger.info("{}：准备连接服务端（IP:{},PORT:{}）", count++, IP, PORT);

      Socket socket = new Socket(IP, PORT);
      logger.info("{}：服务端已连接成功（IP:{},PORT:{}）", count++, IP, PORT);

      PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
      logger.info("{}：客户端获取输出流，向服务端发送信息：", count++);

      logger.info("{}：请输入姓名：", count++);
      String name = scanner.nextLine();
      logger.info("{}：请输入性别（GIRL / BOY）：", count++);
      String gender = scanner.nextLine();
      logger.info("{}：请输入体重（单位：斤）：", count++);
      Integer weight = Integer.valueOf(scanner.nextLine());

      V2SayHiParam v2SayHiParam = new V2SayHiParam(name, V2SayHiParam.Gender.valueOf(gender), weight);

      writer.write(V2SayHiParam.encode(v2SayHiParam) + "\n");
      writer.flush();

      BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      logger.info("{}：客户端获取输入流，读取服务端返回信息：{}", count++, reader.readLine());

      reader.close();
      writer.close();
      socket.close();
      logger.info("{}：关闭资源", count++);

    } catch (Throwable t) {
      t.printStackTrace();
    }
  }
}
