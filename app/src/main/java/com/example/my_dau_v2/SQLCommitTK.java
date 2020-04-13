package com.example.my_dau_v2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class SQLCommitTK extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "schoolsManager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "TaiKhoan";

    private static final String KEY_ID = "id";
    private static final String KEY_MASV = "masv";
    private static final String KEY_USER = "user";
    private static final String KEY_PASS = "password";


    public SQLCommitTK(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
//        String create_students_table = String.format("CREATE TABLE %s( %s TEXT PRIMARY KEY, %s TEXT, %s TEXT)", TABLE_NAME, KEY_MASV, KEY_USER, KEY_PASS);
        String create_students_table = "CREATE TABLE "+ TABLE_NAME +" ( "+ KEY_MASV + " TEXT PRIMARY KEY, "+KEY_USER+" TEXT, "+KEY_PASS+" TEXT)";
        db.execSQL(create_students_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_students_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_students_table);
        onCreate(db);
    }

    public void Addtaikhoan(Taikhoan tk){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MASV,tk.getMasv());
        values.put(KEY_USER,tk.getUser());
        values.put(KEY_PASS, tk.getPassword());

        db.insert(TABLE_NAME, null, values);

    }

    public Taikhoan getTaikhoan (String masv){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, KEY_MASV + " = ? ",new String [] {masv },null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
            Taikhoan taikhoan = new Taikhoan(cursor.getString(0), cursor.getString(1),cursor.getString(2));
            return taikhoan;
        }
        return null;
    }

    public boolean checkEmpty(){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, null,null,null, null, null);

        return (cursor == null);
    }

    public boolean getTrueFasleUser (String user){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, KEY_USER + " = ? ",new String [] {user },null, null, null);
        if(cursor == null)
        {
            return false;
        }else{
            return true;
        }
    }

    public boolean getTrueFaslePass (String pass){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, KEY_PASS + " = ? ",new String [] {pass },null, null, null);
        if(cursor == null)
        {
            return false;
        }else{
            return true;
        }
    }
}
