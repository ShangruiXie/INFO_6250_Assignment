package com.blog.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.blog.exception.ArticleException;
import com.blog.pojo.Article;
import com.blog.pojo.User;

public class ArticleDao extends DAO{

	public Article create(Article article) throws ArticleException{
		try {
			begin();
			getSession().save(article);
			commit();
			return article;
		} catch (HibernateException e) {
			rollback();
			throw new ArticleException("Exception while creating article: " + e.getMessage());
		}finally {
			close();
		}
	}
	
	public void update(Article article) throws ArticleException {
		try {
			begin();
			getSession().update(article);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new ArticleException("Could not save the article", e);
		}finally {
			close();
		}
	}

	public void delete(Article article) throws ArticleException {
		try {
			begin();
			getSession().delete(article);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new ArticleException("Could not delete the category", e);
		}finally {
			close();
		}
	}
	
	public Article get(String title, User user) throws ArticleException {
		try {
			begin();
			Query q = getSession().createQuery("FROM Article WHERE title= :title AND user=:user");
			q.setString("title", title);
			q.setEntity("user", user);
			q.setMaxResults(1);
			Article article = (Article) q.uniqueResult();
			commit();
			return article;
		} catch (HibernateException e) {
			rollback();
			throw new ArticleException("Could not obtain the named article " + title + " " + e.getMessage());
		}finally {
			close();
		}
	}
	
	public Article get(long articleId) throws ArticleException {
		try {
			begin();
			Query q = getSession().createQuery("FROM Article WHERE articleId = :articleId");
			q.setLong("articleId", articleId);
			q.setMaxResults(1);
			Article article = (Article) q.uniqueResult();
			commit();
			return article;
		} catch (HibernateException e) {
			rollback();
			throw new ArticleException("Could not obtain the named articleId " + articleId + " " + e.getMessage());
		}finally {
			close();
		}
	}

	public List<Article> list(User user) throws ArticleException {
		try {
			begin();
			Query q = getSession().createQuery("FROM Article WHERE user=:user");
			q.setEntity("user", user);
			List<Article> list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new ArticleException("Could not list the articles", e);
		}finally {
			close();
		}
	}
	
	
}
