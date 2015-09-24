package com.example.nonel.bootcamp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProductDB extends SQLiteOpenHelper {

    public static final String TABLE_PRODUCT = "product";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_PRICE = "price";

    private static final String DATABASE_NAME = "product.db";
    private static final int DATABASE_VERSION = 1;

    //Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_PRODUCT + "(" +
            COLUMN_ID + " integer primary key autoincrement " +
            COLUMN_NAME + " text, " +
            COLUMN_DESCRIPTION + " text, " +
            COLUMN_PRICE + " text, " +
            ");";

    public ProductDB(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_PRODUCT);
        onCreate(db);
    }
}
