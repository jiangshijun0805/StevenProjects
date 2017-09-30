package com.xiaojiang.freamwork.validator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import com.xiaojiang.freamwork.parser.IAnnotationParser;
import com.xiaojiang.freamwork.parser.NotBlankParser;

public class AnnotationValidator {
    public static final Logger logger = Logger.getLogger(AnnotationValidator.class);
    
    private final static List<IAnnotationParser> vList = new ArrayList<IAnnotationParser>();
    static {
        vList.add(new NotBlankParser());
    }
    
    //注意此处定义了一个泛型方法，泛型方法可以独立于泛型类而独立存在
    public static <T> ValidateResult validate(T t) {
        ValidateResult validateResult = null;
        for (Field f : t.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            Object value = null;
            try {
                value = f.get(t);
            }
            catch (IllegalArgumentException e) {
                logger.log(Priority.ERROR, "IllegalArgumentException", e);
            }
            catch (IllegalAccessException e) {
                logger.log(Priority.ERROR, "IllegalAccessException", e);
            }
            
            for (IAnnotationParser ap : vList) {
                validateResult = ap.validate(f, value);
                if (!validateResult.getIsValid()) {
                    return validateResult;
                }
            }
        }
        return validateResult;
    }
    
    public static void register(IAnnotationParser parser) {
        vList.add(parser);
    }
}
