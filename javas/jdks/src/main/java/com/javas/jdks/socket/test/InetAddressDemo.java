package com.javas.jdks.socket.test;

import java.net.InetAddress;

public class InetAddressDemo {
  
  
  public static void main(String[] args) throws Exception {
    testInetAddress();
  }

  private static void testInetAddress() throws Exception {

    //获取本机的InetAddress实例
    InetAddress address =InetAddress.getLocalHost();
    String hostName = address.getHostName();//获取计算机名
    String hostAddress = address.getHostAddress();//获取IP地址
    byte[] bytes = address.getAddress();//获取字节数组形式的IP地址,以点分隔的四部分

    System.out.println("测试，address.hostName="+hostName);
    System.out.println("测试，address.hostAddress="+hostAddress);
//
//    //获取其他主机的InetAddress实例
    InetAddress address2 =InetAddress.getByName("10.95.122.205");
//    InetAddress address3 =InetAddress.getByName("IP地址");
  }

}
