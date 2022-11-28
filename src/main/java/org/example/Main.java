package org.example;

import java.io.File;
import java.io.IOException;
import com.aspose.cells.Workbook;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Task 4");
        //Downloading
        String link = "https://www.nhc.noaa.gov/data/hurdat/hurdat2-nepac-1949-2016-041317.txt";
        String file_name =link.substring(link.lastIndexOf("/")+1);
        File out = new File(file_name);
        new Thread(new Download(link, out)).start();

//        ExcelUtility.getMapData("hurdat2-nepac-1949-2016-041317.xls");





    }
}