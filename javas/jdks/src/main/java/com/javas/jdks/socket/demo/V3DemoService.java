package com.javas.jdks.socket.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by liyanling on 2018/9/9.
 */
public class V3DemoService {

  private static       Logger logger          = LoggerFactory.getLogger(V1SocketDemoServer.class);

  private final static String SAY_HI_TEMPLATE = "Hi,%s%s!%s";

  private final static List<String> CITIES = Arrays.asList("上海", "北京", "广州", "成都", "内蒙古", "香港", "河北", "云南");

  private final static List<String> ADS = Arrays.asList("坐红旗车，走中国路", "要想皮肤好，早晚用大宝", "喝汇源果汁，走健康之路", "送礼就送脑白金",
                                                        "飘柔，就是这么自信");

  public static String locate() {
    int citySize = CITIES.size();
    int randomIndex = Math.abs((new Random(System.currentTimeMillis())).nextInt()) % citySize;
    return CITIES.get(randomIndex);
  }

  public static String adsRecommendation() {
    int adsSize = ADS.size();
    int randomIndex = Math.abs((new Random(System.currentTimeMillis())).nextInt()) % adsSize;
    return ADS.get(randomIndex);
  }

  public static String sayHi(String params) {
    try {
      return sayHi(V3SayHiParam.decode(params));
    } catch (Throwable t) {
      logger.error("caught exception,t=", t);
      return "sayHi参数格式错误:" + params;
    }
  }

  private static String sayHi(V3SayHiParam v3SayHiParam) {
    String name = v3SayHiParam.getName();
    String nameSuffix = V3SayHiParam.Gender.BOY == v3SayHiParam.getGender() ? "先生" : "女士";
    String weightNotice = v3SayHiParam.getWeight() >= 200 ? "你该减肥啦~" : "";
    return String.format(SAY_HI_TEMPLATE, name, nameSuffix, weightNotice);
  }

  public static String doSomething(String params) {
    try {
      int separatorLocate = params.indexOf('|');
      int length = params.length();

      String function = params.substring(0, separatorLocate);

      String functionParams = params.substring(separatorLocate + 1, length);

      logger.info("demoService function:{} functionParams:{}",function,functionParams);
      if ("sayHi".equals(function)) {
        return sayHi(functionParams);
      } else if ("locate".equals(function)) {
        return locate();
      } else if ("adsRecommendation".equals(function)) {
        return adsRecommendation();
      } else {
        return "不支持" + function + "功能";
      }

    } catch (Throwable t) {
      logger.error("caught error,t=", t);
      return "参数格式错误:" + params;
    }

  }
}

