package com.blog.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.blog.exception.UserException;
import com.blog.pojo.User;

public class UserDao extends DAO{
	
	public List<User> list() throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User");
			List<User> list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not list the users", e);
		}finally {
			close();
		}
	}
	
	public User get(long userId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where userId = :userId");
			q.setLong("userId", userId);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + userId, e);
		}finally {
			close();
		}
	}
	
	public User get(String username) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where username = :username");
			q.setString("username", username);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + username, e);
		}finally {
			close();
		}
	}

	
	public User register(User user) throws UserException{
		try {
			begin();
			getSession().save(user);
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}finally {
			close();
		}
	}
}
