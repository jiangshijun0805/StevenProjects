package com.xiaojiang.utils;

public class GenerateCode {
    
    public static void main(String[] args) {
        String[] countries = {"AM", "AP", "AR", "AT", "BA", "BE", "BG", "BR", "BY", "CL", "CO", "CR", "CS", "CU", "CY",
            "CZ", "DK", "DO", "DZ", "EA", "EC", "EE", "EG", "ES", "GC", "GE", "GR", "GT", "HN", "HR", "HU", "ID", "IE",
            "IL", "IS", "IT", "JO", "KE", "KG", "KZ", "LT", "LU", "LV", "MA", "MC", "MD", "ME", "MN", "MT", "MW", "MX",
            "MY", "NI", "NL", "OA", "PA", "PE", "PH", "PL", "PT", "RO", "RS", "SI", "SK", "SM", "SU", "SV", "TH", "TJ",
            "TN", "TR", "TT", "UA", "UY", "UZ", "VN", "YU", "ZA", "ZM", "ZW"};
        
        for (int i = 0; i < countries.length; i++) {
            System.out.println("case \"" + countries[i] + "\":");
            System.out.println("    return Constants." + countries[i] + "_PATENT_START_DATE;");
        }
        
        String url = "http://www.baidu.com:80";
        String[] message = url.split("/");
        for (String str : message) {
            System.out.println(str);
        }
    }
    
}
