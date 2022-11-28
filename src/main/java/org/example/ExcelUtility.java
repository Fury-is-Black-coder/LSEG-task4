package org.example;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtility {
    public static Map<String,Integer> getMapData(String file) throws FileNotFoundException {

        Map <String,Integer> hurricane_map = new HashMap<String,Integer>();

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Workbook workbook = new HSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            int lastRowNumber = sheet.getLastRowNum();

            for (int i=0;i<=lastRowNumber;i++){
                Row row = sheet.getRow(i);
                Cell keyCell = row.getCell(0);
                String key = keyCell.getStringCellValue().trim();

                Cell nameCell = row.getCell(1);
                String name = nameCell.getStringCellValue().trim();


                if(key.startsWith("E")){
                    String year = key.substring(key.length()-4);
                    int year_int = Integer.parseInt(year);
                    if (year_int>2015){
                        if(name.endsWith("A")){
                            Cell notes = row.getCell(2);
                            int notes_int = Integer.parseInt(notes.getStringCellValue().trim());
                            int rowNumber = row.getRowNum();
                            int max_speed = 0;
                                for(int l=rowNumber+1;l<=rowNumber+notes_int;l++){
                                    Row row_wind = sheet.getRow(l);
                                    Cell wind = row_wind.getCell(6);
                                    int wind_speed = Integer.parseInt(wind.getStringCellValue().trim());

                                    if (wind_speed>max_speed){
                                        max_speed=wind_speed;
                                    }

                                }



                            System.out.println("Hurricane name: "+name+
                                    " Maximum sustained wind-speed from a year: "+max_speed+" knots");
                            hurricane_map.put(name,max_speed);


//                            System.out.println("Key: "+key+" Name: "+name +" Start E:"+
//                                    key.startsWith("E") + " Year: "+year_int+
//                                    " Notes: "+notes_int+" Row: "+rowNumber+ " Max Speed: "+max_speed);
                        }
                    }
                }
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
