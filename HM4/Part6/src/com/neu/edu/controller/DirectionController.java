package com.neu.edu.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DirectionController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String selection = request.getParameter("selection");
        if(selection.equals("Browse")){
            return new ModelAndView("browse");
        }else {
            return new ModelAndView("add");
        }
    }
}
