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
    private static final String KEY_MON_HOC = "monhoc";
    private static final String KEY_GIANG_VIEN = "giangvien";
    private static final String KEY_TIME = "time";
    private static final String KEY_PHONG = "phong";
    private static final String KEY_NAM_HOC = "namhoc";
    private static final String KEY_KY_HOC = "kyhoc";
    private static final String KEY_TUAN_HOC = "tuanhoc";
    private static final String KEY_THU = "thu";


    public SQLCommitTKB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String create_students_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT)", TABLE_NAME, KEY_MASV,KEY_MA_MON_HOC, KEY_MA_GIANG_VIEN, KEY_TIME, KEY_PHONG);
        String create_students_table = "CREATE TABLE "+ TABLE_NAME + "("+ KEY_MASV +" INTEGER PRIMARY KEY, "+ KEY_MON_HOC +" TEXT, "+ KEY_GIANG_VIEN +" TEXT, "+ KEY_TIME +" TEXT, "+ KEY_PHONG + " TEXT, " + KEY_NAM_HOC + " TEXT, " + KEY_KY_HOC + " TEXT, " + KEY_TUAN_HOC + " TEXT, " + KEY_THU + "TEXT)";
        db.execSQL(create_students_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_students_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_students_table);
        onCreate(db);
    }

    public void AddTKB(ThoiKhoaBieu tkb){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MASV, tkb.getMasv());
        values.put(KEY_MON_HOC, tkb.getMonhoc());
        values.put(KEY_GIANG_VIEN, tkb.getGiangvien());
        values.put(KEY_TIME, tkb.getTime());
        values.put(KEY_PHONG, tkb.getPhong());
        values.put(KEY_NAM_HOC, tkb.getNamhoc());
        values.put(KEY_KY_HOC, tkb.getKyhoc());
        values.put(KEY_TUAN_HOC, tkb.getTuanhoc());
        values.put(KEY_THU, tkb.getThu());

        db.insert(TABLE_NAME, null, values);
    }

    public ThoiKhoaBieu getTKB(String masv,String namhoc,String hocky,String tuanhoc){
        Cursor cursor;
        SQLiteDatabase db = getReadableDatabase();

        cursor = db.query(TABLE_NAME, null, KEY_MASV + " = ? " + " AND " + KEY_NAM_HOC + " = ? " + " AND " + KEY_KY_HOC + " = ? " + " AND " + KEY_TUAN_HOC + " = ? ", new String[]{masv, namhoc, hocky, tuanhoc}, null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
            ThoiKhoaBieu thoikhoabieu = new ThoiKhoaBieu(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
            return thoikhoabieu;
        }
        return null;
    }

    public boolean checkEmpty(){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, null,null,null, null, null);

        return (cursor == null);
    }
}
