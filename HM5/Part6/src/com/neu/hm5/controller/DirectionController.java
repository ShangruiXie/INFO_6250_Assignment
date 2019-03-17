package com.neu.hm5.controller;



import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DirectionController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String selection = httpServletRequest.getParameter("selection");
        if(selection == null){
            return new ModelAndView("index");
        }else {
            if (selection.equals("Browse")) {
                return new ModelAndView("redirect:/searchMovie.htm");
            }else if (selection.equals("Add")) {
                return new ModelAndView("redirect:/addMovie.htm");
            }
        }
        return new ModelAndView("index");
    }
}
