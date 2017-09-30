package com.steven.set;

import java.util.HashSet;
import java.util.Set;

public class TestSet {
    
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();
        set.add("a");
        set.add("b");
        set.add("c");
        System.out.println(set.toString());
        
        set2.add("b");
        set2.add("d");
        
        set.removeAll(set2);
        System.out.println(set.toString());
        System.out.println(set2.toString());
    }
    
}
