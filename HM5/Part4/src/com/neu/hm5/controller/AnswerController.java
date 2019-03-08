package com.neu.hm5.controller;

import com.neu.hm5.dao.QuestionDao;
import com.neu.hm5.pojo.Question;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;

public class AnswerController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        String uri = httpServletRequest.getRequestURI();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("question");
        QuestionDao questionDao = new QuestionDao();
        ArrayList<Question> questions = questionDao.getQuestions();
        //initialize Session "answers"
        HttpSession session = httpServletRequest.getSession();
        ArrayList<String> answers = (ArrayList<String>) session.getAttribute("answers");
        if(answers == null){
            answers = new ArrayList<>(Collections.nCopies(6, "no answer"));
        }
        //button click event
        if(httpServletRequest.getParameter("answer") != null){

            int qnum = Integer.parseInt(httpServletRequest.getParameter("qnum"));
            String answer = httpServletRequest.getParameter("answer");
            answers.set(qnum, answer);
            session.setAttribute("answers", answers);
            //get page number
            int pagenum = Integer.parseInt(uri.substring(12, 13));
            mav.setViewName("redirect:/q" + String.valueOf(pagenum + 1) + ".htm");
            if(pagenum == 5) {
                ArrayList<String> correctAnswers = new ArrayList<>(){{
                    for(int i=0; i<5; i++){
                        add(questions.get(i).getCorrectAnswer());
                    }
                }};
                mav.setViewName("view");
                mav.addObject("correctAnswers", correctAnswers);

                //score
                int score=0;
                for(int i=0; i<5; i++){
                    if(answers.get(i+1).equals(correctAnswers.get(i)))
                        score++;
                }
                mav.addObject("score", score);
            }
            return mav;
        }
        //url method
        if(uri.endsWith("q1.htm")){
            mav.addObject("question", questions.get(0));
        }else if(uri.endsWith("q2.htm")){
            mav.addObject("question", questions.get(1));
        }else if(uri.endsWith("q3.htm")){
            mav.addObject("question", questions.get(2));
        }else if(uri.endsWith("q4.htm")){
            mav.addObject("question", questions.get(3));
        }else if(uri.endsWith("q5.htm")){
            mav.addObject("question", questions.get(4));
        }else if(uri.endsWith("q6.htm")){
            mav.setViewName("view");
        }else {
            mav.addObject("question", questions.get(0));
        }

        return mav;
    }
}
