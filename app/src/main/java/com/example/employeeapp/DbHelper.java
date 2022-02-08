package com.example.employeeapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    static String Dbname="EmployeeApp.db";
    static String TableName="employee";
    static String col1="id";
    static String col2="empcode";
    static String col3="name";
    static String col4="designation";
    static String col5="mobile";
    public DbHelper( Context context ) {
        super(context, Dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      String query="create table "+TableName+"("+col1+
              " integer primary key autoincrement,"+col2+
              " text,"+col3+" text,"+col4+" text,"+col5+" text)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query="drop table if exists "+TableName;
        db.execSQL(query);
        onCreate(db);

    }
    public boolean insertEmployee(String empcode,String name,String designation,String mobile){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues content=new ContentValues();
        content.put(col2,empcode);
        content.put(col3,name);
        content.put(col4,designation);
        content.put(col5,mobile);
        long status=db.insert(TableName,null,content);
        if (status==-1)
        {
            return false;
        }
        else{
            return true;
        }
    }


}
