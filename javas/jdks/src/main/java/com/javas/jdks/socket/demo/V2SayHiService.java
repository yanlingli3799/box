package com.javas.jdks.socket.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liyanling on 2018/9/9.
 */
public class V2SayHiService {

  private static       Logger logger          = LoggerFactory.getLogger(V1SocketDemoServer.class);
  private final static String SAY_HI_TEMPLATE = "Hi,%s%s!%s";

  public static String sayHi(String params) {
    try {
      return sayHi(V2SayHiParam.decode(params));
    } catch (Throwable t) {
      logger.error("caught exception,t=", t);
      return "sayHi参数格式错误:" + params;
    }
  }

  private static String sayHi(V2SayHiParam v2SayHiParam) {
    String name = v2SayHiParam.getName();
    String nameSuffix = V2SayHiParam.Gender.BOY == v2SayHiParam.getGender() ? "先生" : "女士";
    String weightNotice = v2SayHiParam.getWeight() >= 200 ? "你该减肥啦~" : "";
    return String.format(SAY_HI_TEMPLATE, name, nameSuffix, weightNotice);
  }

}

