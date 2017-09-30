package com.patsnap.data.steven.gbcisic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.patsnap.autoframe.aws.AWSDynamoDBUtils;
import com.patsnap.data.main.Main;
import com.patsnap.db.dynamodb.classification.Gbc;
import com.patsnap.db.dynamodb.classification.Ipc2Gbc;
import com.patsnap.db.dynamodb.classification.Ipc2Isic;
import com.patsnap.db.dynamodb.classification.Isic;

public class ClassificationGBCAndISIC {
    public static final Logger logger = Logger.getLogger(ClassificationGBCAndISIC.class);
    
    public static void main(String[] args)
        throws Exception {
        AmazonDynamoDBClient client = Main.dbClient;
        String inputFileName = "";
        int flag = 0;
        if (args.length > 1) {
            inputFileName = args[0];
            flag = Integer.valueOf(args[1]);
        }
        else {
            logger.warn("input args length is illegal!");
            System.exit(0);
        }
        File file = new File(inputFileName);
        List<String> list = new ArrayList<String>();
        try {
            list = FileUtils.readLines(file);
        }
        catch (IOException e) {
            logger.error("read lines from file is error");
            e.printStackTrace();
        }
        File outputFile = new File("/mnt/steven_" + flag + ".txt");
        
        switch (flag) {
            case 1:
                insertDB_gbc(list, client, outputFile);
                break;
            case 2:
                insertDB_isic(list, client, outputFile);
                break;
            case 3:
                insertDB_ipc2gbc(list, client, outputFile);
                break;
            case 4:
                insertDB_ipc2isic(list, client, outputFile);
                break;
            case 0:
                logger.info("pattern is wrong");
        }
        
    }
    
    public static void insertDB_gbc(List<String> list, AmazonDynamoDBClient client, File outputFile)
        throws Exception {
        String temp = "";
        FileWriter fw = null;
        fw = new FileWriter(outputFile);
        for (int i = 0; i < list.size(); i++) {
            temp = list.get(i);
            try {
                Gbc gbc = JSON.parseObject(temp, Gbc.class);
                AWSDynamoDBUtils.save(client, gbc);
                logger.info("data :" + temp + "into db success");
            }
            catch (Exception e) {
                fw.write(temp + "\n");
                logger.warn("insert error message" + e.getMessage());
            }
        }
        fw.close();
    }
    
    public static void insertDB_isic(List<String> list, AmazonDynamoDBClient client, File outputFile)
        throws Exception {
        String temp = "";
        FileWriter fw = null;
        fw = new FileWriter(outputFile);
        for (int i = 0; i < list.size(); i++) {
            temp = list.get(i);
            try {
                Isic isic = JSON.parseObject(temp, Isic.class);
                AWSDynamoDBUtils.save(client, isic);
                logger.info("data :" + temp + "into db success");
            }
            catch (Exception e) {
                fw.write(temp + "\n");
                logger.warn("insert error message" + e.getMessage());
            }
        }
        fw.close();
    }
    
    public static void insertDB_ipc2gbc(List<String> list, AmazonDynamoDBClient client, File outputFile)
        throws Exception {
        String temp = "";
        FileWriter fw = null;
        fw = new FileWriter(outputFile);
        for (int i = 0; i < list.size(); i++) {
            temp = list.get(i);
            try {
                Ipc2Gbc ipc2Gbc = JSON.parseObject(temp, Ipc2Gbc.class);
                AWSDynamoDBUtils.save(client, ipc2Gbc);
                logger.info("data :" + temp + "into db success");
            }
            catch (Exception e) {
                fw.write(temp + "\n");
                logger.warn("insert error message" + e.getMessage());
            }
        }
        fw.close();
    }
    
    public static void insertDB_ipc2isic(List<String> list, AmazonDynamoDBClient client, File outputFile)
        throws Exception {
        String temp = "";
        FileWriter fw = null;
        fw = new FileWriter(outputFile);
        for (int i = 0; i < list.size(); i++) {
            temp = list.get(i);
            try {
                Ipc2Isic ipc2Isic = JSON.parseObject(temp, Ipc2Isic.class);
                AWSDynamoDBUtils.save(client, ipc2Isic);
                logger.info("data :" + temp + "into db success");
            }
            catch (Exception e) {
                fw.write(temp + "\n");
                logger.warn("insert error message" + e.getMessage());
            }
        }
        fw.close();
    }
    
}
