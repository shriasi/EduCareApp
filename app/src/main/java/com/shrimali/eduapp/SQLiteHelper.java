package com.shrimali.eduapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;
import androidx.navigation.PopUpToBuilder;

public class SQLiteHelper extends SQLiteOpenHelper {
    public SQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertMemoryMap(String memoname, String mentions , byte[] image){

        SQLiteDatabase database = getWritableDatabase();
        String sql = "insert into MemoryMaps values (NULL, ?, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, memoname);
        statement.bindString(2, mentions);
        statement.bindBlob(3,image);

        statement.executeInsert();
    }

    public Cursor getMemoryMaps(String sql){

        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,  null);



    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
