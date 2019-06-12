package com.javas.thrifts.demo.impl;


import com.javas.thrifts.demo.beans.DemoService;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liyanling on 2018/9/9.
 */
public class Demo1Server {
  private static Logger logger = LoggerFactory.getLogger(Demo1Server.class);

  public static final int PORT = 9081;

  public static final int CLIENT_TIMEOUT = 100000;


  public static void main(String[] args) {
    Demo1Server server = new Demo1Server();
    server.startServer();
  }

  /**
   * 单线程服务模型：TSimpleServer + TServerSocket
   */
  private void startServer() {

    try {

      int count = 1;

      logger.info("{}：new 一个 TServerSocket 实例，指定端口号为：{} 超时时间：{}", count++, PORT, CLIENT_TIMEOUT);
      TServerTransport tServerTransport = new TServerSocket(PORT, CLIENT_TIMEOUT);

      TSimpleServer.Args args = new TSimpleServer.Args(tServerTransport);
      logger.info("{}：服务端初始化 {} 参数...", count++, "TSimpleServer.Args");

      TBinaryProtocol.Factory proFactory = new TBinaryProtocol.Factory(true, true);
      args.protocolFactory(proFactory);
      logger.info("{}：设置协议工厂为 TBinaryProtocol.Factory，即：使用 TBinaryProtocol 协议", count++);

      TProcessor processor = new DemoService.Processor(new DemoServiceImpl());
      args.processor(processor);
      logger.info("{}：设置 processor 为 {} 实例", count++, "UserServiceImpl");

      TServer server = new TSimpleServer(args);
      logger.info("{}：{} 实例，服务启动", count++, "TSimpleServer");
      server.serve();

    } catch (TTransportException e) {
      e.printStackTrace();
    }
  }
}
