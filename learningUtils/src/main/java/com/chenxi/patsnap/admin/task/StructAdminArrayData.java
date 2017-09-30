package com.chenxi.patsnap.admin.task;

import java.util.Arrays;

public class StructAdminArrayData {
    
    public static void main(String[] args) {
        //  生成目标字符串：    {"20030101", "20030131", "2003.01"}
        
        //按照年，每年一个字符串
        /*for (int i = 1980; i < 1991; i++) {
            String[] arr = new String[3];
            arr[0] = i + "0101";
            arr[1] = i + "1231";
            arr[2] = i + ".00";
            System.out.println(Arrays.asList(arr));
            //System.out.println("end");
        }*/
        
        //跨多个年份
        /* String[][] data = {{"1900", "1930"}, {"1931", "1945"}, {"1946", "1955"}, {"1956", "1965"}, {"1966", "1970"},
            {"1971", "1975"}, {"1976", "1979"}};
        for (int i = 0; i < data.length; i++) {
            String[] arr = new String[3];
            arr[0] = data[i][0] + "0101";
            arr[1] = data[i][1] + "1231";
            arr[2] = data[i][0] + ".99";
            System.out.println(Arrays.asList(arr));
        }*/
        //{"20000101", "20000331", "2000.01"}
        //{"20000401", "20000630", "2000.02"}
        // {"20000701", "20000930", "2000.03"}
        // {"20001001", "20001231", "2000.04"}
        
        //按照季度，每季度一个字符串
        /*for (int i = 1984; i <= 2016; i++) {
            String[] arr1 = new String[3];
            String[] arr2 = new String[3];
            String[] arr3 = new String[3];
            String[] arr4 = new String[3];
            
            arr1[0] = i + "0101";
            arr1[1] = i + "0331";
            arr1[2] = i + ".00";
            
            arr2[0] = i + "0401";
            arr2[1] = i + "0630";
            arr2[2] = i + ".01";
            
            arr3[0] = i + "0701";
            arr3[1] = i + "0930";
            arr3[2] = i + ".02";
            
            arr4[0] = i + "1001";
            arr4[1] = i + "1231";
            arr4[2] = i + ".03";
            
            System.out.println(Arrays.asList(arr1));
            System.out.println(Arrays.asList(arr2));
            System.out.println(Arrays.asList(arr3));
            System.out.println(Arrays.asList(arr4));
            //System.out.println("end");
        }*/
        
        /*//四个月一条数据
        for (int i = 1980; i <= 2016; i++) {
            String[] arr1 = new String[3];
            String[] arr2 = new String[3];
            String[] arr3 = new String[3];
            
            arr1[0] = i + "0101";
            arr1[1] = i + "0430";
            arr1[2] = i + ".00";
            
            arr2[0] = i + "0501";
            arr2[1] = i + "0831";
            arr2[2] = i + ".01";
            
            arr3[0] = i + "0901";
            arr3[1] = i + "1231";
            arr3[2] = i + ".02";
            
            System.out.println(Arrays.asList(arr1));
            System.out.println(Arrays.asList(arr2));
            System.out.println(Arrays.asList(arr3));
            
        }*/
        
        //半年一条数据
        /*for (int i = 1981; i <= 2016; i++) {
            String[] arr1 = new String[3];
            String[] arr2 = new String[3];
            
            arr1[0] = i + "0101";
            arr1[1] = i + "0630";
            arr1[2] = i + ".00";
            
            arr2[0] = i + "0701";
            arr2[1] = i + "1231";
            arr2[2] = i + ".01";
            
            System.out.println(Arrays.asList(arr1));
            System.out.println(Arrays.asList(arr2));
            
        }*/
        
        //按照月份，每月份一个字符串
        for (int i = 1991; i <= 2016; i++) {
            String[] arr1 = new String[3];
            String[] arr2 = new String[3];
            String[] arr3 = new String[3];
            String[] arr4 = new String[3];
            
            String[] arr5 = new String[3];
            String[] arr6 = new String[3];
            String[] arr7 = new String[3];
            String[] arr8 = new String[3];
            
            String[] arr9 = new String[3];
            String[] arr10 = new String[3];
            String[] arr11 = new String[3];
            String[] arr12 = new String[3];
            
            arr1[0] = i + "0101";
            arr1[1] = i + "0131";
            arr1[2] = i + ".01";
            
            arr2[0] = i + "0201";
            arr2[1] = i + "0228";
            arr2[2] = i + ".02";
            
            arr3[0] = i + "0301";
            arr3[1] = i + "0331";
            arr3[2] = i + ".03";
            
            arr4[0] = i + "0401";
            arr4[1] = i + "0430";
            arr4[2] = i + ".04";
            
            arr5[0] = i + "0501";
            arr5[1] = i + "0531";
            arr5[2] = i + ".05";
            
            arr6[0] = i + "0601";
            arr6[1] = i + "0630";
            arr6[2] = i + ".06";
            
            arr7[0] = i + "0701";
            arr7[1] = i + "0731";
            arr7[2] = i + ".07";
            
            arr8[0] = i + "0801";
            arr8[1] = i + "0831";
            arr8[2] = i + ".08";
            
            arr9[0] = i + "0901";
            arr9[1] = i + "0930";
            arr9[2] = i + ".09";
            
            arr10[0] = i + "1001";
            arr10[1] = i + "1031";
            arr10[2] = i + ".10";
            
            arr11[0] = i + "1101";
            arr11[1] = i + "1130";
            arr11[2] = i + ".11";
            
            arr12[0] = i + "1201";
            arr12[1] = i + "1231";
            arr12[2] = i + ".12";
            
            System.out.println(Arrays.asList(arr1));
            System.out.println(Arrays.asList(arr2));
            System.out.println(Arrays.asList(arr3));
            System.out.println(Arrays.asList(arr4));
            System.out.println(Arrays.asList(arr5));
            System.out.println(Arrays.asList(arr6));
            System.out.println(Arrays.asList(arr7));
            System.out.println(Arrays.asList(arr8));
            System.out.println(Arrays.asList(arr9));
            System.out.println(Arrays.asList(arr10));
            System.out.println(Arrays.asList(arr11));
            System.out.println(Arrays.asList(arr12));
            //System.out.println("end");
        }
        
        //System.out.println("end");
    }
}
