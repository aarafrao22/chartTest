package com.aarafrao.charttest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<BarEntry> arrayList;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BarChart barChart = findViewById(R.id.chart);
        barChart.setDrawGridBackground(false);
        barChart.setDrawBarShadow(false);
        barChart.setGridBackgroundColor(Color.WHITE);
        barChart.setTouchEnabled(false);
        barChart.setPinchZoom(false);
        barChart.setDoubleTapToZoomEnabled(false);
        barChart.getAxisLeft().setEnabled(false);
        barChart.getAxisRight().setEnabled(false);

        getData();
        BarDataSet barDataSet = new BarDataSet(arrayList, "Test");
        barDataSet.setDrawValues(false);

        barChart.getAxisLeft().setDrawGridLines(false);
        barChart.getXAxis().setDrawGridLines(false);
//        barChart.getXAxis().setSpaceMax(5f);
        XAxis xAxis = barChart.getXAxis();


        barChart.setDescription(null);    // Hide the description
        barChart.getAxisLeft().setDrawLabels(false);
        barChart.getAxisRight().setDrawLabels(false);

        barChart.getLegend().setEnabled(false);

        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setColor(Color.LTGRAY);
        barData.setBarWidth(0.7f);

        final ArrayList<String> xVals = new ArrayList<>();
        xVals.add("MON");
        xVals.add("MON");
        xVals.add("TUE");
        xVals.add("WED");
        xVals.add("THU");
        xVals.add("FRI");
        xVals.add("SAT");
        xVals.add("SUN");

        xAxis.setCenterAxisLabels(false);
        xAxis.setDrawGridLines(false);
        xAxis.setAxisMaximum(8);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xVals));


    }

    private void getData() {
        arrayList = new ArrayList<BarEntry>();
        arrayList.add(new BarEntry(1, 400));
        arrayList.add(new BarEntry(2, 200));
        arrayList.add(new BarEntry(3, 900));
        arrayList.add(new BarEntry(4, 800));
        arrayList.add(new BarEntry(5, 100));
        arrayList.add(new BarEntry(6, 300));
        arrayList.add(new BarEntry(7, 200));

    }
}

