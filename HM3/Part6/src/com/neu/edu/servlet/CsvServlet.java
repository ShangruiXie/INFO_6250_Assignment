package com.neu.edu.servlet;

import com.neu.edu.dao.CsvDao;
import com.neu.edu.pojo.Order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet(name = "CsvServlet")
public class CsvServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("csv");
        CsvDao csvDao = new CsvDao();
        List<Order> orderList = csvDao.getOrders(fileName);
        request.setAttribute("orderList", orderList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/orders.jsp");
        dispatcher.forward(request, response);
    }
}
