package com.neu.hm5.controller;

import com.neu.hm5.dao.MovieDao;
import com.neu.hm5.pojo.Movie;
import com.neu.hm5.validator.SavingValidator;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Deprecated
public class SavingController extends SimpleFormController {
    public SavingController(){
        setCommandClass(Movie.class);
        setCommandName("movie");
        setSuccessView("message");
        setFormView("add");
    }




    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView(getSuccessView());
        String title = request.getParameter("title");
        String actor = request.getParameter("actor");
        String actress = request.getParameter("actress");
        String genre = request.getParameter("genre");
        int year = Integer.parseInt(request.getParameter("year"));

        MovieDao movieDao = (MovieDao)getApplicationContext().getBean("movieDao");
        if(movieDao.addMovies(title,actor,actress,genre,year) == 1){
            mav.addObject("message", "1 Movie Added Successfully");
        }else {
            mav.addObject("message", "Not able to add movies");
        }

        return mav;
    }
}
