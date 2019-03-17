package com.neu.hm5.controller;

import com.neu.hm5.dao.MovieDao;
import com.neu.hm5.pojo.Movie;
import com.neu.hm5.pojo.Search;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.naming.directory.SearchControls;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Deprecated
public class SearchingController extends SimpleFormController {
    public SearchingController(){
        setCommandClass(Search.class);
        setCommandName("search");
//        setCommandName("movie");
        setSuccessView("results");
        setFormView("browse");

    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView();
        String searchMethod = request.getParameter("searchMethod");
        String keyword = request.getParameter("keyword");
        MovieDao movieDao = (MovieDao) getApplicationContext().getBean("movieDao");
        List<Movie> movies = movieDao.getMovies(searchMethod, keyword);
        mav.addObject("movieList", movies);
        mav.addObject("keyword", keyword);
        mav.setViewName(getSuccessView());
        return mav;
    }
}
