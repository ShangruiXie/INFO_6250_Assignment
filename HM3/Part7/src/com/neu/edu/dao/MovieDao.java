package com.neu.edu.dao;

import com.neu.edu.pojo.Movie;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;

public class MovieDao {
    public List<Movie> getMovies(String searchMethod, String keyword){
        Connection connection = null;
        List<Movie> result = null;
        try{
            Dao dbdao = new Dao();
            connection = dbdao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            ResultSetHandler<List<Movie>> h = new BeanListHandler<Movie>(Movie.class);
            String query = "SELECT title, actor, actress, genre, year FROM movies WHERE "+ searchMethod +" LIKE '%"+ keyword +"%'";
            result = queryRunner.query(connection, query, h);
//            System.out.println(query+":"+result);
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

    public int addMovies(String title, String actor, String actress, String genre, int year){
        Connection connection = null;
        int result = 0;
        try{
            Dao dbdao = new Dao();
            connection = dbdao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            String query = "INSERT INTO movies (title, actor, actress, genre, year) " +
                    "VALUES (?, ?, ?, ?, ?)";
            result = queryRunner.update(connection, query, title, actor, actress, genre, year);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
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
