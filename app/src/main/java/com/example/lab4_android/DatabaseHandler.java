package com.example.lab4_android;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.widget.EditText;

import androidx.annotation.RequiresApi;

import java.util.Date;

public class DatabaseHandler {

    private SQLiteDatabase sqLiteDatabase;
    private DBHelper _dbHelper;


    public DatabaseHandler(DBHelper dbHelper) {
        _dbHelper = dbHelper;
        sqLiteDatabase = _dbHelper.getWritableDatabase();
    }

    public Cursor getSortedData() {
        Cursor cursor = sqLiteDatabase.query(DBHelper.TABLE_STATISTICS, null, null, null,
                null, null, DBHelper.KEY_DATE + " ASC ");
        return cursor;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void insertData(String singer, String track) {

        ContentValues contentValues = new ContentValues();
        Date _dateTime = new Date();
        long utcTime = DateTimeHandler.localTimeToUtc(_dateTime);

        contentValues.put(DBHelper.KEY_SINGER, singer);
        contentValues.put(DBHelper.KEY_TRACK_NAME, track);
        contentValues.put(DBHelper.KEY_DATE, utcTime);

        sqLiteDatabase.insert(DBHelper.TABLE_STATISTICS, null, contentValues);
    }

    public Cursor readData() {
        return getSortedData();
    }

    public void deleteDate() {
        sqLiteDatabase.delete(DBHelper.TABLE_STATISTICS, null, null);
    }
}

