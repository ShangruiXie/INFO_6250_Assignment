package com.neu.edu.servlet;

import com.neu.edu.dao.MovieDao;
import com.neu.edu.pojo.Movie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet(name = "MovieServlet")
public class MovieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MovieDao movieDao = new MovieDao();
        RequestDispatcher dispatcher;
        String title = request.getParameter("title");
        String actor = request.getParameter("actor");
        String actress = request.getParameter("actress");
        String genre = request.getParameter("genre");
        int year = Integer.parseInt(request.getParameter("year"));
        int addMovies = movieDao.addMovies(title, actor, actress, genre, year);

        request.setAttribute("addMovies", addMovies);
        dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/success.jsp");
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MovieDao movieDao = new MovieDao();
        RequestDispatcher dispatcher;
        String searchMethod = request.getParameter("searchMethod");
        String keyword = request.getParameter("keyword");
        List<Movie> movieList = movieDao.getMovies(searchMethod, keyword);
        request.setAttribute("keyword", keyword);
        request.setAttribute("movieList", movieList);
        dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/results.jsp");
        dispatcher.forward(request, response);

    }
}
