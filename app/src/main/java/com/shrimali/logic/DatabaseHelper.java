package com.shrimali.logic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.service.autofill.DateValueSanitizer;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.database.sqlite.SQLiteDatabaseKt;

public class DatabaseHelper  extends SQLiteOpenHelper {


    public DatabaseHelper(Context context) {
        super(context, "Userdata.db", null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(nametxt TEXT primary key ,  schooltxt TEXT , gradetxt TEXT, phonetxt TEXT, addresstxt TEXT , subjectstxt TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails");
    }

    public boolean insertuserdata(String nametxt, String schooltxt , String gradetxt , String phonetxt ,String addresstxt,  String [] subjectstxt){

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nametxt" , nametxt);
        contentValues.put("schooltxt" , schooltxt);
        contentValues.put("gradetxt" , gradetxt);
        contentValues.put("phonetxt" , phonetxt);
        contentValues.put("addresstxt" , addresstxt);
        contentValues.put("subjectstxt" , String.valueOf(subjectstxt));
        long result = DB.insert("Userdetails" , null, contentValues);
        if(result == -1){
            return  false;
        }
        else {

            return  true;
        }
    }

    public Cursor getData(){

        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from Userdetails", null);
        return cursor;
    }

}