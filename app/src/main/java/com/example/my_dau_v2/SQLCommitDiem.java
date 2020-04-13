package com.example.my_dau_v2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLCommitDiem extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "schoolsManager";
    private static final String TABLE_NAME = "DIEM";
    private static final int DATABASE_VERSION = 1;


    private static final String KEY_MONHOC = "monhoc";
    private static final String KEY_MASV = "masv";
    private static final String KEY_DIEM1 = "diem1";
    private static final String KEY_DIEM2 = "diem2";
    private static final String KEY_HOCKY = "hocky";


    public SQLCommitDiem(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_diem_tables = " CREATE TABLE " + TABLE_NAME + "(" + KEY_MASV + " TEXT PRIMARY KEY, " + KEY_MONHOC + "TEXT, " + KEY_DIEM1 + " TEXT, " + KEY_DIEM2 + " TEXT, " + KEY_HOCKY + " TEXT)";
        db.execSQL(create_diem_tables);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_diem_table = String.format("DROP TABLE IF EXISTS %s ", TABLE_NAME);
        db.execSQL(drop_diem_table);
        onCreate(db);
    }

    public void Adddiem(Diem diem){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MASV, diem.getMasv());
        values.put(KEY_MONHOC, diem.getMonhoc());
        values.put(KEY_DIEM1, diem.getDiem1());
        values.put(KEY_DIEM2, diem.getDiem2());
        values.put(KEY_HOCKY, diem.getHocky());

        db.insert(TABLE_NAME, null, values);
    }

    public Diem getDiem (String masv,String hocky){
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null , KEY_MASV + " = ? ", new String []{masv},null,null,null);
        if(cursor != null){
            cursor.moveToFirst();
            Diem diem = new Diem(cursor.getString(0),cursor.getString(1),cursor.getInt(2),cursor.getInt(3),cursor.getString(4));
            return diem;
//            if(cursor.getString(4).equals(hocky)){
//                cursor.moveToFirst();
//                Diem diem = new Diem(cursor.getString(1),cursor.getInt(2),cursor.getInt(3),cursor.getString(0),cursor.getString(4));
//                return diem;
//            }
        }
        return null;
    }

    public boolean checkEmpty(){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, null,null,null, null, null);

        return (cursor == null);
    }
}
