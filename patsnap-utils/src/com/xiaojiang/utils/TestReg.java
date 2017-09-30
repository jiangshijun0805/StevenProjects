package com.xiaojiang.utils;

public class TestReg {
    
    public static void main(String[] args) {
        /*String test = "a b  c     d e";
        String[] str = test.split(" +");
        for (String s : str) {
            System.out.println(s);
        }*/
        String patent_id = "a25fefe6-b347-4811-b5e6-626b997bc049";
        String pn = "KR3004522670000S";
        String pn_design = "KR3004522670000M01";
        String repairPN = null;
        
        if (pn != null && pn.endsWith("0000S") && pn_design != null && pn_design.indexOf("M") >= 0) {
            String temp = pn_design.substring(pn_design.indexOf("M") + 1);
            repairPN = pn.substring(0, pn.length() - 5) + add0(temp, 4) + "S";
            System.out.println(repairPN);
        }
    }
    
    public static String add0(String string, int i) {
        int addLength = i - string.length();
        for (int j = 0; j < addLength; j++) {
            string = "0" + string;
        }
        return string;
    }
}
