package com.test.utils;

import java.util.regex.Pattern;

public class TestReg2 {
    
    public static void main(String[] args) {
        String value = "ds";
        if (Pattern.matches("^[0-9]*$", value)) {
            System.out.println("******* " + value);
        }
        else {
            System.out.println("alth  " + value);
        }
        
    }
    
}
