package com.example.my_dau_v2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_students_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT)", TABLE_NAME, KEY_ID, KEY_MASV, KEY_USER, KEY_PASS);
        db.execSQL(create_students_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_students_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_students_table);
        onCreate(db);
    }

    public void Addtaikhoan(Taikhoan tk){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MASV,tk.getMasv());
        values.put(KEY_USER,tk.getUser());
        values.put(KEY_PASS, tk.getPassword());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Taikhoan getTaikhoan (String user){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, KEY_USER + " = ? ",new String [] {user },null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Taikhoan taikhoan = new Taikhoan(cursor.getString(1), cursor.getString(2),cursor.getString(3));
        return taikhoan;
    }

    public Boolean getTrueFasleUser (String user){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, KEY_USER + " = ? ",new String [] {user },null, null, null);
        if(cursor == null)
        {
            return false;
        }else{
            return true;
        }
    }

    public Boolean getTrueFaslePass (String pass){
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
