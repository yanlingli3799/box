package com.javas.jdks.socket.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by liyanling on 2018/6/27.
 * ************************************
 * <p>
 * 交互方式（短连接）
 * <p>
 * 1、服务端启动监听。
 * 2、服务端【每】获得一个客户端连接，处理完一条消息后即【关闭连接】，并【等待下一个客户端连接】。
 * 3、服务端按行读取消息内容，作为姓名参数，回写 sayHi 消息
 */
public class V1SocketDemoServer {

  private static Logger logger = LoggerFactory.getLogger(V1SocketDemoServer.class);

  public static final int PORT = 9091;
  private static int count = 1;

  public static void main(String[] args) throws Exception {
    startServer();
  }

  private static void startServer() throws Exception {
    try {

      ServerSocket serverSocket = new ServerSocket(PORT);
      logger.info("{}：服务端（端口:{}）启动监听，等待客户端连接", count++, PORT);

      while (true) {
        Socket socket = serverSocket.accept();
        logger.info("{}：服务端已与客户端建立连接，开始接收客户端消息...", count++);

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String name = reader.readLine();
        logger.info("{}：服务端获取输入流，读取客户端信息：{}", count++, name);

        String sayHiResult = V1SayHiService.sayHi(name);
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.write(sayHiResult + "\n");
        writer.flush();
        logger.info("{}：服务端获取输出流，响应客户端请求，回写：{}", count++, sayHiResult);

        writer.close();
        reader.close();
        socket.close();
//        serverSocket.close();// 这里不要把 serverSocket 关了。还得继续监听呢
        logger.info("{}：服务端关闭资源", count++);
        logger.info("{}：等待下一个客户端连接", count++);
      }

    } catch (Throwable t) {
      t.printStackTrace();
    }
  }

}
