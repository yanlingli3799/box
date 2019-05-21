package com.javas.guices.database;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static String url = "jdbc:mysql://localhost:3306/javas?useUnicode=true&characterEncoding=UTF-8&useSSL=true";
    private static String username = "root";
    private static String password = "root";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password);

        // 定义注射规则
        MyModule module=new MyModule();

        // 根据注射规则，生成注射者
        Injector injector= Guice.createInjector(module);

        // 获取一个 MyService 实例
        Service myService= injector.getInstance(Service.class);
        myService.query(connection,"111");
    }

}
