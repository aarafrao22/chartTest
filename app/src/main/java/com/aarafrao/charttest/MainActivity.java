package com.aarafrao.charttest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<BarEntry> arrayList;
    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        barChart = findViewById(R.id.chart);
        barChart.setDrawGridBackground(false);
        barChart.setDrawBarShadow(false);
        barChart.setGridBackgroundColor(Color.WHITE);
        barChart.setTouchEnabled(true);
        barChart.setPinchZoom(true);
//        barChart.zoom
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

//        Typeface tf = Typeface.createFromAsset(getAssets(), "impact.ttf");


        LimitLine ll1 = new LimitLine(15f, "Upper Limit");
        ll1.setLineWidth(0.4f);
        ll1.setLineColor(Color.RED);
        ll1.enableDashedLine(1.0f, 0.1f, 0f);
        ll1.setLabelPosition(LimitLine.LimitLabelPosition.LEFT_BOTTOM);
        ll1.setTextSize(10f);
//        ll1.setTypeface(tf);


        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
        leftAxis.addLimitLine(ll1);

//        barChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
//            @Override
//            public void onValueSelected(Entry e, Highlight h) {
//                Highlight highlight[] = new Highlight[barChart.getData().getDataSets().size()];
//                for (int j = 0; j < barChart.getData().getDataSets().size(); j++) {
//
//                    IDataSet iDataSet = barChart.getData().getDataSets().get(j);
//
//                    for (int i = 0; i < iDataSet.getFormSize(); i++) {
//                            highlight[j] = new Highlight(e.getX(), e.getY(), j);
//                    }
//
//                }
//                barChart.highlightValues(highlight);
//            }
//
//            @Override
//            public void onNothingSelected() {
//
//            }
//        });

        IMarker marker = new MarkerView(this,R.layout.marker);
        barChart.setMarker(marker);


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

