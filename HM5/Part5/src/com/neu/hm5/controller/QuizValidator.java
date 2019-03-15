package com.neu.hm5.controller;

import com.neu.hm5.pojo.Quiz;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class QuizValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(Quiz.class);
    }

    @Override
    public void validate(Object o, Errors errors) {

    }

    public void validateAnswer1(String answer1, Errors errors) {
        if (answer1 == null || answer1.equals("")) {
            errors.rejectValue("answer1", "not null", null, "This question is not answered");
        }
    }
    public void validateAnswer2(String answer2, Errors errors) {
        if (answer2 == null || answer2.equals("")) {
            errors.rejectValue("answer2", "not null", null, "This question is not answered");
        }
    }
    public void validateAnswer3(String answer3, Errors errors) {
        if (answer3 == null || answer3.equals("")) {
            errors.rejectValue("answer3", "not null", null, "This question is not answered");
        }
    }
    public void validateAnswer4(String answer4, Errors errors) {
        if (answer4 == null || answer4.equals("")) {
            errors.rejectValue("answer4", "not null", null, "This question is not answered");
        }
    }
    public void validateAnswer5(String answer5, Errors errors) {
        if (answer5 == null || answer5.equals("")) {
            errors.rejectValue("answer5", "not null", null, "This question is not answered");
        }
    }
}

