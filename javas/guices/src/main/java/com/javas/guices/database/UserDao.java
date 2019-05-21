package com.javas.guices.database;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.sql.*;

@Singleton
public class UserDao {


    public void queryCounter(Connection conn, String user_id) throws SQLException {
        String sql="select count(*) from user where user_id=?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,user_id);
        ResultSet resultSet = preparedStatement.executeQuery();
        printResultSet(resultSet);
        preparedStatement.close();
    }

    private  void printResultSet(ResultSet resultSet) throws SQLException {
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
