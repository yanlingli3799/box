package com.javas.jdks.serialization.demo1;

import java.io.Serializable;


public class User implements Serializable{

    private static String HH="我是静态变量，我不会被序列化";
    private int userId;
    private String userName;
    private String address;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static String getHH() {
        return HH;
    }

    public static void setHH(String HH) {
        User.HH = HH;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
