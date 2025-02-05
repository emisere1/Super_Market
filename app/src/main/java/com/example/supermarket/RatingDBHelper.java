package com.example.supermarket;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RatingDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ratings.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE_RATING = "create table rating (_id integer primary key autoincrement, "
            + "marketaddress text not null, market text,"
            + "liquor text, produce text, meat text, cheese text, checkout text);";

    public RatingDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_RATING);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS rating");
        onCreate(db);
    }
}
