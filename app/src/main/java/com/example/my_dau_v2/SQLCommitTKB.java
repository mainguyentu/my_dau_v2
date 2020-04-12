package com.example.my_dau_v2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLCommitTKB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "schoolsManager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Thoi_Khoa_Bieu";

    private static final String KEY_ID = "id";
    private static final String KEY_MASV = "masv";
    private static final String KEY_MA_MON_HOC = "monhoc";
    private static final String KEY_MA_GIANG_VIEN = "giangvien";
    private static final String KEY_TIME = "time";
    private static final String KEY_PHONG = "phong";


    public SQLCommitTKB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_students_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT)", TABLE_NAME, KEY_ID, KEY_MASV,KEY_MA_MON_HOC, KEY_MA_GIANG_VIEN, KEY_TIME, KEY_PHONG);
        db.execSQL(create_students_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_students_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_students_table);
        onCreate(db);
    }

    public void AddTKB(ThoiKhoaBieu tkb){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MASV, tkb.getMasv());
        values.put(KEY_MA_MON_HOC, tkb.getMamonhoc());
        values.put(KEY_MA_GIANG_VIEN, tkb.getMagiangvien());
        values.put(KEY_TIME, tkb.getTime());
        values.put(KEY_PHONG, tkb.getPhong());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ThoiKhoaBieu getTKB(String masv){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, KEY_MASV + " = ? ",new String [] {masv },null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        ThoiKhoaBieu thoikhoabieu = new ThoiKhoaBieu(cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
        return thoikhoabieu;
    }
}
