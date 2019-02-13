package com.neu.edu.servlet;

import com.neu.edu.pojo.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;


//@WebServlet(name = "cart")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String[] product = request.getParameterValues("item");
        List<Product> cartProducts = (List<Product>) session.getAttribute("cartProducts");
        for(int i=0; i<product.length; i++){
            Product p = new Product();
            String[] temp = product[i].split(":");
            p.setProductName(temp[0]);
            p.setPrice(Double.parseDouble(temp[1]));
            if(cartProducts.contains(p)){
                cartProducts.remove(p);
            }
        }
        session.setAttribute("cartProducts", cartProducts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/cart.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //display products list
        List<Product> addProducts = new ArrayList<>();
        List<Product> cartProducts;
        HttpSession session = request.getSession();
        if(session.getAttribute("cartProducts") == null){
            cartProducts = new ArrayList<>();
        }else {
            cartProducts = (List<Product>) session.getAttribute("cartProducts");
        }
        String[] product = request.getParameterValues("product");
        for(int i=0; i<product.length; i++){
            Product p = new Product();
            String[] temp = product[i].split(":");

//            for(int j=0; j<temp.length; j++)
//                System.out.println(temp[j]);

            p.setProductName(temp[0]);
            p.setPrice(Double.parseDouble(temp[1]));
            addProducts.add(p);
            if(!cartProducts.contains(p))
                cartProducts.add(p);
        }
        session.setAttribute("cartProducts", cartProducts);
        request.setAttribute("addProducts", addProducts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/success.jsp");
        dispatcher.forward(request, response);
    }
}
