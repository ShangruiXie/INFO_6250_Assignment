package com.neu.hm5.dao;


import com.neu.hm5.pojo.Movie;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.query.Query;


import java.util.List;


public class MovieDao  {
//    private static final SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    private final SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();

    private Session session = null;
    private Session getSession(){
        if(session == null || !session.isOpen()){
            session = sf.openSession();
        }
        return session;
    }

    private void beginTransaction(){
        getSession().beginTransaction();
    }
    private void commit(){
        getSession().getTransaction().commit();
    }

    private void close(){
        if(session != null){
            getSession().close();
        }
    }

    private void rollbackTransaction(){
        getSession().getTransaction().rollback();
    }

    @Deprecated
    public List<Movie> getMovies(String searchMethod, String keyword){
        List<Movie> result = null;
        try{
            beginTransaction();
            Query q = getSession().createQuery("from Movie where "+searchMethod+" LIKE :keyword");
//            q.setString("searchMethod", searchMethod);
            q.setString("keyword", "%"+keyword+"%");
            result = q.list();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        }
        finally {
            close();
        }
        return result;
    }

    public int addMovies(String title, String actor, String actress, String genre, int year){
        int result = 0;
        try{
            beginTransaction();
            Movie newMovie = new Movie();
            newMovie.setActor(actor);
            newMovie.setTitle(title);
            newMovie.setActress(actress);
            newMovie.setGenre(genre);
            newMovie.setYear(year);
            getSession().save(newMovie);
            commit();
            result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        }
        finally {
            close();
        }
        return result;
    }
}
