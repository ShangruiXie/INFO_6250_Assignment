package com.neu.hm5.validator;

import com.neu.hm5.pojo.Movie;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SavingValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Movie.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Movie movie = (Movie)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actor", "actor.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actress", "actress.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genre", "genre.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "year.required");
    }
}
