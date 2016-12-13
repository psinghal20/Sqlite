package com.example.psing.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by psing on 13-12-2016.
 */

public class databasehelper extends SQLiteOpenHelper {
    public static final String databasename="student.db";
    public static final String tablename="studenttable";
    public static final String col1="ID";
    public static final String col2="NAME";
    public static final String col3="SURNAME";
    public static final String col4="MARKS";
    public databasehelper(Context context) {
        super(context, databasename, null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table"+tablename+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+tablename);
        onCreate(db);
    }
    public boolean insertdata(String name,String surname,String marks){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,name);
        contentValues.put(col3,surname);
        contentValues.put(col4,marks);
        long result=db.insert(tablename,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
}
