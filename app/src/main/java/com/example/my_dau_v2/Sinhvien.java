package com.example.my_dau_v2;

public class Sinhvien {

    public String masv;
    public String ten;
    public String lop;
    public String khoa;
    public int phonenumber;

    public Sinhvien(String masv, String ten, String lop, String khoa, int phonenumber) {
        this.masv = masv;
        this.ten = ten;
        this.lop = lop;
        this.khoa = khoa;
        this.phonenumber = phonenumber;
    }
/*
    public Sinhvien(Integer id, String masv, String ten, String lop, String khoa, int phonenumber) {
        this.id = id;
        this.masv = masv;
        this.ten = ten;
        this.lop = lop;
        this.khoa = khoa;
        this.phonenumber = phonenumber;
    }*/


    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }
}

