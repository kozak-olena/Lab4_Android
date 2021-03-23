package com.example.lab4_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnUpdate;
    DBHelper dbHelper;
    DatabaseHandler databaseHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUpdate = findViewById(R.id.btn_update);
        btnUpdate.setOnClickListener(this);

        dbHelper = new DBHelper(this);
        databaseHandler = new DatabaseHandler(dbHelper);
    }

    public void openStatisticsTable(View view) {
        Intent intent = new Intent(this, Activity_Statistics.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        openStatisticsTable(v);
    }
}