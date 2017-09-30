package com.xiaojiang.freamwork.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestGenerics {
    
    public static void main(String[] args) {
        
        List<String> list = new ArrayList<String>();
        list.add("CSDN_SEU_Cavin");
        list.add("100");
        for (int i = 0; i < list.size(); i++) {
            String name = (String)list.get(i); //取出Integer时，运行时出现异常  
            System.out.println("name:" + name);
        }
        
        List<String> list2 = new ArrayList<String>();
        List list3 = new ArrayList();
        System.out.println(list2.getClass() == list3.getClass());
        
        List<String> list4 = new ArrayList<String>();
        list4.add("xiaojiang");
        Class c = list4.getClass();
        try {
            Method method = c.getMethod("add", Object.class);
            method.invoke(list4, 100);
            System.out.println(list4);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
