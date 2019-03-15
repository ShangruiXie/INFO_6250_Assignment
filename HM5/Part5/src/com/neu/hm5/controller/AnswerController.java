package com.neu.hm5.controller;

import com.neu.hm5.pojo.Quiz;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Deprecated
public class AnswerController extends AbstractWizardFormController {
    private String successView;
    private String cancelView;

    public String getSuccessView() {
        return successView;
    }

    public void setSuccessView(String successView) {
        this.successView = successView;
    }

    public String getCancelView() {
        return cancelView;
    }

    public void setCancelView(String cancelView) {
        this.cancelView = cancelView;
    }


    @Override
    protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        Quiz quiz = (Quiz) command;
        ModelAndView mav = new ModelAndView();
        mav.setViewName(this.getSuccessView());
        mav.addObject("result", quiz);
        mav.addObject("score", quiz.getScore());
        return mav;
    }

    @Override
    protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        return new ModelAndView(this.cancelView);
    }

    @Override
    protected void validatePage(Object command, Errors errors, int page) {
        Quiz quiz = (Quiz) command;
        QuizValidator quizValidator = (QuizValidator)getValidator();
        switch (page){
            case 1:
                quizValidator.validateAnswer1(quiz.getAnswer1(), errors);
                break;
            case 2:
                quizValidator.validateAnswer2(quiz.getAnswer2(), errors);
                break;
            case 3:
                quizValidator.validateAnswer3(quiz.getAnswer3(), errors);
                break;
            case 4:
                quizValidator.validateAnswer4(quiz.getAnswer4(), errors);
                break;
            case 5:
                quizValidator.validateAnswer5(quiz.getAnswer5(), errors);
                break;
        }
    }
}
