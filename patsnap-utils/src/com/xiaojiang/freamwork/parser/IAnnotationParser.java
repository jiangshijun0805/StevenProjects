package com.xiaojiang.freamwork.parser;

import java.lang.reflect.Field;

import com.xiaojiang.freamwork.validator.ValidateResult;

public interface IAnnotationParser {
    public ValidateResult validate(Field f, Object value);
}
