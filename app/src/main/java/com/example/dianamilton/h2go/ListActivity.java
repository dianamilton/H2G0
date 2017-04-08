package com.example.dianamilton.h2go;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.example.dianamilton.h2go.MainActivity.reportList;

public class ListActivity extends AppCompatActivity {
    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.reportListView);

        ArrayAdapter<Report> adapter = new ArrayAdapter<Report>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, reportList.getReport());


        // Assign adapter to ListView
        listView.setAdapter(adapter);

    }

}