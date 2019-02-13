package com.neu.edu.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "NavServlet")
public class NavServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        String option = request.getParameter("option");
        if(option.equals("books")){
            dispatcher = request.getRequestDispatcher("WEB-INF/jsp/books.jsp");
            dispatcher.forward(request, response);
        }else if(option.equals("music")){
            dispatcher = request.getRequestDispatcher("WEB-INF/jsp/music.jsp");
            dispatcher.forward(request, response);
        }else if(option.equals("computers")){
            dispatcher = request.getRequestDispatcher("WEB-INF/jsp/computers.jsp");
            dispatcher.forward(request, response);
        }else if(option.equals("cart")) {
            dispatcher = request.getRequestDispatcher("WEB-INF/jsp/cart.jsp");
            dispatcher.forward(request, response);
        }else {
            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }
}
