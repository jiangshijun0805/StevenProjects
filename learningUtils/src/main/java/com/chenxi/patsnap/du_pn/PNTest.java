package com.chenxi.patsnap.du_pn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;

public class PNTest {
    
    public static void main(String[] args)
        throws Exception {
        File f = new File("F:\\du-pn\\pn.txt");
        InputStream input = new FileInputStream(f);
        List<String> pns = IOUtils.readLines(input, "UTF-8");
        Set<String> ccs = new HashSet<String>();
        String pn = null;
        String cc = null;
        FileWriter fileWriter = new FileWriter(new File("init.txt"));
        for (int i = 0; i < pns.size(); i++) {
            pn = pns.get(i);
            cc = pn.substring(0, 2);
            if (ccs.contains(cc)) {
                // nothing
                fileWriter.write(pn + "\n");
            }
            else {
                fileWriter.close();
                ccs.add(cc);
                fileWriter = new FileWriter(new File("F:\\du-pn\\result\\" + cc + ".txt"));
                fileWriter.write(pn + "\n");
            }
        }
        if (fileWriter != null) {
            fileWriter.close();
        }
    }
    
}
