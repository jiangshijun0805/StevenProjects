package com.steven.shell;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestShell {
    
    public static void main(String[] args) {
        
    }
    
    public static Boolean killPid2(String exeName) {
        System.out.println("kill phantom js begin " + exeName);
        Boolean flag = false;
        try {
            String command = "ps aux|grep '" + exeName + "'|awk '{print $2}'|xargs kill -9";
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()), 1024);
            System.out.println("kill phantomjs pid success");
            flag = true;
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
