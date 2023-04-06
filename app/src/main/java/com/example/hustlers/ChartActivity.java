package com.example.hustlers;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        BarChart chart = findViewById(R.id.chart);
        List<BarEntry> entries = new ArrayList<>();
        //TODO: Iterate over list
        entries.add(new BarEntry(0f, 10f));
        entries.add(new BarEntry(1f, 20f));
        entries.add(new BarEntry(2f, 15f));
        entries.add(new BarEntry(3f, 5f));
        BarDataSet dataSet = new BarDataSet(entries, "Bar Chart");
        BarData data = new BarData(dataSet);
        chart.setData(data);

        chart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(new String[]{"A", "B", "C", "D"}));
        dataSet.setColor(Color.BLUE);
        chart.getLegend().setEnabled(false);
        chart.invalidate();

    }
}