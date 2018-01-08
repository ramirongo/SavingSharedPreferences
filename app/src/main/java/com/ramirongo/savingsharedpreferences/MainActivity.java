package com.ramirongo.savingsharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences = null;

    Button saveBt;
    Button loadBt;
    EditText valueEt;
    TextView resultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        saveBt = (Button) findViewById(R.id.button_save);
        loadBt = (Button) findViewById(R.id.button_load);
        valueEt = (EditText) findViewById(R.id.editText);
        resultTv = (TextView) findViewById(R.id.textView);

        loadData();

        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        loadBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadData();
            }
        });
    }

    public void loadData(){
        sharedPreferences = getSharedPreferences("mySavedData", Context.MODE_PRIVATE);
        resultTv.setText(sharedPreferences.getString("myValue","data not found"));

    }

    public void saveData(){
        sharedPreferences = getSharedPreferences("mySavedData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("myValue",valueEt.getText().toString());
        editor.apply();  //editor.commit();
    }
}
