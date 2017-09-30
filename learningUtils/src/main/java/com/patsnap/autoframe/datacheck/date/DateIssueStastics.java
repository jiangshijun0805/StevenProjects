package com.patsnap.autoframe.datacheck.date;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class DateIssueStastics {
    private static int total = 0;
    
    public static void main(String[] args)
        throws Exception {
        String rootDir = "E:\\data";
        processDir(rootDir);
    }
    
    public static void readDate2Excel() {
        
    }
    
    public static void processDir(String rootDir)
        throws Exception {
        File rootDirFile = new File(rootDir);
        FileWriter fileWriter = new FileWriter(new File("E:/date_result4.txt"));
        
        //遍历国家目录
        for (File file : rootDirFile.listFiles()) {
            //获取国家名称
            String country = file.getName();
            System.out.println(file.getName());
            String message = country;
            total = 0;
            //遍历每个国家下面的数据文件
            String lineStr = "";
            String apdtErrorStr = "";
            String formatErrorStr = "";
            String logicErrorStr = "";
            for (File f : file.listFiles()) {
                System.out.println(f.getName());
                //处理 apdtError文件
                if (f.getName().equals("apdtError.txt")) {
                    apdtErrorStr = processApdtError(f);
                }
                
                //处理formatError文件
                if (f.getName().equals("formatError.txt")) {
                    formatErrorStr = processFormatError(f);
                }
                //处理logicError文件
                if (f.getName().equals("logicError.txt")) {
                    logicErrorStr = processLogicError(f);
                }
            }
            lineStr = country + "  " + total + "  " + apdtErrorStr + "  " + formatErrorStr + "  " + logicErrorStr;
            fileWriter.write(lineStr + "\n");
            System.out.println("**********");
            System.out.println(lineStr);
        }
        fileWriter.close();
    }
    
    private static String processLogicError(File f)
        throws Exception {
        String message = null;
        int apdt_less_isdt = 0;
        int isdt_less_equal_pbdt = 0;
        int pbdt_less_exdt = 0;
        int apdt_less_erdt = 0;
        int apdt_less_exdt = 0;
        int exdt_apdt_less_equal_25 = 0;
        int exdt_less_equal_current_year_add_25 = 0;
        int pct_of_apdt_less_equal_apdt = 0;
        int pct_of_pbdt_less_equal_pbdt = 0;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        String line = null;
        while ((line = br.readLine()) != null) {
            total++;
            //apdt_less_isdt
            apdt_less_isdt = apdt_less_isdt + isContains(line, "apdt must less than isdt,apdt=");
            //isdt_less_equal_pbdt
            isdt_less_equal_pbdt = isdt_less_equal_pbdt + isContains(line, "isdt must less than or equal pbdt,isdt=");
            //pbdt_less_exdt
            pbdt_less_exdt = pbdt_less_exdt + isContains(line, "pbdt must less than exdt ,pbdt=");
            //apdt_less_erdt
            apdt_less_erdt = apdt_less_erdt + isContains(line, "apdt must less than erdt ,apdt= ");
            
            //apdt_less_exdt
            apdt_less_exdt = apdt_less_exdt + isContains(line, "apdt must less than exdt ,apdt= ");
            
            //exdt_apdt_less_equal_25
            exdt_apdt_less_equal_25 =
                exdt_apdt_less_equal_25 + isContains(line, "must satisfy: exdt - apdt ≤ 25 ,apdt= ");
            
            //exdt_less_equal_current_year_add_25
            exdt_less_equal_current_year_add_25 = exdt_less_equal_current_year_add_25
                + isContains(line, "must satisfy :exdt ≤ this current year + 25 ,exdt=");
            
            //pct_of_apdt_less_equal_apdt
            pct_of_apdt_less_equal_apdt =
                pct_of_apdt_less_equal_apdt + isContains(line, "pct.apdt must less than or equal apdt,pct.apdt= ");
            //pct_of_pbdt_less_equal_pbdt
            pct_of_pbdt_less_equal_pbdt =
                pct_of_pbdt_less_equal_pbdt + isContains(line, "pct.pbdt must less than or equal apdt,pct.pbdt=");
        }
        br.close();
        /*message =
            "apdt_less_isdt " + apdt_less_isdt + " isdt_less_equal_pbdt " + isdt_less_equal_pbdt + " pbdt_less_exdt "
                + pbdt_less_exdt + " apdt_less_erdt " + apdt_less_erdt + " apdt_less_exdt " + apdt_less_exdt
                + " exdt_apdt_less_equal_25 " + exdt_apdt_less_equal_25 + " exdt_less_equal_current_year_add_25 "
                + exdt_less_equal_current_year_add_25 + " pct_of_apdt_less_equal_apdt " + pct_of_apdt_less_equal_apdt
                + " pct_of_pbdt_less_equal_pbdt " + pct_of_pbdt_less_equal_pbdt;*/
        message = apdt_less_isdt + "  " + isdt_less_equal_pbdt + "  " + pbdt_less_exdt + "  " + apdt_less_erdt + "  "
            + apdt_less_exdt + "  " + exdt_apdt_less_equal_25 + "  " + exdt_less_equal_current_year_add_25 + "  "
            + pct_of_apdt_less_equal_apdt + "  " + pct_of_pbdt_less_equal_pbdt;
        return message;
    }
    
    private static String processFormatError(File f)
        throws IOException {
        String message = null;
        int apdt = 0;
        int pbdt = 0;
        int exdt = 0;
        int erdt = 0;
        int isdt = 0;
        int prsd = 0;
        int division = 0;
        int ipcr = 0;
        int cpc = 0;
        int priority = 0;
        int priority_nornalized = 0;
        int patent_related_apdt = 0;
        int patent_related_pbdt = 0;
        int patent_related_isdt = 0;
        int pct_apdt = 0;
        int pct_pbdt = 0;
        int pct_etdt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        String line = null;
        while ((line = br.readLine()) != null) {
            total++;
            //apdt
            apdt = apdt + isContains(line, "apdt date format is illegal!");
            //pbdt
            pbdt = pbdt + isContains(line, "pbdt date format is illegal!");
            //exdt
            exdt = exdt + isContains(line, "exdt date format is illegal!");
            
            //erdt
            erdt = erdt + isContains(line, "erdt date format is illegal!");
            //isdt
            isdt = isdt + isContains(line, "isdt date format is illegal!");
            //prsd
            prsd = prsd + isContains(line, "prsd date format is illegal!");
            //division
            division = division + isContains(line, "dividion-parent-apdt date format is illegal!");
            //ipcr
            ipcr = ipcr + isContains(line, "ipcr date format is illegal!");
            //cpc
            cpc = cpc + isContains(line, "cpc date format is illegal!");
            //priority
            priority = priority + isContains(line, "priority date format is illegal!");
            //priority_nornalized
            priority_nornalized =
                priority_nornalized + isContains(line, "priority_normalized_date date format is illegal!");
            //patent_related_apdt
            patent_related_apdt = patent_related_apdt + isContains(line, "patent_related apdt date format is illegal!");
            //patent_related_pbdt
            patent_related_pbdt = patent_related_pbdt + isContains(line, "patent_related pbdt date format is illegal!");
            //patent_related_isdt
            patent_related_isdt = patent_related_isdt + isContains(line, "patent_related isdt date format is illegal!");
            //pct_apdt
            pct_apdt = pct_apdt + isContains(line, "pct apdt date format is illegal!");
            //pct_pbdt
            pct_pbdt = pct_pbdt + isContains(line, "pct pbdt date format is illegal!");
            //pct_etdt
            pct_etdt = pct_etdt + isContains(line, "patent_related isdt date format is illegal!");
        }
        
        br.close();
        /*message = "apdt " + apdt + " pbdt " + pbdt + " exdt " + exdt + " erdt " + erdt + " isdt " + isdt + " prsd "
            + prsd + " division " + division + " ipcr " + ipcr + " cpc " + cpc + " priority->date " + priority
            + " priority_nornalized->date " + priority_nornalized + " patent_related_apdt " + patent_related_apdt
            + " patent_related_pbdt " + patent_related_pbdt + " patent_related_isdt " + patent_related_isdt
            + " pct_apdt " + pct_apdt + " pct_pbdt " + pct_pbdt + " pct_etdt " + pct_etdt;*/
        
        message = apdt + "  " + pbdt + "  " + exdt + "  " + erdt + "  " + isdt + "  " + prsd + "  " + division + "  "
            + ipcr + "  " + cpc + "  " + priority + "  " + priority_nornalized + "  " + patent_related_apdt + "  "
            + patent_related_pbdt + "  " + patent_related_isdt + "  " + pct_apdt + "  " + pct_pbdt + "  " + pct_etdt;
        return message;
    }
    
    public static int isContains(String str1, String str2) {
        if (str1.contains(str2)) {
            return 1;
        }
        else {
            return 0;
        }
    }
    
    private static String processApdtError(File f)
        throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        String line = null;
        int apdt_is_null = 0;
        while ((line = br.readLine()) != null) {
            total++;
            if (line != null && line.trim() != null)
                apdt_is_null++;
        }
        br.close();
        return "" + apdt_is_null;
        //        return "apdt_is_null " + apdt_is_null;
    }
    
}
