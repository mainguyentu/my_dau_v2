package com.example.my_dau_v2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQLiteCommitSV extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "schoolsManager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Sinhvien";

    private static final String KEY_ID = "id";
    private static final String KEY_MASV = "masv";
    private static final String KEY_NAME = "name";
    private static final String KEY_LOP = "lop";
    private static final String KEY_KHOA = "khoa";
    private static final String KEY_PHONE_NUMBER = "phonenumber";



    public SQLiteCommitSV(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

//    //truy vấn ko trả kết quả
//    public void Querydata(String sql){
//        SQLiteDatabase database = getWritableDatabase();
//        database.execSQL(sql);
//    }
//
//
//    //truy vấn có trả kết quả
//    public Cursor getData(String sql){
//        SQLiteDatabase database = getReadableDatabase();
//        return database.rawQuery(sql,null);
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_students_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT)", TABLE_NAME, KEY_ID, KEY_MASV, KEY_NAME, KEY_LOP, KEY_KHOA, KEY_PHONE_NUMBER);
        db.execSQL(create_students_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_students_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_students_table);
        onCreate(db);
    }

    public void Addsinhvien(Sinhvien sinhvien){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MASV,sinhvien.getMasv());
        values.put(KEY_NAME, sinhvien.getTen());
        values.put(KEY_LOP, sinhvien.getLop());
        values.put(KEY_KHOA, sinhvien.getKhoa());
        values.put(KEY_PHONE_NUMBER, sinhvien.getPhonenumber());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Sinhvien getSinhvien(String masv){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, KEY_MASV + " = ? ",new String [] {masv },null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Sinhvien sinhvien = new Sinhvien(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5));
        return sinhvien;
    }

    public List<Sinhvien> getAllSV() {
        List<Sinhvien>  studentList = new ArrayList<>();
        String query = "SELECT * FROM" + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            Sinhvien student = new Sinhvien(cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getString(4),cursor.getInt(5));
            studentList.add(student);
            cursor.moveToNext();
        }
        return studentList;
    }

    public void updateStudent(Sinhvien sv) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MASV, sv.getMasv());
        values.put(KEY_NAME, sv.getTen());
        values.put(KEY_LOP, sv.getLop());
        values.put(KEY_KHOA, sv.getKhoa());
        values.put(KEY_PHONE_NUMBER, sv.getPhonenumber());

        db.update(TABLE_NAME, values, KEY_MASV + " = ?", new String[] { sv.getMasv() });
        db.close();
    }
}
