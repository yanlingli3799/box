package com.javas.utils.id;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class IdGen1 {

  private static AtomicInteger incr      = new AtomicInteger(0);
  private static int           MAX_RANGE = 2048;


  // 获取机器编号，这里随机返回一个 10 以内的 int 值
  private static int getCurrentMachineNo() {
    return Math.abs((new Random()).nextInt()) % 10;
  }

  // 当前时间 距离当天凌晨 秒数
  private static long getCurrentSeconds() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    long zero = calendar.getTimeInMillis();
    return ((System.currentTimeMillis() - zero) / 1000);
  }

  // 生成一个随机值（0~2048）
  private static long getSerial() {
    long range = incr.incrementAndGet();
    if (range > MAX_RANGE) {
      incr.set(0);
    }
    return range;
  }


  // {{yyyymmdd} 共8个字符} + { {12bit随机值 + 17bit秒数 + 5bit机器编号} 取前10个字符}
  public static String genPrePayId(String yyyyMMdd) throws InterruptedException {
    long des = getCurrentMachineNo();
    long seconds = getCurrentSeconds();
    long range = getSerial();
    des = des | (seconds << 5);
    des = des | (range << 22);
    String orderId = String.format("%010d", des);
    return yyyyMMdd + orderId;
  }

  public static void main(String[] args) throws InterruptedException {
    for (int i = 0; i < 20; i++) {
      String id = genPrePayId("20190901");
      System.out.println("id = " + id);
      System.out.println("id = " + Long.toBinaryString(Long.parseLong(id)));
    }
  }

}
