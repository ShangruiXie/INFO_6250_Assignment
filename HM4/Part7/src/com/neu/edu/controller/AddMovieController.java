package com.neu.edu.controller;

import com.neu.edu.dao.MovieDao;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddMovieController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{
            String title = request.getParameter("title");
            String actor = request.getParameter("actor");
            String actress = request.getParameter("actress");
            String genre = request.getParameter("genre");
            int year = Integer.parseInt(request.getParameter("year"));
            MovieDao movieDao = new MovieDao();
            int result = movieDao.addMovies(title, actor, actress, genre, year);
            if(result == 1){
                return new ModelAndView("message", "message", "1 Movie Added Successfully");
            }else {
                return new ModelAndView("message", "message", "Not able to add movies");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ModelAndView("message", "message", "Not able to add movies");
        }




    }
}
