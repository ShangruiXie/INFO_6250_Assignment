package com.neu.edu.dao;

import com.neu.edu.pojo.Order;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;

public class CsvDao {
    public List<Order> getOrders(String fileName){
        Connection connection = null;
        List<Order> result = null;
        try{
            Dao csvdao = new Dao();
            connection = csvdao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            ResultSetHandler<List<Order>> h = new BeanListHandler<Order>(Order.class);
            String query = "SELECT SalesOrderID, SalesOrderNumber, PurchaseOrderNumber, CustomerID, SalesPersonID, TotalDue FROM "+fileName;
            result = queryRunner.query(connection, query, h);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return result;
    }
}
