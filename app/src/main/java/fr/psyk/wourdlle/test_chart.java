package fr.psyk.wourdlle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.StackedValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class test_chart extends Activity {


    // variable for our bar chart
    BarChart barChart;

    // variable for our bar data.
    BarData barData;

    // variable for our bar data set.
    BarDataSet barDataSet;

    // array list for storing entries.
    ArrayList barEntriesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_chart);

        // initializing variable for bar chart.
        barChart = findViewById(R.id.chart1);

        // calling method to get bar entries.
        barEntriesArrayList = new ArrayList<>();

        // adding new entry to our array list with bar
        // entry and passing x and y axis value to it.

        Score score ;

        MyDatabaseHelper db = new MyDatabaseHelper(this);

        score = db.getScore("'lettres4'");

        barEntriesArrayList.add(new BarEntry(1f, score.coup1));
        barEntriesArrayList.add(new BarEntry(2f, score.coup2));
        barEntriesArrayList.add(new BarEntry(3f, score.coup3));
        barEntriesArrayList.add(new BarEntry(4f, score.coup4));
        barEntriesArrayList.add(new BarEntry(5f, score.coup5));
        barEntriesArrayList.add(new BarEntry(6f, score.coup6));
        barEntriesArrayList.add(new BarEntry(7f, score.coup7));

        // creating a new bar data set.
        barDataSet = new BarDataSet(barEntriesArrayList,"");

        // creating a new bar data and
        // passing our bar data set.
        barData = new BarData(barDataSet);
        barChart.setTouchEnabled(false);
        barChart.setScaleEnabled(false);
        // below line is to set data
        // to our bar chart.
        barChart.setData(barData);
        barChart.setDrawGridBackground(false);

        barChart.setDrawValueAboveBar(true);
        // adding color to our bar data set.
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barData.setValueFormatter(new DefaultValueFormatter(0));
        // setting text color.
        barDataSet.setValueTextColor(Color.WHITE);

        // setting text size
        barDataSet.setValueTextSize(16f);
        barChart.getDescription().setEnabled(false);

       barChart.getLegend().setEnabled(false);


        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(16f);
        xAxis.setTextColor(Color.RED);
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawGridLines(false);

        // data has AxisDependency.LEFT
        YAxis left = barChart.getAxisLeft();
        left.setDrawLabels(false); // no axis labels
        left.setDrawAxisLine(false); // no axis line
        left.setDrawGridLines(false); // no grid lines
        left.setDrawZeroLine(false); // draw a zero line
        barChart.getAxisRight().setEnabled(false); // no right axis
    }





}
