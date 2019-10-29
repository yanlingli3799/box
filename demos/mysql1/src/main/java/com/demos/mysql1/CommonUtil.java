package com.demos.mysql1;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class CommonUtil {

  public static String url = "jdbc:mysql://localhost:3306/demos?useUnicode=true&characterEncoding=UTF-8&useSSL=true";
  public static String username = "root";
  public static String password = "root";
  public static String driverName = "com.mysql.cj.jdbc.Driver";


  // 打印查询结果集，必须在 connection 关闭之前打印
  public static void printResultSet(ResultSet resultSet) throws SQLException {
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
