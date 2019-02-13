package com.neu.edu.dao;

import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.relique.jdbc.csv.CsvDriver;

public class Dao {
    static final String CSV_DRIVER = "org.relique.jdbc.csv.CsvDriver";
    static final String CSV_URL = "jdbc:relique:csv:"+
            "C:\\Users\\KeyboardCat\\Documents\\INFO 6250\\INFO_6250_Assignment\\HM3\\Part6\\web\\";
    private Connection connection;

    public Connection getConnection() throws Exception{
        try{
//            Class.forName(CSV_DRIVER);
//            connection = DriverManager.getConnection(CSV_URL);
            Connection connection = null;
            DbUtils.loadDriver(CSV_DRIVER);
            this.connection = DriverManager.getConnection(CSV_URL);

        }catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return this.connection;
    }

}
