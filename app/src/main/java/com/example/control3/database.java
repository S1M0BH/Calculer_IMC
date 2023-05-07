package com.example.control3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;


public class database extends SQLiteOpenHelper {
    public database(@Nullable Context context) {
        super(context, "database", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String r ="CREATE TABLE calculimc(id Integer primary key autoincrement ,imc TEXT, DATTE TEXT)";
        db.execSQL(r);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String r="drop table if exists calculimc";
        db.execSQL(r);
        onCreate(db);
    }
    public Boolean insertIMC(String imc,String DATTE)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("imc", imc);
        contentValues.put("DATTE", DATTE);

        long result = DB.insert("calculimc", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }


    public ArrayList<String> getdata(){

        SQLiteDatabase data = this.getReadableDatabase();
        ArrayList<String> imc = new ArrayList<String>();
        Cursor cur= data.query(" calculimc",null,null,null,null,null,null);
        cur.moveToFirst();
        while (!cur.isAfterLast()){

            imc.add("IMC  :  "+cur.getString(1)+"\n DATE:"+cur.getString(2));
            cur.moveToNext();
        }
        cur.close();
        data.close();
        return imc;
    }
}
