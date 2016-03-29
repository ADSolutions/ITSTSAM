package com.example.marcoparolin.csvreader;


import java.io.BufferedReader;
import java.util.List;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.List;
        import android.support.v7.app.ActionBarActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputStream inputStream = getResources().openRawResource(R.raw.dati);
        CSVFile csvFile = new CSVFile(inputStream);
        List<String[]> foodList = csvFile.read();
        MyListAdapter adapter=new MyListAdapter(this, R.layout.item_layout,R.id.name, foodList);
        ListView listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    private class CSVFile {
        InputStream inputStream;

        public CSVFile(InputStream inputStream){
            this.inputStream = inputStream;
        }

        public List<String[]> read(){
            //

            List<String[]> resultList = new ArrayList<String[]>();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                // skippo la prima liena
                reader.readLine();

                String line;
                while ((line = reader.readLine()) != null) {

                    String[] row = line.split(";");
                    resultList.add(row);
                }
            }
            catch (IOException e) {
                Log.e("Main",e.getMessage());
            }
            finally {
                try {
                    inputStream.close();
                }
                catch (IOException e) {
                    Log.e("Main",e.getMessage());
                }
            }
            return resultList;
        }
    }


}
