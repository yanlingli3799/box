package com.demos.mysql1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MainPreparedStatement {

  public static void main(String[] args) throws InterruptedException, SQLException, ClassNotFoundException {

    /**
     * 【1】如果数据库里已有数据，建议清一下，或者改一下下面的case
     */

    String selectAll = "select * from user";
    String goodCardId = "1102201990yyyy0000";
    String badCardId = "a' or '1'='1";

    System.out.println("开始");
    System.out.println("---------------------------------------------------");
    Thread.sleep(1000);

    /**
     * 【2】先插入几条数据
     * TODO：很奇怪，插入成功但返回值是false
     */
    String insertSqlTmpl = "insert into user (card_id,phone,name,age) values(?,?,?,?)";// insert 语句模板
    Map<Integer, String> map1 = new HashMap<>();
    map1.put(1, "1102201990yyyy0000");
    map1.put(2, "130yyyy0000");
    map1.put(3, "zhangsan");
    map1.put(4, "27");

    Map<Integer, String> map2 = new HashMap<>();
    map2.put(1, "1102201990yyyy1111");
    map2.put(2, "130yyyy1111");
    map2.put(3, "lisi");
    map2.put(4, "28");

    Map<Integer, String> map3 = new HashMap<>();
    map3.put(1, "1102201990yyyy2222");
    map3.put(2, "130yyyy2222");
    map3.put(3, "wangwu");
    map3.put(4, "28");

    Map<Integer, String> map4 = new HashMap<>();
    map4.put(1, "1102201990yyyy3333");
    map4.put(2, "130yyyy3333");
    map4.put(3, "zhaoer");
    map4.put(4, "28");

    System.out.println("插入语句：" + insertSqlTmpl + " 参数列表：" + map1 + "  ->  execute返回值：" + testExecute(insertSqlTmpl, map1));
    System.out.println("插入语句：" + insertSqlTmpl + " 参数列表：" + map2 + "  ->  execute返回值：" + testExecute(insertSqlTmpl, map2));
    System.out.println("插入语句：" + insertSqlTmpl + " 参数列表：" + map3 + "  ->  execute返回值：" + testExecute(insertSqlTmpl, map3));
    System.out.println("插入语句：" + insertSqlTmpl + " 参数列表：" + map4 + "  ->  execute返回值：" + testExecute(insertSqlTmpl, map4));
    Thread.sleep(1000);

    System.out.println("---------------------------------------------------");
    System.out.println("PS：execute返回值不是插入结果，只要没抛异常就可以认为插入成功");
    System.out.println("---------------------------------------------------");
    Thread.sleep(1000);

    /**
     * 【3】然后做两次查询
     */
    String selectSqlTmpl = "select * from user where card_id=?";// select 语句模板
    Map<Integer, String> goodSelectParams = new HashMap<>();
    goodSelectParams.put(1, goodCardId);
    Map<Integer, String> badSelectParams = new HashMap<>();
    badSelectParams.put(1, badCardId);

    System.out.println("查询语句：" + selectSqlTmpl + " goodSelectParams 参数列表：" + goodSelectParams + "  ->  executeQuery结果(预期一条+是一条)：");
    testExecuteQuery(selectSqlTmpl, goodSelectParams);
    Thread.sleep(1000);

    System.out.println("查询语句：" + selectSqlTmpl + " badSelectParams 参数列表：" + badSelectParams + "  ->  executeQuery结果(预期无记录+是无记录)：");
    testExecuteQuery(selectSqlTmpl, badSelectParams);
    Thread.sleep(1000);

    System.out.println("---------------------------------------------------");
    System.out.println("可以看到 badSelect 无法通过 sql 注入查询所有数据");
    System.out.println("---------------------------------------------------");
    Thread.sleep(1000);

    /**
     * 【4】再做两次更新
     */
    String updateSqlTmpl = "update user set name=? where card_id=?";

    Map<Integer, String> goodUpdateParams = new HashMap<>();
    goodUpdateParams.put(1, "正常");
    goodUpdateParams.put(2, goodCardId);

    Map<Integer, String> badUpdateParams = new HashMap<>();
    badUpdateParams.put(1, "异常");
    badUpdateParams.put(2, badCardId);

    System.out.println("更新语句：" + updateSqlTmpl + " goodUpdateParams 参数列表：" + goodUpdateParams + "  ->  executeUpdate返回值：" + testExecuteUpdate(updateSqlTmpl, goodUpdateParams));
    System.out.println("查询全表确认：");
    testExecuteQuery(selectAll, null);
    Thread.sleep(1000);

    System.out.println("更新语句：" + updateSqlTmpl + " badUpdateParams 参数列表：" + badUpdateParams + "  ->  executeUpdate返回值：" + testExecuteUpdate(updateSqlTmpl, badUpdateParams));
    System.out.println("查询全表确认：");
    testExecuteQuery(selectAll, null);
    Thread.sleep(1000);

    System.out.println("---------------------------------------------------");
    System.out.println("可以看到 badUpdate 无法通过 sql 注入更新数据");
    System.out.println("PS：executeUpdate返回值是更新sql执行结束后影响行数");
    System.out.println("---------------------------------------------------");
    Thread.sleep(1000);

    /**
     * 【5】最后做两次删除
     */
    String deleteSqlTmpl = "delete from user where card_id=?";
    Map<Integer, String> goodDeleteParams = new HashMap<>();
    goodDeleteParams.put(1, goodCardId);
    Map<Integer, String> badDeleteParams = new HashMap<>();
    badDeleteParams.put(1, badCardId);

    System.out.println("删除语句：" + deleteSqlTmpl + " goodDeleteParams 参数列表：" + goodDeleteParams + " -> execute返回值：" + testExecute(deleteSqlTmpl, goodDeleteParams));
    System.out.println("查询全表确认：");
    testExecuteQuery(selectAll, null);
    Thread.sleep(1000);

    System.out.println("删除语句：" + deleteSqlTmpl + " badDeleteParams 参数列表：" + badDeleteParams + " -> execute返回值：" + testExecute(deleteSqlTmpl, badDeleteParams));
    System.out.println("查询全表确认：");
    testExecuteQuery(selectAll, null);
    Thread.sleep(1000);

    System.out.println("---------------------------------------------------");
    System.out.println("可以看到 badDelete 无法通过 sql 注入删除所有数据");
    System.out.println("PS：execute返回值不是插入结果，只要没抛异常就可以认为插入成功");
    System.out.println("---------------------------------------------------");
    Thread.sleep(1000);

    System.out.println("结束");
  }


  // PreparedStatement 执行 execute 操作
  private static boolean testExecute(String sql, Map<Integer, String> params) throws SQLException, ClassNotFoundException {
    Class.forName(CommonUtil.driverName);
    Connection connection = DriverManager.getConnection(CommonUtil.url, CommonUtil.username, CommonUtil.password);
    PreparedStatement statement = connection.prepareStatement(sql);
    if (null != params && !params.isEmpty()) {
      for (Integer key : params.keySet()) {
        String value = params.get(key);
        statement.setString(key, value);
      }
    }
    boolean result = statement.execute();
    statement.close();
    connection.close();
    return result;
  }

  // PreparedStatement 执行 executeUpdate 操作
  private static int testExecuteUpdate(String sql, Map<Integer, String> params) throws SQLException, ClassNotFoundException {
    Class.forName(CommonUtil.driverName);
    Connection connection = DriverManager.getConnection(CommonUtil.url, CommonUtil.username, CommonUtil.password);
    PreparedStatement statement = connection.prepareStatement(sql);
    if (null != params && !params.isEmpty()) {
      for (Integer key : params.keySet()) {
        String value = params.get(key);
        statement.setString(key, value);
      }
    }
    int result = statement.executeUpdate();
    statement.close();
    connection.close();
    return result;
  }


  // PreparedStatement 执行 select 操作
  private static void testExecuteQuery(String sql, Map<Integer, String> params) throws SQLException, ClassNotFoundException {
    Class.forName(CommonUtil.driverName);
    Connection connection = DriverManager.getConnection(CommonUtil.url, CommonUtil.username, CommonUtil.password);
    PreparedStatement statement = connection.prepareStatement(sql);
    if (null != params && !params.isEmpty()) {
      for (Integer key : params.keySet()) {
        String value = params.get(key);
        statement.setString(key, value);
      }
    }
    ResultSet resultSet = statement.executeQuery();
    CommonUtil.printResultSet(resultSet);
    resultSet.close();
    statement.close();
    connection.close();
  }


}
