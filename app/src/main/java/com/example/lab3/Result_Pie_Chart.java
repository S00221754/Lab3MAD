package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Result_Pie_Chart extends AppCompatActivity {

    int s = 30, hh = 60, rnr = 30;
    Button finish;
    String result;
    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_pie_chart);
        //transferring whats been selected on the main activity
        Bundle selected = getIntent().getExtras();
        result = selected.getString("selected");
        pieChart = findViewById(R.id.pieChart_view);

        //checking what dance style was selected
        switch(result.toString()){
            case "Samba":
                    s++;
            break;
            case "Hip":
                hh++;
                break;
            case "Rock":
                rnr++;
                break;
        }
        //calls the method for the piechart
        showPieChart(s,hh,rnr);

        finish = findViewById(R.id.button5);
        finish.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent Return = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(Return);
            }
        });

    }
    /*
    Method used to create the pie chart. Takes in parameters of the numbers each dance style has been selected
     */
    private void showPieChart(int s, int hh, int rnr){
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        String label = "type";

        //Map is a collection of key-value pairs. Helps store elements to be used to retrieve data.
        Map<String, Integer> Data = new HashMap<>();
        //initializing data
        Data.put("Hip Hop", hh);
        Data.put("Rock 'n' Roll", rnr);
        Data.put("Samba", s);

        //colors
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#304567"));
        colors.add(Color.parseColor("#309967"));
        colors.add(Color.parseColor("#476567"));

        //inputting data in the pie chart
        for (String type: Data.keySet()){
            pieEntries.add(new PieEntry(Data.get(type).floatValue(), type));
        }

        //collecting labels from the Map
        PieDataSet pieDataSet = new PieDataSet(pieEntries, label);

        //setting text size
        pieDataSet.setValueTextSize(12f);

        //providing color list for different entries
        pieDataSet.setColors(colors);

        //grouping the data set from entry to chart
        PieData pieData = new PieData(pieDataSet);

        //showing the value of the entries, default if not set
        pieData.setDrawValues(true);

        pieChart.setData(pieData);

        pieChart.invalidate();
    }


}
