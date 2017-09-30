package com.chenxi.patsnap.excel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.format.BorderLineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * 将数据存到Excel文件中
 *
 */
public class ExcelOperation {
    
    public static void main(String[] args)
        throws Exception {
        /*String path = "E:\\test.xlsx";
        String[] title = {"title01", "title02", "title03"};
        String sheet = "测试";
        List<String[]> list = new ArrayList<String[]>();
        String[] a = new String[] {"a1", "b1", "c1"};
        String[] b = new String[] {"a2", "b2", "c2"};
        String[] c = new String[] {"a3", "b3", "c3"};
        list.add(a);
        list.add(b);
        list.add(c);
        writeExcel(path, list, sheet, title);*/
        
        //预处理文件数据
        String[] titles = {"国家", "总数", "apdt_is_null", "apdt", "pbdt", "exdt", "erdt", "isdt", "prsd", "division",
            "ipcr", "cpc", "priority->date", "priority_nornalized->date", "patent_related_apdt", "patent_related_pbdt",
            "patent_related_isdt", "pct_apdt", "pct_pbdt", "pct_etdt", "apdt<isdt", "isdt<=pbdt", "pbdt<exdt",
            "apdt<erdt", "apdt<exdt", "exdt-apdt<=25", "exdt<=current_year+25", "pct.apdt<=apdt", "pct.pbd<=pbdt"};
        
        String path = "F:\\date-report02.xlsx";
        String sheet = "日期issue统计";
        List<String[]> list = new ArrayList<String[]>();
        //转换目标数据
        File file = new File("F:/temp/date_result01.txt");//date_result01.txt
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line = null;
        String[] temp;
        while ((line = br.readLine()) != null) {
            temp = line.split("  ");
            list.add(temp);
            temp = null;
        }
        br.close();
        writeExcel(path, list, sheet, titles);
        
    }
    
    public static void writeExcel(String path, List<String[]> list, String sheet, String[] title) {
        try {
            // 创建Excel工作薄
            WritableWorkbook wwb = null;
            // 新建立一个jxl文件
            OutputStream os = new FileOutputStream(path);
            wwb = Workbook.createWorkbook(os);
            // 添加第一个工作表并设置第一个Sheet的名字
            WritableSheet sheets = wwb.createSheet(sheet, 1);
            Label label;
            for (int i = 0; i < title.length; i++) {
                // Label(x,y,z) 代表单元格的第x+1列，第y+1行, 内容z
                // 在Label对象的子对象中指明单元格的位置和内容
                //          label = new Label(i, 0, title[i]);
                label = new Label(i, 0, title[i], getHeader());
                //设置列宽
                sheets.setColumnView(i, 8);
                //          sheets.setColumnView(4, 100);
                // 将定义好的单元格添加到工作表中
                sheets.addCell(label);
            }
            
            //设置单元格属性
            WritableCellFormat wc = new WritableCellFormat();
            
            for (int i = 0; i < list.size(); i++) {
                String[] arrData = list.get(i);
                for (int j = 0; j < arrData.length; j++) {
                    //向特定单元格写入数据
                    //sheets.setColumnView(j, 20);
                    label = new Label(j, 1 + i, arrData[j], wc);
                    sheets.addCell(label);
                }
            }
            // 写入数据
            wwb.write();
            System.out.println("finished...");
            // 关闭文件
            wwb.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
    
    public static WritableCellFormat getHeader() {
        // 定义字体
        WritableFont font = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD);
        try {
            // 黑色字体
            font.setColour(jxl.format.Colour.BLACK);
        }
        catch (WriteException e1) {
            e1.printStackTrace();
        }
        WritableCellFormat format = new WritableCellFormat(font);
        try {
            // 左右居中
            format.setAlignment(jxl.format.Alignment.CENTRE);
            // 上下居中
            format.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
            // 黑色边框
            format.setBorder(jxl.format.Border.ALL, BorderLineStyle.THIN, jxl.format.Colour.BLACK);
            // 黄色背景
            format.setBackground(jxl.format.Colour.YELLOW);
        }
        catch (WriteException e) {
            e.printStackTrace();
        }
        return format;
    }
    
}