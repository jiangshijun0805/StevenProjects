package com.xiaojiang.javabasic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestReg {
    
    public static void main(String[] args) {
        String str = "ГЕЙЕР Йоханнес (DE)";
        String[] target = str.split(" \\(");
        System.out.println(target[0]);
        System.out.println(target[1].replaceAll("\\)", ""));
        
        String reg = "(?<=\\()(.*)(?=\\))";
        
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
    
}
