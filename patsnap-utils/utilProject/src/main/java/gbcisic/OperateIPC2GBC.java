package com.patsnap.data.steven.gbcisic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.alibaba.fastjson.JSON;
import com.patsnap.db.dynamodb.classification.Ipc2Gbc;

public class OperateIPC2GBC {
    
    public static void main(String[] args)
        throws Exception {
        String fileName = "F:/IPC-GBT-new2.xlsx";
        //        String fileName = "F:/IPC.xlsx";
        File file = new File(fileName);
        //输出
        File f = new File("F:/IPC2GBC.txt");
        FileWriter fileWriter = new FileWriter(f);
        
        boolean isE2007 = false; //判断是否是excel2007格式  
        if (fileName.endsWith("xlsx"))
            isE2007 = true;
        InputStream input = new FileInputStream(file); //建立输入流  
        Workbook wb = null;
        //根据文件格式(2003或者2007)来初始化  
        if (isE2007)
            wb = new XSSFWorkbook(input);
        else
            wb = new HSSFWorkbook(input);
        //操作sheet
        Sheet sheet = wb.getSheetAt(0);
        
        int sumOfRows = sheet.getLastRowNum();
        System.out.println(sumOfRows);
        
        //定义每列的数据
        String col01 = "";
        String col02 = "";
        String col03 = "";
        String col04 = "";
        String col05 = "";
        String temp_col01 = "";
        String temp_col02 = "";
        String temp_col03 = "";
        String temp_col04 = "";
        String temp_col05 = "";
        boolean flag = true;
        Ipc2Gbc patentClassIPC2GBC = null;
        Set<String> set = new HashSet<String>();
        for (int i = 2; i <= sumOfRows; i++) {
            Row row = sheet.getRow(i);
            //处理每行数据
            Cell cell = row.getCell(0);
            if (cell != null && cell.getStringCellValue().trim() != "") {
                if (flag) {
                    col01 = cell.getStringCellValue().trim();
                    flag = false;
                }
                else {
                    Iterator<String> it = set.iterator();
                    while (it.hasNext()) {
                        patentClassIPC2GBC = new Ipc2Gbc();
                        patentClassIPC2GBC.setIpc(col01);
                        patentClassIPC2GBC.setGbc(it.next());
                        patentClassIPC2GBC.setUpdate_ts(System.currentTimeMillis());
                        //fileWriter.write(patentClassIPC2GBC + "\n");
                    }
                    
                    col01 = cell.getStringCellValue().trim();
                    
                    set = new HashSet<String>();
                    
                }
                
                //patentClassIPC2GBC = new PatentClassIPC2GBC();
                
            }
            else {
                cell = row.getCell(1);
                if (cell != null) {
                    col02 = cell.getStringCellValue().trim();
                    cell = row.getCell(3);
                    col04 = cell.getStringCellValue();
                    String[] split = col04.split(" ");
                    for (int m = 0; m < split.length; m++) {
                        patentClassIPC2GBC = new Ipc2Gbc();
                        patentClassIPC2GBC.setIpc(col02);
                        patentClassIPC2GBC.setGbc(split[m]);
                        patentClassIPC2GBC.setUpdate_ts(System.currentTimeMillis());
                        String jsonStr = JSON.toJSONString(patentClassIPC2GBC);
                        System.out.println(jsonStr);
                        fileWriter.write(jsonStr + "\n");
                        set.add(split[m]);
                    }
                }
            }
        }
        fileWriter.close();
        wb.close();
    }
    
}
