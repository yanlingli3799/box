package com.javas.guices.database;

import com.google.inject.Inject;

import java.sql.Connection;
import java.sql.SQLException;


public class Service {

    @Inject
    private UserDao userDao;


    public void query(Connection conn,String user_id) throws SQLException {
        userDao.queryCounter(conn,user_id);
    }
}
