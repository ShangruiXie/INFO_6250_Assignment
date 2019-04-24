package com.blog.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blog.dao.ArticleDao;
import com.blog.dao.CommentDao;
import com.blog.dao.UserDao;
import com.blog.exception.ArticleException;
import com.blog.exception.CommentException;
import com.blog.exception.UserException;
import com.blog.pojo.Article;
import com.blog.pojo.Comment;
import com.blog.pojo.User;


@Controller
public class CommentController {
	
	@Autowired
	ArticleDao articleDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	CommentDao commentDao;
	
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

	@RequestMapping(value = "/comment/add", method = RequestMethod.GET)
	public ModelAndView add(@RequestParam("commentContent") String commentContent,
							@RequestParam("writer") String writer,
							@RequestParam("title") String title, HttpServletRequest request) throws UserException, CommentException, ArticleException {
		HttpSession session = request.getSession();
		long userId = (Long)session.getAttribute("userId");
		Date date = new Date();		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dateString = sdf.format(date); 
		try {
			User user = userDao.get(userId);
			Comment comment = new Comment();
			comment.setContent(commentContent);
			comment.setUser(user);
			comment.setDate(dateString);
			Article article = articleDao.get(title, userDao.get(writer));
			commentDao.create(comment, article, articleDao);
			return new ModelAndView("redirect:/article?writer="+writer+"&title="+title);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("redirect:/article?writer="+writer+"&title="+title);
			mav.addObject("message", "fail to add a comment");
			return mav;
		}
		
	}
	
	@RequestMapping(value = "/comment/delete", method = RequestMethod.GET)
	public ModelAndView delect(@RequestParam("commentContent") String commentContent,
								@RequestParam("writer") String writer,
								@RequestParam("title") String title, HttpServletRequest request) throws UserException, CommentException {
		HttpSession session = request.getSession();
		long userId = (Long)session.getAttribute("userId");
		User user = userDao.get(userId);
		Comment comment = commentDao.get(commentContent, user);
		commentDao.delete(comment);
		return new ModelAndView("redirect:/article?writer="+writer+"&title="+title);
	}
	
}
