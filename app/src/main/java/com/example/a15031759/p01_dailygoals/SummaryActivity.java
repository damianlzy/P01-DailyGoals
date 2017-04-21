package com.example.a15031759.p01_dailygoals;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        // Get the intent so as to get the "things" inside the intent
        Intent i = getIntent();
        // Get the String array named "info" we passed in
        String[] info = i.getStringArrayExtra("info");
        // Get the TextView object
        TextView tvSummary = (TextView) findViewById(R.id.textViewSummary);
        // Display the name and age on the TextView
        tvSummary.setText("Read up on materials before class : " + info[0]
                + "\n Arrive on time so as not to miss important part of the lesson : " + info[1]
                + "\n Attempt the problem myself : " + info[2]
                + "\n Reflection : " + info[3]);

        Button btnBack = (Button) findViewById(R.id.buttonBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SummaryActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
