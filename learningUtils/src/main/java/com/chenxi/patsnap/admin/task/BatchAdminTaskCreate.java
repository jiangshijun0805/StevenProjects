package com.chenxi.patsnap.admin.task;

public class BatchAdminTaskCreate {
    public static void main(String[] args)
        throws Exception {
        /*
        //1996
        String[][] data = {{"19960101", "19960430", "1996.00"}, {"19960501", "19960831", "1996.01"},
        {"19960901", "19961231", "1996.03"}};
        
        //1997,1998
        String[][] data = {{"19970101", "19970430", "1997.00"}, {"19970501", "19970831", "1997.01"},
        {"19970901", "19971231", "1997.03"}, {"19980101", "19980430", "1998.00"},
        {"19980501", "19980831", "1998.01"}, {"19980901", "19981231", "1998.03"}};
        //1999,2000
        String[][] data = {{"19990101", "19990430", "1999.00"}, {"19990501", "19990831", "1999.01"},
        {"19990901", "19991231", "1999.03"}, {"20000101", "20000430", "2000.00"},
        {"20000501", "20000831", "2000.01"}, {"20000901", "20001231", "2000.03"}};
        File file = new File("F://data/admintask.txt");
        String task = FileUtils.readLines(file).get(0);
        for (int i = 0; i < data.length; i++) {
        String start_date = task.substring(98, 106);
        String step01 = task.replaceFirst(start_date, data[i][0]);
        
        String end_date = step01.substring(120, 128);
        String step02 = step01.replaceFirst(end_date, data[i][1]);
        
        String task_description = step02.substring(848, 855);
        String step03 = step02.replaceFirst(task_description, data[i][2]);
        
        System.out.println(step03);
        }
        
        */}
}
