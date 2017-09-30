package com.xiaojiang.javabasic;

public class TestJava {
    
    public static void main(String[] args) {
        Long date = null;
        
        String str = long2String(date);
        String str2 = String.valueOf(date);
        String str3 = Long.toString(date);
        System.out.println(str);
    }
    
    //对Long类型的日期数据转换为String类型，当使用String.valueof(longdate)，而longdate是null,则会出现转换后为“null”，而不是null。
    public static String long2String(Long number) {
        if (number == null) {
            return null;
        }
        return number.toString();
    }
    
}
