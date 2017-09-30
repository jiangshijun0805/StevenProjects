package com.test.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFile {
    
    public static void main(String[] args)
        throws Exception {
        //数据写入到文件中 or 数据从文件中读取
        
        //write2file();
        
        //copyFile();
        
        //convertDate();
        
        Long num = null;
        String str_num = num.toString();
        if (str_num == null)
            System.out.println(str_num);
        
        String str = null;
        System.out.println(str);
        
    }
    
    public static void convertDate()
        throws ParseException {
        int intDate = 20170431;
        String pattern = "yyyyMMdd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = sdf.parse(Integer.toString(intDate));
        System.out.println(date);
        System.out.println(sdf.format(date));
    }
    
    public static void copyFile()
        throws FileNotFoundException, IOException {
        DataInputStream datais = new DataInputStream(new FileInputStream(new File("/1.jpg")));
        DataOutputStream dataos = new DataOutputStream(new FileOutputStream(new File("/2.jpg")));
        int count = 0;
        byte[] buffer = new byte[1024];
        while ((count = datais.read(buffer)) > 0) {
            dataos.write(buffer, 0, count);
        }
        datais.close();
        dataos.close();
    }
    
    public static void write2file()
        throws IOException {
        FileWriter fw = new FileWriter(new File("/hello.txt"));
        fw.write("this is 1 line \n");
        fw.write("this is 2 line \n");
        fw.write("this is 3 line \n");
        fw.close();
    }
    
    //对Long类型的日期数据转换为String类型，当使用String.valueof(longdate)，而longdate是null,则会出现转换后为“null”，而不是null。
    //安全的转换方式   
    public static String long2String(Long number) {
        if (number == null) {
            return null;
        }
        return number.toString();
    }
    
}
