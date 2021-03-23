package com.example.lab4_android;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Activity_Statistics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__statistics);


        TableLayout tableLayout = findViewById(R.id.tableLayout);

        DBHelper dbHelper = new DBHelper(this);
        DatabaseHandler _databaseHandler = new DatabaseHandler(dbHelper);
        Cursor cursor = _databaseHandler.readData();

        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            int singerIndex = cursor.getColumnIndex(DBHelper.KEY_SINGER);
            int trackIndex = cursor.getColumnIndex(DBHelper.KEY_TRACK_NAME);
            int timeIndex = cursor.getColumnIndex(DBHelper.KEY_DATE);
            do {

                String singer = cursor.getString(singerIndex);
                String track = cursor.getString(trackIndex);
                int id = cursor.getInt(idIndex);
                long uctMillis = cursor.getLong(timeIndex);
                String localTime = DateTimeHandler.utcToLocalTime(uctMillis);

                TableRow tableRow = new TableRow(this);

                TextView textViewId = new TextView(this);
                textViewId.setText(String.valueOf(id));

                TextView textViewSinger = new TextView(this);
                textViewSinger.setText(singer);

                TextView textViewTrack = new TextView(this);
                textViewTrack.setText(track);

                TextView textViewDate = new TextView(this);
                textViewDate.setText(localTime);

                tableRow.addView(textViewId);
                tableRow.addView(textViewSinger);
                tableRow.addView(textViewTrack);
                tableRow.addView(textViewDate);

                tableLayout.addView(tableRow);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
    }
}
