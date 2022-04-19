package fr.psyk.wourdlle;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Pop extends Activity {

    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntriesArrayList;
    String categorie,categorieBelle;
    TextView textView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindows);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        Intent intent = getIntent();

        if (intent != null){
            categorie = intent.getStringExtra("Categorie");
        }
        System.out.println("Graph pour la categorie: " + categorie);
        generateGraph();
        getWindow().setLayout((int)(width*.8),(int)(height*.6));
        textView = findViewById(R.id.textView_pop);
        if (categorie.startsWith("H")){
            categorieBelle = categorie.substring(10) + " " + categorie.substring(3,10) + " HardMode";
        }else {
            categorieBelle = categorie.substring(7) + " " + categorie.substring(0,7);
        }

        textView.setText("Nombre de coups pour "+categorieBelle);



    }

    public void generateGraph(){
        barChart = findViewById(R.id.chart1);
        barEntriesArrayList = new ArrayList<>();
        Score score ;
        MyDatabaseHelper db = new MyDatabaseHelper(this);
       // String categorie = "lettres5";
        score = db.getScore("'"+categorie+"'");

        barEntriesArrayList.add(new BarEntry(1f, score.coup1));
        barEntriesArrayList.add(new BarEntry(2f, score.coup2));
        barEntriesArrayList.add(new BarEntry(3f, score.coup3));
        barEntriesArrayList.add(new BarEntry(4f, score.coup4));
        barEntriesArrayList.add(new BarEntry(5f, score.coup5));
        barEntriesArrayList.add(new BarEntry(6f, score.coup6));
        barEntriesArrayList.add(new BarEntry(7f, score.coup7));

        barDataSet = new BarDataSet(barEntriesArrayList,"");
        barData = new BarData(barDataSet);
        barChart.setTouchEnabled(false);
        barChart.setData(barData);
        barChart.setDrawGridBackground(false);
        barChart.setDrawValueAboveBar(true);
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barData.setValueFormatter(new DefaultValueFormatter(0));
        barDataSet.setValueTextColor(Color.WHITE);
        barDataSet.setValueTextSize(16f);
        barChart.getDescription().setEnabled(false);
        barChart.getLegend().setEnabled(false);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
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
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        finish();
        return super.dispatchTouchEvent(ev);
    }
}
