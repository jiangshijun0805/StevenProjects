package com.xiaojiang.freamwork.test;

import com.xiaojiang.freamwork.model.User;
import com.xiaojiang.freamwork.validator.AnnotationValidator;
import com.xiaojiang.freamwork.validator.ValidateResult;

public class TestAnnotationValidator {
    public static void main(String[] args) {
        User user = new User();
        ValidateResult result = AnnotationValidator.validate(user);
        if (result.getIsValid()) {
            System.out.println("校验通过");
        }
        else {
            System.out.println(result.getMessage());
        }
    }
}
