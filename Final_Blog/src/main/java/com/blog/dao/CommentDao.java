package com.blog.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blog.exception.ArticleException;
import com.blog.exception.CommentException;
import com.blog.pojo.Article;
import com.blog.pojo.Comment;
import com.blog.pojo.User;

public class CommentDao extends DAO {
	
	public Comment create(Comment comment, Article article, ArticleDao articleDao) throws CommentException, ArticleException{
		try {
			begin();
			comment.setArticle(article);
//			article.getComments().add(comment);
//			articleDao.update(article);
			getSession().save(comment);
			commit();
			return comment;
		} catch (HibernateException e) {
			rollback();
			throw new CommentException("Exception while creating comment: " + e.getMessage());
		}finally {
			close();
		}
	}
	
//	public List<Comment> list(Article articleId) throws CommentException {
//		try {
//			begin();
//			Query q = getSession().createQuery("from Category WHERE article_articleId = order by date desc");
////			q.setLong("articleID", articleId);
//			List<Comment> list = q.list();
//			commit();
//			return list;
//		} catch (HibernateException e) {
//			rollback();
//			throw new CommentException("Could not list the comments", e);
//		}finally {
//			close();
//		}
//	}
	
	public Comment get(String content, User user) throws CommentException {
		try {
			begin();
			Query q = getSession().createQuery("FROM Comment WHERE content= :content AND user=:user");
			q.setString("content", content);
			q.setEntity("user", user);
			q.setMaxResults(1);
			Comment comment = (Comment) q.uniqueResult();
			commit();
			return comment;
		} catch (HibernateException e) {
			rollback();
			throw new CommentException("Could not obtain the named comment " + content + " " + e.getMessage());
		}finally {
			close();
		}
	}
	
	public void delete(Comment comment) throws CommentException {
		try {
			begin();
			getSession().delete(comment);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new CommentException("Could not delete the comment", e);
		}finally {
			close();
		}
	}
	
}
