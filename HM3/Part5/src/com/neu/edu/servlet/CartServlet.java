package com.neu.edu.servlet;

import com.neu.edu.dao.CartDao;
import com.neu.edu.pojo.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@WebServlet(name = "cart")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //add & remove products
        CartDao cartDao = new CartDao();
        String option = request.getParameter("option");
        String[] items = request.getParameterValues("item");



        if(option.equals("add")){
            for(int i=0; i< items.length; i++){
                String[] temp = items[i].split("$");
                Product product = new Product(temp[0], Double.parseDouble(temp[1]));
                cartDao.addProducts(product);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/addSucc.jsp");
            dispatcher.forward(request, response);

        }else if(option.equals("remove")){
            for(int i=0; i< items.length; i++){
                String[] temp = items[i].split("$");
                String productName = temp[0];
                cartDao.removeProducts(productName);
            }
            response.sendRedirect("./WEB-INF/jsp/Cart.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //display products list
        HttpSession session = request.getSession();
        CartDao cartDao = new CartDao();
        List<Product> productsList = cartDao.getProducts();
        String[] products = productsList.toArray(new String[productsList.size()]);
        session.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher(".WEB-INF/jsp/addSucc.jsp");
        dispatcher.forward(request, response);

    }
}
