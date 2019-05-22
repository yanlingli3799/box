package com.javas.jdks.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MainStatement {
  private static String url = "jdbc:mysql://localhost:3306/javas?useUnicode=true&characterEncoding=UTF-8&useSSL=true";
  private static String username = "root";
  private static String password = "root";

  public static void main(String[] args) throws SQLException, ClassNotFoundException {

    System.out.println("测试 Statement select");
    System.out.println("正常情况下，按 user_id 查询用户信息，如下：");
    testSelect("111");
    System.out.println("但是如果在 user_id 上做些手脚，就变成了这样的：");
    testSelect("a' or '1'='1");

    System.out.println("------------------------------------------");
    System.out.println("SQL 注入影响 select 操作，导致数据泄露");
    System.out.println("------------------------------------------");

    System.out.println("测试 Statement update");
    System.out.println("正常情况，只更新指定 user_id 的 user_name");
    testUpdate("111","null");
    selectAll();
    System.out.println("不正常情况，所有用户的 user_name 都被更新了");
    testUpdate("a' or '1'='1","null");
    selectAll();

    System.out.println("------------------------------------------");
    System.out.println("SQL 注入影响 update 操作，导致数据被篡改");
    System.out.println("------------------------------------------");

    System.out.println("测试 Statement insert");
    System.out.println("这个没啥可讲的，拼好sql，看下用法就行了");
    testInsert("insert into user (user_id,user_name) values('114','222')");
    selectAll();
  }

  // Statement select 全表
  private static void selectAll()throws SQLException, ClassNotFoundException{
    Connection connection = null;
    Class.forName("com.mysql.jdbc.Driver");
    connection = DriverManager.getConnection(url, username, password);
    String sql = "select * from user ";
    System.out.println("sql = "+sql);
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);
    printResultSet(resultSet);
    resultSet.close();
    statement.close();
    connection.close();
  }

  // Statement 执行 select 操作
  private static void testSelect(String user_id) throws SQLException, ClassNotFoundException{
    Connection connection = null;
    Class.forName("com.mysql.jdbc.Driver");
    connection = DriverManager.getConnection(url, username, password);
    String sql = "select * from user where user_id='" +user_id +"'";
    System.out.println("sql = "+sql);
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);
    printResultSet(resultSet);
    resultSet.close();
    statement.close();
    connection.close();
  }


  // Statement 执行 update 操作
  private static void testUpdate(String user_id,String user_name) throws SQLException, ClassNotFoundException {
    Connection connection = null;
    Class.forName("com.mysql.jdbc.Driver");
    connection = DriverManager.getConnection(url, username, password);
    String sql = "update user set user_name='"+user_name+"' where user_id='" +user_id +"'";
    System.out.println("sql = "+sql);
    Statement statement = connection.createStatement();
    statement.executeUpdate(sql);
    statement.close();
    connection.close();
  }

  // Statement 执行 insert 操作
  private static void testInsert(String sql) throws SQLException, ClassNotFoundException{
    Connection connection = null;
    Class.forName("com.mysql.jdbc.Driver");
    connection = DriverManager.getConnection(url, username, password);
    System.out.println("sql = "+sql);
    Statement statement = connection.createStatement();
    statement.clearBatch();
    statement.addBatch(sql);
    statement.executeBatch();
    statement.close();
    connection.close();
  }

  private static void printResultSet(ResultSet resultSet) throws SQLException {
    System.out.println("查询结果集：");
    ResultSetMetaData meta_data = resultSet.getMetaData();//列名
    for (int i_col = 1; i_col <= meta_data.getColumnCount(); i_col++) {
      System.out.print(meta_data.getColumnLabel(i_col) + "\t");
    }
    System.out.println();
    while (resultSet.next()) {
      for (int i_col = 1; i_col <= meta_data.getColumnCount(); i_col++) {
        System.out.print(resultSet.getString(i_col) + "\t");
      }
      System.out.println();
    }
  }
}
