package com.example.lab4_android;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "radio_statisticsDB";
    public static final String TABLE_STATISTICS = "radio_statistics";

    public static final String KEY_ID = "_id";
    public static final String KEY_SINGER = "_singer_name";
    public static final String KEY_TRACK_NAME = "_singer_name";
    public static final String KEY_DATE = "_date";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_STATISTICS + " (" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_SINGER + " TEXT," + KEY_TRACK_NAME + " TEXT,"+ KEY_DATE + " BIGINT " + ") ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
