package com.chenxi.patsnap.dvlist;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ClassificationDataByCountry {
    
    public static void main(String[] args)
        throws Exception {
        String[] countries = {"AL", "CY", "MK", "AP", "MT", "EE", "LV", "LT", "SI", "IS", "CO", "HR", "BX", "SK", "BG",
            "TN", "GR", "NO", "DK", "PL", "SE", "MX", "RO", "MA", "CZ", "RU", "AT", "BR"};
        File[] files = new File[28];
        for (int i = 0; i < files.length; i++) {
            files[i] = new File("G://dv/" + countries[i]);
        }
        FileWriter[] fileWriter = new FileWriter[28];
        for (int i = 0; i < files.length; i++) {
            fileWriter[i] = new FileWriter(files[i]);
        }
        
        //读取源文件
        File src = new File("G://Other_28_CC");
        for (File f : src.listFiles()) {
            List<String> lines = FileUtils.readLines(f);
            for (String s : lines) {
                String cc = s.substring(0, 2);
                for (int i = 0; i < files.length; i++) {
                    if (cc.equals(files[i].getName())) {
                        //fileWriter.write(s+"\n");
                        fileWriter[i].write(s + "\n");
                    }
                }
            }
        }
        
        //关闭文件
        for (int i = 0; i < files.length; i++) {
            fileWriter[i].close();
        }
    }
    
}
