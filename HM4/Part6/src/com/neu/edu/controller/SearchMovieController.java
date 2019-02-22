package com.neu.edu.controller;

import com.neu.edu.dao.MovieDao;
import com.neu.edu.pojo.Movie;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class SearchMovieController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String searchMethod = request.getParameter("searchMethod");
        String keyword = request.getParameter("keyword");
        MovieDao movieDao = new MovieDao();
        List<Movie> movieList = movieDao.getMovies(searchMethod, keyword);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("results");
        mav.addObject("movieList", movieList);
        mav.addObject("keyword", keyword);

        return mav;
    }
}
