package com.example.nonel.bootcamp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PersonDB extends SQLiteOpenHelper {

    public static final String TABLE_PERSON = "person";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_RELIGION = "religion";
    public static final String COLUMN_CITIZENSHIP = "citizenship";
    public static final String COLUMN_BIRTHDAY = "birthday";
    public static final String COLUMN_SCHOOL = "school";
    public static final String COLUMN_FATHER = "father";
    public static final String COLUMN_MOTHER = "mother";
    public static final String COLUMN_COLOR = "color";
    public static final String COLUMN_FOOD_FAVORITE = "food_favorite";
    public static final String COLUMN_CRUSH_FIRST = "crush_first";
    public static final String COLUMN_CRUSH_SECOND = "crush_second";
    public static final String COLUMN_PET_NAME = "pet_name";
    public static final String COLUMN_BESTFRIEND = "bestfriend";
    public static final String COLUMN_KISS_FIRST = "kiss_first";
    public static final String COLUMN_KISS_SECOND = "kiss_second";
    public static final String COLUMN_MOTTO = "motto";
    public static final String COLUMN_DREAM = "dream";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_GENDER_SURE = "gender_sure";

    private static final String DATABASE_NAME = "person.db";
    private static final int DATABASE_VERSION = 1;

    //Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_PERSON + "(" +
            COLUMN_ID + " integer primary key autoincrement, " +
            COLUMN_NAME + " text, " +
            COLUMN_AGE + " text, " +
            COLUMN_RELIGION + " text, " +
            COLUMN_CITIZENSHIP + " text, " +
            COLUMN_BIRTHDAY + " text, " +
            COLUMN_SCHOOL + " text, " +
            COLUMN_FATHER + " text, " +
            COLUMN_MOTHER + " text, " +
            COLUMN_FOOD_FAVORITE + " text, " +
            COLUMN_COLOR + " text, " +
            COLUMN_CRUSH_FIRST + " text, " +
            COLUMN_CRUSH_SECOND + " text, " +
            COLUMN_PET_NAME + " text, " +
            COLUMN_BESTFRIEND + " text, " +
            COLUMN_KISS_FIRST + " text, " +
            COLUMN_KISS_SECOND + " text, " +
            COLUMN_MOTTO + " text, " +
            COLUMN_DREAM + " text, " +
            COLUMN_GENDER + " text, " +
            COLUMN_GENDER_SURE + " text " +
            ");";

    public PersonDB(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_PERSON);
        onCreate(db);
    }
}
