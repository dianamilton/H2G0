package com.example.dianamilton.h2go;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CSquad
 */

public class ChartActivity extends AppCompatActivity {

    private DataSetExample data = new DataSetExample();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        LineChart lineChart = (LineChart) findViewById(R.id.chart);

        List<Entry> entries = convertDataSetToEntry(data.getDataList());

        LineDataSet dataset = new LineDataSet(entries, "# of Calls");

        Log.d("APP", "Made dataset with : " + entries.size());

        LineData data = new LineData(dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS); //

        dataset.setDrawFilled(true);

        lineChart.setData(data);
        lineChart.animateY(5000);

        lineChart.getDescription().setText("Average Calls per Month");

    }

    private List<Entry> convertDataSetToEntry(List<Data> data) {
        List<Entry> entries = new ArrayList<>();

        for (Data d : data) {
            entries.add(new Entry(d.x, d.y));
        }

        return entries;
    }
}

