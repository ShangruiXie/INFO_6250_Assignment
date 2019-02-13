package com.neu.edu.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "DirectionServlet")
public class DirectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selection = request.getParameter("selection");
        RequestDispatcher dispatcher;
        if(selection.equals("Browse")){
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/browse.jsp");
            dispatcher.forward(request, response);
        }else if(selection.equals("Add")){
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/add.jsp");
            dispatcher.forward(request, response);
        }
    }
}
