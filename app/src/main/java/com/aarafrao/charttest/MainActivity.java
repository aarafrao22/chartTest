package com.aarafrao.charttest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<BarEntry> arrayList;

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
        barChart.getXAxis().setSpaceMax(5f);
        XAxis xAxis = barChart.getXAxis();


        barChart.setDescription(null);    // Hide the description
        barChart.getAxisLeft().setDrawLabels(true);
        barChart.getAxisRight().setDrawLabels(true);
        barChart.getLegend().setEnabled(false);

        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setColor(Color.LTGRAY);
        barData.setBarWidth(0.7f);

        final ArrayList<String> xVals = new ArrayList<>();
        xVals.add("M");
        xVals.add("M");
        xVals.add("T");
        xVals.add("W");
        xVals.add("T");
        xVals.add("F");
        xVals.add("S");
        xVals.add("S");

        xAxis.setCenterAxisLabels(false);
        xAxis.setDrawGridLines(false);
        xAxis.setAxisMaximum(8);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xVals));

        Typeface tf = Typeface.createFromAsset(getAssets(), "impact.ttf");


        LimitLine ll1 = new LimitLine(15f, "Upper Limit");
        ll1.setLineWidth(0.4f);
        ll1.setLineColor(Color.RED);
        ll1.enableDashedLine(1.0f, 0.1f, 0f);
        ll1.setLabelPosition(LimitLine.LimitLabelPosition.LEFT_BOTTOM);
        ll1.setTextSize(10f);
        ll1.setTypeface(tf);


        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
        leftAxis.addLimitLine(ll1);


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

