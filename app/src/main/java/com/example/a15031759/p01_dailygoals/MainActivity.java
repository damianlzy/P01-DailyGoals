package com.example.a15031759.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onResume(){
        super.onResume();

        RadioGroup rgRead = (RadioGroup) findViewById(R.id.radioGroupRead);
        RadioGroup rgArrive = (RadioGroup) findViewById(R.id.radioGroupArrive);
        RadioGroup rgAttempt = (RadioGroup) findViewById(R.id.radioGroupAttempt);

        EditText etReflection = (EditText)findViewById(R.id.editTextReflection);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

        int read = prefs.getInt("read",-1);
        int arrive = prefs.getInt("arrive",-1);
        int attempt = prefs.getInt("attempt",-1);
        String reflection = prefs.getString("reflect"," ");

        if(read != -1){
            rgRead.check(read);
        }

        if(arrive != -1){
            rgArrive.check(arrive);
        }

        if(attempt != -1){
            rgAttempt.check(attempt);
        }

        etReflection.setText(reflection);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOk = (Button)findViewById(R.id.buttonOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioGroup rgRead = (RadioGroup) findViewById(R.id.radioGroupRead);
                RadioButton rbRead = (RadioButton) findViewById(rgRead.getCheckedRadioButtonId());

                RadioGroup rgArrive = (RadioGroup) findViewById(R.id.radioGroupArrive);
                RadioButton rbArrive = (RadioButton) findViewById(rgArrive.getCheckedRadioButtonId());

                RadioGroup rgAttempt = (RadioGroup) findViewById(R.id.radioGroupAttempt);
                RadioButton rbAttempt = (RadioButton) findViewById(rgAttempt.getCheckedRadioButtonId());



                EditText etReflection = (EditText)findViewById(R.id.editTextReflection);

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

                SharedPreferences.Editor prefEdit = prefs.edit();

                prefEdit.putInt("read",rgRead.getCheckedRadioButtonId());
                prefEdit.putInt("arrive",rgArrive.getCheckedRadioButtonId());
                prefEdit.putInt("attempt", rgAttempt.getCheckedRadioButtonId());
                prefEdit.putString("reflect",etReflection.getText().toString());

                prefEdit.commit();

                String[] info = {rbRead.getText().toString(),rbArrive.getText().toString(),
                        rbAttempt.getText().toString(),
                        etReflection.getText().toString()};

                Intent intent = new Intent(MainActivity.this,SummaryActivity.class);

                intent.putExtra("info",info);

                startActivity(intent);


            }
        });
    }
}
