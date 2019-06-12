package com.javas.thrifts.demo.impl;

import com.javas.thrifts.demo.beans.DemoService;
import com.javas.thrifts.demo.beans.Gender;
import com.javas.thrifts.demo.beans.UserInfo;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by liyanling on 2018/9/9.
 */
public class DemoServiceImpl implements DemoService.Iface{
  private static Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

  private final static String SAY_HI_TEMPLATE = "Hi,%s%s!%s";

  private final static List<String> CITIES = Arrays.asList("上海", "北京", "广州", "成都", "内蒙古", "香港", "河北", "云南");

  private final static List<String> ADS = Arrays.asList("坐红旗车，走中国路", "要想皮肤好，早晚用大宝", "喝汇源果汁，走健康之路", "送礼就送脑白金",
                                                        "飘柔，就是这么自信");


  @Override
  public String sayHi(UserInfo userInfo) throws TException {
    String name = userInfo.getName();
    String nameSuffix = Gender.BOY == userInfo.getGender() ? "先生" : "女士";
    String weightNotice = userInfo.getWeight() >= 200 ? "你该减肥啦~" : "";
    return String.format(SAY_HI_TEMPLATE, name, nameSuffix, weightNotice);
  }

  @Override
  public String locate() throws TException {
    int citySize = CITIES.size();
    int randomIndex = Math.abs((new Random(System.currentTimeMillis())).nextInt()) % citySize;
    return CITIES.get(randomIndex);
  }

  @Override
  public String adsRecommendation() throws TException {
    logger.info("sleep..........");
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    logger.info("awake..........");
    int adsSize = ADS.size();
    int randomIndex = Math.abs((new Random(System.currentTimeMillis())).nextInt()) % adsSize;
    return ADS.get(randomIndex);
  }

  @Override
  public String alive() throws TException {
    return "alive-yes";
  }
}
