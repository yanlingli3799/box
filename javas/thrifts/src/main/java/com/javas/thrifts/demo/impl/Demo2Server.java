package com.javas.thrifts.demo.impl;


import com.javas.thrifts.demo.beans.DemoService;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liyanling on 2018/9/9.
 */
public class Demo2Server {
  private static Logger logger = LoggerFactory.getLogger(Demo2Server.class);

  public static final int PORT = 9082;

  public static final int CLIENT_TIMEOUT = 100000;



  public static void main(String[] args) {
    Demo2Server server = new Demo2Server();
    server.startServer();
  }

  /**
   * 线程池模型：TThreadPoolServer + TServerSocket
   */
  private void startServer() {

    try {

      int count = 1;

      logger.info("{}：new 一个 TServerSocket 实例，指定端口号为：{} 超时时间：{}", count++, PORT, CLIENT_TIMEOUT);
      TServerTransport tServerTransport = new TServerSocket(PORT, CLIENT_TIMEOUT);

      TThreadPoolServer.Args args = new TThreadPoolServer.Args(tServerTransport);
      logger.info("{}：服务端初始化 {} 参数...", count++, "TThreadPoolServer.Args");

      TBinaryProtocol.Factory proFactory = new TBinaryProtocol.Factory(true, true);
      args.protocolFactory(proFactory);
      logger.info("{}：设置协议工厂为 TBinaryProtocol.Factory，即：使用 TBinaryProtocol 协议", count++);

      TProcessor processor = new DemoService.Processor(new DemoServiceImpl());
      args.processor(processor);
      logger.info("{}：设置 processor 为 {} 实例", count++, "UserServiceImpl");

      TServer server = new TThreadPoolServer(args);
      logger.info("{}：{} 实例，服务启动", count++, "TThreadPoolServer");
      server.serve();

    } catch (TTransportException e) {
      e.printStackTrace();
    }
  }
}
