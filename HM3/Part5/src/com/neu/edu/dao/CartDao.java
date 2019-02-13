package com.neu.edu.dao;

import com.neu.edu.pojo.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CartDao {
    public List<Product> getProducts(){
        Connection connection = null;
        List<Product> result = null;
        try{
            Dao dbdao = new Dao();
            connection = dbdao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            ResultSetHandler<List<Product>> resultSetHandler = new BeanListHandler<Product>(Product.class);
            String query = "SELECT * FROM cart";
            result = queryRunner.query(connection, query, resultSetHandler);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            try{
                if(connection != null)
                    connection.close();
            }catch (SQLException ex){
                System.out.println("SQLException" + ex.getMessage());
            }
        }
        return result;
    }

    public int addProducts(Product product){
        Connection connection = null;
        int result = 0;
        try{
            Dao dbdao = new Dao();
            connection = dbdao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            String query = "INSERT INTO cart (name, price) VALUES (?,?)";
            result = queryRunner.update(connection, query, product.getProductName(), product.getPrice());
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            try {
                if (connection != null)
                    connection.close();
            }catch (SQLException ex){
                System.out.println("SQLException" + ex.getMessage());
            }
        }
        return result;
    }

    public int removeProducts(String productName){
        Connection connection = null;
        int result = 0;
        try{
            Dao dbdao = new Dao();
            connection = dbdao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            String query = "DELETE FROM cart WHERE name = ?";
            result = queryRunner.update(connection, query, productName);

        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            try {
                if (connection != null)
                    connection.close();
            }catch (SQLException ex){
                System.out.println("SQLException" + ex.getMessage());
            }
        }
        return result;
    }
}
