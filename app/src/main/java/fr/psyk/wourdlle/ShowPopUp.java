package fr.psyk.wourdlle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
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

public class ShowPopUp extends Activity {
    PopupWindow popUp;
    boolean click = true;
    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntriesArrayList;
String categorie;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        popUp = new PopupWindow(this);
        LinearLayout layout = new LinearLayout(this);
        LinearLayout mainLayout = new LinearLayout(this);
        Button but = new Button(this);
        TextView tv = new TextView(this);
        categorie = "lettres4";
        but.setText("Click Me");
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    popUp.showAtLocation(layout, Gravity.CENTER, 10, 10);
                    popUp.update(50, 50, 350, 350);

            }
        });
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUp.dismiss();
            }
        });


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        layout.setOrientation(LinearLayout.VERTICAL);
        params2.setMargins(3,3,3,3);
        tv.setText(categorie);
        tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        params.gravity = Gravity.CENTER;
        layout.addView(tv, params);
        layout.addView(generateGraph(categorie),params2);
        //layout.addView(barChart, params2);
        popUp.setContentView(layout);

        mainLayout.addView(but, params);
        setContentView(mainLayout);
    }

    public BarChart generateGraph(String categorie){
        barChart = new BarChart(this);
        barEntriesArrayList = new ArrayList<>();
        Score score ;
        MyDatabaseHelper db = new MyDatabaseHelper(this);
        //categorie = "lettres5";
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
     return barChart;
    }
}