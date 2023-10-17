package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String selected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Meaning to use switch statement but kept getting an error on the case so I used If statement
    public void DanceSelected(View v) {
        if (v.getId() == R.id.button) {
            Toast.makeText(this, "Hip Hop selected", Toast.LENGTH_SHORT).show();
            selected = "Hip";
        } else if (v.getId() == R.id.button2) {
            Toast.makeText(this, "Samba selected", Toast.LENGTH_SHORT).show();
            selected = "Samba";
        } else if (v.getId() == R.id.button3) {
            Toast.makeText(this, "Rock 'n' Roll selected", Toast.LENGTH_SHORT).show();
            selected = "Rock";
        }
        //starts the pie chart once a button has been clicked.
        Intent intent = new Intent(getApplicationContext(), Result_Pie_Chart.class);
        intent.putExtra("selected", selected);
        startActivity(intent);
    }

}
