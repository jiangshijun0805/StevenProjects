package com.xiaojiang.freamwork.parser;

import java.lang.reflect.Field;

import com.xiaojiang.freamwork.annotation.NotBlank;
import com.xiaojiang.freamwork.validator.ValidateResult;

public class NotBlankParser implements IAnnotationParser {
    
    @Override
    public ValidateResult validate(Field f, Object value) {
        ValidateResult validateResult = new ValidateResult();
        if (f.isAnnotationPresent(NotBlank.class)) {
            NotBlank notBlank = f.getAnnotation(NotBlank.class);
            if (value == null || value.toString().length() == 0) {
                validateResult.setIsValid(false);
                validateResult.setMessage(notBlank.fieldName() + "不能为空");
            }
        }
        return validateResult;
    }
    
}
