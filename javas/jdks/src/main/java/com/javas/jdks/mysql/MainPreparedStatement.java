package com.javas.jdks.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class MainPreparedStatement {
  private static String url = "jdbc:mysql://localhost:3306/javas?useUnicode=true&characterEncoding=UTF-8&useSSL=true";
  private static String username = "root";
  private static String password = "root";

  public static void main(String[] args) throws SQLException, ClassNotFoundException {

    System.out.println("测试 PreparedStatement select");
    System.out.println("正常情况下，按 user_id 查询用户信息，如下：");
    testSelect("111");
    System.out.println("在 user_id 上做些手脚，如下：");
    testSelect("a' or '1'='1");

    System.out.println("------------------------------------------");
    System.out.println("PreparedStatement 对这种SQL注入方式免疫");
    System.out.println("------------------------------------------");

    System.out.println("PreparedStatement 看下用法");

    System.out.println("测试 PreparedStatement update");
    testUpdate("114","张三");
    testUpdate("a' or '1'='1","kk");
    selectAll();


    testInsert("112","oo","hi");
    selectAll();

  }

  // PreparedStatement 查询
  private static void selectAll()throws SQLException, ClassNotFoundException{
    Connection connection = null;
    Class.forName("com.mysql.jdbc.Driver");
    connection = DriverManager.getConnection(url, username, password);
    String sql = "select * from user ";
    System.out.println("sql = "+sql);
    PreparedStatement statement = connection.prepareStatement(sql);
    ResultSet resultSet = statement.executeQuery();
    printResultSet(resultSet);
    resultSet.close();
    statement.close();
    connection.close();
  }

  // PreparedStatement 执行 select 操作
  private static void testSelect(String user_id) throws SQLException, ClassNotFoundException{
    Connection connection = null;
    Class.forName("com.mysql.jdbc.Driver");
    connection = DriverManager.getConnection(url, username, password);

    String sql = "select * from user where user_id = ? ";
    System.out.println("sql = "+sql);
    PreparedStatement statement=connection.prepareStatement(sql);
    statement.setString(1,user_id);
    ResultSet resultSet = statement.executeQuery();
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
    String sql = "update user set user_name = ? where user_id = ? ";
    System.out.println("sql = "+sql);
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1,user_name);
    statement.setString(2,user_id);
    statement.executeUpdate();
    statement.close();
    connection.close();
  }

  // Statement 执行 insert 操作
  private static void testInsert(String user_id,String user_name,String remark) throws SQLException, ClassNotFoundException{
    Connection connection = null;
    Class.forName("com.mysql.jdbc.Driver");
    connection = DriverManager.getConnection(url, username, password);
    String sql = "insert into user (user_id,user_name,remark) values(?,?,?) ";
    System.out.println("sql = "+sql);
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1,user_id);
    statement.setString(2,user_name);
    statement.setString(3,remark);
    statement.clearBatch();
    statement.addBatch();
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
