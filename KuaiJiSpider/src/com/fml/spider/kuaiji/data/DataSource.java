/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fml.spider.kuaiji.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ky
 */
public class DataSource {

    String path = "E://lines.txt";

    public List<String> reader() throws Exception {

        List<String> lines = new ArrayList<>();

        File file = new File(path);

        if (file.exists()) {

            FileReader fr = new FileReader(file);
            BufferedReader buff = new BufferedReader(fr);

            String line = "";

            while (null != (line = buff.readLine())) {
                lines.add(line);
            }

        }

        return lines;

    }

    public void writer(String... lines) throws Exception {

        File f = new File(path);

        if (!f.exists()) {
            f.mkdirs();
            f.createNewFile();
        }

        FileWriter fw = new FileWriter(f, false);
        BufferedWriter buff = new BufferedWriter(fw);

        for (String line : lines) {

            buff.write(line, 0, line.length());
            buff.newLine();

        }

        buff.close();
        fw.close();

    }

    static void testRreader() throws Exception {

        DataSource ds = new DataSource();

        List<String> reader = ds.reader();

        for (String reader1 : reader) {
            System.out.println(reader1);
        }

    }

    static void testWriter(String... info) throws Exception {

        DataSource ds = new DataSource();

        ds.writer(info);

    }

    public static void main(String[] args) throws Exception {

        testRreader();
        String s[] = {"111", "222"};
        testWriter(s);
        System.out.println("hhhhhhhhhhhhhh");
        testRreader();

    }

}
