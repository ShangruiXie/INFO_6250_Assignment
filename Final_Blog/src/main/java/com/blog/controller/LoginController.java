package com.blog.controller;

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

import com.blog.dao.UserDao;
import com.blog.exception.UserException;
import com.blog.pojo.User;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {	
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String password) throws UserException {
		if(userDao.get(username) != null) {
			User user = userDao.get(username);
			if(user.getPassword().equals(password)) {
				long userId = user.getUserId();
				HttpSession session = request.getSession();
				session.setAttribute("userId", userId);
				session.setAttribute("username", username);
				return new ModelAndView("redirect:/bloglist?user="+username+"&page=1");
			}
		}
		return new ModelAndView("login", "message", "wrong username or password");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) throws UserException {
//		ModelAndView mav = new ModelAndView("login");
		User newUser = new User();
		if(userDao.get(username) == null) {
			newUser.setUsername(username);
			newUser.setPassword(password);
			userDao.register(newUser);
			HttpSession session = request.getSession();
			session.setAttribute("userId", newUser.getUserId());
			return new ModelAndView("redirect:/bloglist?user="+username+"&page=1");
		}else {
			return new ModelAndView("login", "message", "username is exist");
		}
//		return mav;
	}
}
