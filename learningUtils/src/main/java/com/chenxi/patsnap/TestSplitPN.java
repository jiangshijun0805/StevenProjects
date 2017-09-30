package com.chenxi.patsnap;

import java.util.UUID;

public class TestSplitPN {
    
    public static void main(String[] args) {
        String pn_id = "2f7dd4d3-c23e-4d08-8a9d-d58497e506e9";
        getStoragePath();
    }
    
    public static String getStoragePath() {
        String storage_path = "PATENT/WG";
        String id = UUID.randomUUID().toString().replace("-", "");
        System.out.println("uuid generate id = " + id);
        for (int i = 0; i < id.length(); i++) {
            if (i % 2 == 0) {
                storage_path += "/" + id.charAt(i);
            }
            else {
                storage_path = storage_path + id.charAt(i);
            }
        }
        if (!storage_path.endsWith("/")) {
            storage_path = storage_path + "/";
        }
        System.out.println(storage_path);
        return storage_path;
    }
}
