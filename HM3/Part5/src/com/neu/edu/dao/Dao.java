package com.neu.edu.dao;

import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/info_6250?useSSL=false&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASSWORD = "root";
    private Connection connection;

    public Connection getConnection() throws Exception{
        try{
            Connection connection = null;
            DbUtils.loadDriver(JDBC_DRIVER);
            this.connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        }catch (SQLException ex){
            System.out.println("SQL Exception");
            ex.printStackTrace();
            throw new Exception();
        }
        return this.connection;
    }

//    public void closeConnection(Connection connection){
//        try{
//            if(connection != null){
//                connection.close();
//            }
//        }catch (SQLException ex){
//            System.out.println("SQLException" + ex.getMessage());
//        }
//    }
}
