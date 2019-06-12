package com.javas.thrifts.demo.impl;


import com.javas.thrifts.demo.beans.DemoService;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liyanling on 2018/9/9.
 */
public class Demo3Server {
  private static Logger logger = LoggerFactory.getLogger(Demo3Server.class);

  public static final int PORT = 9083;

  public static final int CLIENT_TIMEOUT = 100000;

  public static void main(String[] args) {
    Demo3Server server = new Demo3Server();
    server.startServer();
  }



  /**
   * NIO 模型：TNonblockingServer + TNonblockingServerSocket
   */
  private void startServer() {
    try {

      int count = 1;

      logger.info("{}：new 一个 TNonblockingServerSocket 实例，指定端口号为：{} 超时时间：{}", count++, PORT, CLIENT_TIMEOUT);
      // 注意，这里要用 TNonblockingServerSocket
      TNonblockingServerSocket tNonblockingServerSocket = new TNonblockingServerSocket(PORT,CLIENT_TIMEOUT);

      TNonblockingServer.Args args = new TNonblockingServer.Args(tNonblockingServerSocket);
      logger.info("{}：服务端初始化 {} 参数...", count++, "TNonblockingServerSocket.Args");

      TBinaryProtocol.Factory proFactory = new TBinaryProtocol.Factory(true, true);
      args.protocolFactory(proFactory);
      logger.info("{}：设置协议工厂为 TBinaryProtocol.Factory，即：使用 TBinaryProtocol 协议", count++);

      TProcessor processor = new DemoService.Processor(new DemoServiceImpl());
      args.processor(processor);
      logger.info("{}：设置 processor 为 {} 实例", count++, "UserServiceImpl");

      TServer server = new TNonblockingServer(args);
      logger.info("{}：{} 实例，服务启动", count++, "TNonblockingServerSocket");
      server.serve();

    } catch (TTransportException e) {
      e.printStackTrace();
    }
  }
}
