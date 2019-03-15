package com.neu.hm5.validator;

import com.neu.hm5.pojo.Movie;
import com.neu.hm5.pojo.Search;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SearchingValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Search.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "searchMethod", "searchMethod.required") ;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "keyword", "keyword.required");
    }
}
