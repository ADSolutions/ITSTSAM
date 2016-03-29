package com.example.marcoparolin.csvreader;

/**
 * Created by Marco Parolin on 24/03/2016.
 */

import android.location.Address;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVFile {
    InputStream inputStream;

    public CSVFile(InputStream inputStream){
        this.inputStream = inputStream;
    }

    public List<String[]> read(){

        //String[] row = new String[18];

        int i = 0;

        Address address ;

        StringBuilder builder = new StringBuilder();


        List<String[]> resultList = new ArrayList<String[]>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {
                String[] row = new String[18];
                row = csvLine.split(";");


                //Address address = new Address();

                /*if(row[2].length() > 0 && row[3].length() > 0 && row[4].length() > 0){
                    address = new Address ( row[2], row[3], row[4], row[5]);
                    ++i;
                }*/
                resultList.add(row);
            }
        }
        catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: "+ex);
        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException e) {
                throw new RuntimeException("Error while closing input stream: "+e);
            }
        }
        return resultList;
    }


}
