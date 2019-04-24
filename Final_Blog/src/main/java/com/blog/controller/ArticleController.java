package com.blog.controller;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.blog.dao.ArticleDao;
import com.blog.dao.CommentDao;
import com.blog.dao.UserDao;
import com.blog.exception.ArticleException;
import com.blog.exception.UserException;
import com.blog.pojo.Article;
import com.blog.pojo.Comment;
import com.blog.pojo.User;

import javassist.tools.reflect.CannotCreateException;

@Controller
public class ArticleController {
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	CommentDao commentDao;
	
	@Autowired
	ArticleDao articleDao;
	
	@RequestMapping(value = "/bloglist", method = RequestMethod.GET)
	public ModelAndView viewBloglist(HttpServletRequest request) throws ArticleException, UserException {
		//display 'username' blog, but only 'userId' could manipulate his blog.
		ModelAndView mav = new ModelAndView("bloglist");
		String blogUsername = request.getParameter("user");
		User blogUser = userDao.get(blogUsername);
		int page = Integer.parseInt(request.getParameter("page"));
		HttpSession session = request.getSession();
		User user = userDao.get((Long)session.getAttribute("userId"));
		
		
		List<User> users = userDao.list();
		List<Article> articles = articleDao.list(blogUser);
	
//need seprate  to many pages
		mav.addObject("owner", user);
		mav.addObject("articles", articles);
		mav.addObject("blogUserId", blogUser.getUserId());
		mav.addObject("blogUsername", blogUsername);
		mav.addObject("users", users);

		return mav;
	}
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		if(request.getParameter("message") != null) {
			mav.addObject("message", request.getParameter("message"));
		}
		return mav;
	}
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(HttpServletRequest request) throws ArticleException, UserException {
		ModelAndView mav = new ModelAndView("edit");
		if(request.getParameter("writer") != null) {
			String writerName = request.getParameter("writer");
			String title = request.getParameter("title");
			HttpSession session = request.getSession();
			User writer = userDao.get(writerName);
			Article article = articleDao.get(title, writer);
			if(session.getAttribute("userId") != null ) {
				if(article.getUser().getUserId() == (Long)session.getAttribute("userId"))
					mav.addObject("article", article);
			}
		}
		if(request.getParameter("message") != null) {
			mav.addObject("message", request.getParameter("message"));
		}
		return mav;
	}
	
	@RequestMapping(value="/createArticle", method = RequestMethod.POST)
	public ModelAndView createArticle(HttpServletRequest request) throws ArticleException, UserException {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		if(session.getAttribute("userId") != null) {
		
			long userId = (Long)session.getAttribute("userId");
			User user = userDao.get(userId);
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			Date date = new Date();		
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String dateString = sdf.format(date); 
			
			
			try {
				Article article = new Article();
				article.setUser(user);
				article.setTitle(title);
				article.setContent(content);
				article.setDate(dateString);
				articleDao.create(article);
			}catch (Exception e) {
				// TODO: handle exception
				return new ModelAndView("redirect:/create", "message", "cannot create your blog");
			}


			return new ModelAndView("redirect:/bloglist?user="+user.getUsername()+"&page=1");
		}else {
			return new ModelAndView("login", "message", "please login first");
		}
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.POST)
	public ModelAndView editArticle(HttpServletRequest request) throws ArticleException, UserException {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		if(session.getAttribute("userId") != null) {
		
			long userId = (Long)session.getAttribute("userId");
			User user = userDao.get(userId);
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			Date date = new Date();		
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String dateString = sdf.format(date); 
			
			try {
				if(request.getParameter("articleId") != "") {
					long articleId = Long.parseLong(request.getParameter("articleId"));
					Article article = articleDao.get(articleId);
					article.setContent(content);
					article.setDate(dateString);
					article.setTitle(title);
					articleDao.update(article);
				}
			}catch (Exception e) {
				// TODO: handle exception
				return new ModelAndView("redirect:edit?writer="+user.getUsername()+"&title="+title,"message","cannot edit this article");
			}
			return new ModelAndView("redirect:/bloglist?user="+user.getUsername()+"&page=1");
		}else {
			return new ModelAndView("login", "message", "please login first");
		}
	}
	
	@RequestMapping(value = "/article", method = RequestMethod.GET)
	public ModelAndView viewBlog(@RequestParam("writer") String writerName,
								@RequestParam("title") String title, HttpServletRequest request) throws UserException, ArticleException {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("blog");
		try {
			User writer = userDao.get(writerName);
			Article article = articleDao.get(title, writer);
			if(request.getParameter("message") != null) {
				mav.addObject("message", request.getParameter("message"));
			}
			mav.addObject("article", article);
			if(article.getComments() != null) {
				List<Comment> comments = new ArrayList<Comment>(article.getComments());
		        Collections.sort(comments, new Comparator<Comment>(){
		            public int compare(Comment comment1, Comment comment2) {
		                return comment2.getDate().compareTo(comment1.getDate());
		            }
		        });

				mav.addObject("comments", comments);
			}
			return mav;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ModelAndView("error", "message", "The article is not exist");
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("writer") String writerName,
					@RequestParam("title") String title, HttpServletRequest request) throws ArticleException, UserException {
		HttpSession session = request.getSession();
		long userId = (Long) session.getAttribute("userId");
		User user = userDao.get(userId);
		Article article = articleDao.get(title, user);
		articleDao.delete(article);
		return "redirect:/bloglist?user="+user.getUsername()+"&page=1";
	}
	
}
