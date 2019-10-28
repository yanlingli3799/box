package com.demos.mysql1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MainStatement {

  private static String url = "jdbc:mysql://localhost:3306/demos?useUnicode=true&characterEncoding=UTF-8&useSSL=true";
  private static String username = "root";
  private static String password = "root";
  private static String driverName = "com.mysql.cj.jdbc.Driver";

  public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException {

    /**
     * 【1】如果数据库里已有数据，建议清一下，或者改一下下面的case
     */

    String selectAll = "select * from user";
    String goodCardId = "1102201990xxxx0000";
    String badCardId = "a' or '1'='1";

    System.out.println("开始");
    System.out.println("---------------------------------------------------");
    Thread.sleep(1000);

    /**
     * 【2】先插入几条数据
     * TODO：很奇怪，插入成功但返回值是false
     */
    String insertSqlTmpl = "insert into user (card_id,phone,name,age) values('%s','%s','%s',%d)";// insert 语句模板

    String insertSql1 = String.format(insertSqlTmpl, "1102201990xxxx0000", "130xxxx0000", "张三", 27);
    String insertSql2 = String.format(insertSqlTmpl, "1102201990xxxx1111", "130xxxx1111", "李四", 29);
    String insertSql3 = String.format(insertSqlTmpl, "1102201990xxxx2222", "130xxxx2222", "王五", 30);
    String insertSql4 = String.format(insertSqlTmpl, "1102201990xxxx3333", "130xxxx3333", "赵二", 31);

    System.out.println("插入语句：" + insertSql1 + "  ->  execute返回值：" + testExecute(insertSql1));
    System.out.println("插入语句：" + insertSql2 + "  ->  execute返回值：" + testExecute(insertSql2));
    System.out.println("插入语句：" + insertSql3 + "  ->  execute返回值：" + testExecute(insertSql3));
    System.out.println("插入语句：" + insertSql4 + "  ->  execute返回值：" + testExecute(insertSql4));
    Thread.sleep(1000);


    System.out.println("---------------------------------------------------");
    System.out.println("PS：execute返回值不是插入结果，只要没抛异常就可以认为插入成功");
    System.out.println("---------------------------------------------------");
    Thread.sleep(1000);

    /**
     * 【3】然后做两次查询
     */

    String selectSqlTmpl = "select * from user where card_id='%s'";// select 语句模板
    String goodSelectSql = String.format(selectSqlTmpl, goodCardId);
    String badSelectSql = String.format(selectSqlTmpl, badCardId);

    System.out.println("goodSelect 查询语句：" + goodSelectSql + "  ->  executeQuery结果(预期一条+是一条)：");
    testSelect(goodSelectSql);
    Thread.sleep(1000);

    System.out.println("badSelect 查询语句：" + badSelectSql + "  ->  executeQuery结果(预期一条+是多条)：");
    testSelect(badSelectSql);
    Thread.sleep(1000);

    System.out.println("---------------------------------------------------");
    System.out.println("可以看到 badSelect 通过 sql 注入查到了所有数据！！！！");
    System.out.println("---------------------------------------------------");
    Thread.sleep(1000);

    /**
     * 【4】再做两次更新
     */
    String updateSqlTmpl = "update user set name='%s' where card_id='%s'";
    String goodUpdateSql = String.format(updateSqlTmpl, "正常", goodCardId);
    String badUpdateSql = String.format(updateSqlTmpl, "异常", badCardId);

    int goodUpdateResult = testUpdate(goodUpdateSql);
    int badUpdateResult = testUpdate(badUpdateSql);
    System.out.println("goodUpdate 更新语句：" + goodSelectSql + "  ->  executeUpdate返回值：" + goodUpdateResult);
    System.out.println("查询全表确认：");
    testSelect(selectAll);
    Thread.sleep(1000);

    System.out.println("badUpdate 更新语句：" + goodSelectSql + "  ->  executeUpdate返回值：" + badUpdateResult);
    System.out.println("查询全表确认：");
    testSelect(selectAll);
    Thread.sleep(1000);

    System.out.println("---------------------------------------------------");
    System.out.println("可以看到 badUpdate 通过 sql 注入更新了所有数据！！！！");
    System.out.println("PS：executeUpdate返回值是更新sql执行结束后影响行数");
    System.out.println("---------------------------------------------------");
    Thread.sleep(1000);

    /**
     * 【5】最后做两次删除
     */
    String deleteSqlTmpl = "delete from user where card_id='%s'";
    String goodDeleteSql = String.format(deleteSqlTmpl,goodCardId);
    String badDeleteSql = String.format(deleteSqlTmpl,badCardId);

    System.out.println("goodDeleteSql 删除语句："+goodDeleteSql + " -> execute返回值："+testExecute(goodDeleteSql));
    System.out.println("查询全表确认：");
    testSelect(selectAll);
    Thread.sleep(1000);

    System.out.println("badDelete 删除语句："+badDeleteSql + " -> execute返回值："+testExecute(badDeleteSql));
    System.out.println("查询全表确认：");
    testSelect(selectAll);
    Thread.sleep(1000);

    System.out.println("---------------------------------------------------");
    System.out.println("可以看到 badDelete 通过 sql 注入删除了所有数据！！！！");
    System.out.println("PS：execute返回值不是插入结果，只要没抛异常就可以认为插入成功");
    System.out.println("---------------------------------------------------");
    Thread.sleep(1000);

    System.out.println("结束");

  }


  // Statement 通过 executeQuery 方法执行 sql 语句
  private static void testSelect(String sql) throws SQLException, ClassNotFoundException {
    Connection connection = null;
    Class.forName(driverName);
    connection = DriverManager.getConnection(url, username, password);
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);
    printResultSet(resultSet);
    resultSet.close();
    statement.close();
    connection.close();
  }


  // Statement 通过 executeUpdate 方法执行 sql 语句
  private static int testUpdate(String sql) throws SQLException, ClassNotFoundException {
    Connection connection = null;
    Class.forName(driverName);
    connection = DriverManager.getConnection(url, username, password);
    Statement statement = connection.createStatement();
    int result = statement.executeUpdate(sql);
    statement.close();
    connection.close();
    return result;
  }

  // Statement 通过 execute 方法执行 sql 语句
  private static boolean testExecute(String sql) throws SQLException, ClassNotFoundException {
    Connection connection = null;
    Class.forName(driverName);
    connection = DriverManager.getConnection(url, username, password);
    Statement statement = connection.createStatement();
    boolean result = statement.execute(sql);
    statement.close();
    connection.close();
    return result;
  }


  // 打印查询结果集，必须在 connection 关闭之前打印
  private static void printResultSet(ResultSet resultSet) throws SQLException {
    System.out.println();
    ResultSetMetaData meta_data = resultSet.getMetaData();//列名
    for (int i_col = 1; i_col <= meta_data.getColumnCount(); i_col++) {
      System.out.print("    "+meta_data.getColumnLabel(i_col) + "\t");
    }
    System.out.println();
    while (resultSet.next()) {
      for (int i_col = 1; i_col <= meta_data.getColumnCount(); i_col++) {
        System.out.print("    "+resultSet.getString(i_col) + "\t");
      }
      System.out.println();
    }
    System.out.println();
  }

}
