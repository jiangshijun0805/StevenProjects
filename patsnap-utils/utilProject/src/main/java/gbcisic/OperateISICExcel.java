package com.patsnap.data.steven.gbcisic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.alibaba.fastjson.JSON;
import com.patsnap.db.dynamodb.classification.Isic;

public class OperateISICExcel {
    private static FormulaEvaluator evaluator = null;
    
    public static void main(String[] args)
        throws Exception {
        readXml("F:/IPC.xlsx");
        System.out.println("-------------");
    }
    
    public static String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        }
        //把数字当成String来读，避免出现1读成1.0的情况  
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        //判断数据的类型  
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC: //数字  
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING: //字符串  
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: //Boolean  
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: //公式  
                cellValue = String.valueOf(evaluator.evaluate(cell));
                break;
            case Cell.CELL_TYPE_BLANK: //空值   
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: //故障  
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }
    
    public static void readXml(String fileName)
        throws Exception {
        
        File f = new File("F:/ISIC.txt");
        FileWriter fileWriter = new FileWriter(f);
        
        boolean isE2007 = false; //判断是否是excel2007格式  
        if (fileName.endsWith("xlsx"))
            isE2007 = true;
        try {
            InputStream input = new FileInputStream(fileName); //建立输入流  
            Workbook wb = null;
            //根据文件格式(2003或者2007)来初始化  
            if (isE2007)
                wb = new XSSFWorkbook(input);
            else
                wb = new HSSFWorkbook(input);
            
            evaluator = wb.getCreationHelper().createFormulaEvaluator();
            
            Sheet sheet = wb.getSheetAt(2); //获得第2个表单  
            
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
            String add_col = "";
            
            Set<String> set = null;
            
            Isic model = null;
            //获取行数
            int rownumber = sheet.getLastRowNum();
            for (int i = 1; i <= rownumber; i++) {
                Row row = sheet.getRow(i);
                
                temp_col01 = getCellValue(row.getCell(0));
                if (temp_col01 != "") {
                    col01 = temp_col01;
                    temp_col05 = row.getCell(4).getStringCellValue().trim();
                    set = new HashSet<String>();
                    //list.add(col01);
                    
                    model = new Isic();
                    model.setIsic(col01);
                    model.setDescription_cn(temp_col05);
                    model.setUpdate_ts(System.currentTimeMillis());
                    //model.setParent_cn(list);
                    String jsonStr = JSON.toJSONString(model);
                    System.out.println(jsonStr);
                    fileWriter.write(jsonStr + "\n");
                }
                else {
                    temp_col03 = getCellValue(row.getCell(2));
                    temp_col02 = getCellValue(row.getCell(1));
                    
                    if (temp_col02 != "") {
                        col02 = temp_col02;
                    }
                    
                    if (temp_col02 != "" && temp_col03 == "") {
                        col02 = temp_col02;
                        temp_col05 = row.getCell(4).getStringCellValue().trim();
                        
                        set = new HashSet<String>();
                        set.add(col01);
                        //list.add(col02);
                        
                        model = new Isic();
                        model.setIsic(col01 + col02);
                        model.setDescription_cn(temp_col05);
                        model.setParent_cn(set);
                        model.setUpdate_ts(System.currentTimeMillis());
                        String jsonStr = JSON.toJSONString(model);
                        System.out.println(jsonStr);
                        fileWriter.write(jsonStr + "\n");
                    }
                    else {
                        temp_col04 = getCellValue(row.getCell(3));
                        temp_col03 = getCellValue(row.getCell(2));
                        
                        if (temp_col03 != "") {
                            col03 = temp_col03;
                        }
                        
                        if (temp_col03 != "" && temp_col04 == "") {
                            col03 = temp_col03;
                            temp_col05 = row.getCell(4).getStringCellValue().trim();
                            
                            set = new HashSet<String>();
                            set.add(col01);
                            set.add(col01 + col02);
                            //list.add(col03);
                            
                            model = new Isic();
                            model.setIsic(col01 + col03);
                            model.setDescription_cn(temp_col05);
                            model.setParent_cn(set);
                            model.setUpdate_ts(System.currentTimeMillis());
                            String jsonStr = JSON.toJSONString(model);
                            System.out.println(jsonStr);
                            fileWriter.write(jsonStr + "\n");
                        }
                        else {
                            
                            temp_col04 = getCellValue(row.getCell(3));
                            if (temp_col04 != "") {
                                col04 = temp_col04;
                                if (col04.length() == 3) {
                                    col04 = "0" + col04;
                                }
                                temp_col05 = row.getCell(4).getStringCellValue().trim();
                                
                                add_col = getCellValue(row.getCell(2));
                                if (add_col != "") {
                                    set = new HashSet<String>();
                                    set.add(col01);
                                    set.add(col01 + col02);
                                    
                                    model = new Isic();
                                    model.setIsic(col01 + col04.substring(0, col04.length() - 1));
                                    model.setDescription_cn(temp_col05);
                                    model.setParent_cn(set);
                                    model.setUpdate_ts(System.currentTimeMillis());
                                    String jsonStr = JSON.toJSONString(model);
                                    System.out.println(jsonStr);
                                    fileWriter.write(jsonStr + "\n");
                                }
                                
                                set = new HashSet<String>();
                                set.add(col01);
                                set.add(col01 + col02);
                                set.add(col01 + col04.substring(0, col04.length() - 1));
                                
                                model = new Isic();
                                model.setIsic(col01 + col04);
                                model.setDescription_cn(temp_col05);
                                model.setParent_cn(set);
                                model.setUpdate_ts(System.currentTimeMillis());
                                String jsonStr = JSON.toJSONString(model);
                                System.out.println(jsonStr);
                                fileWriter.write(jsonStr + "\n");
                            }
                        }
                    }
                    
                }
                //System.out.println(row.getCell(0));
            }
            
            wb.close();
            fileWriter.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}