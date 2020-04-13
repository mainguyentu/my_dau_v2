package com.example.my_dau_v2;

public class Diem {
    public String monhoc;
    public int diem1;
    public int diem2;
    public String masv;
    public String hocky;

    public Diem(String masv,String monhoc,int diem1,int diem2,String hocky) {
        this.masv = masv;
        this.monhoc = monhoc;
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.hocky = hocky;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(String monhoc) {
        this.monhoc = monhoc;
    }

    public int getDiem1() {
        return diem1;
    }

    public void setDiem1(int diem1) {
        this.diem1 = diem1;
    }

    public int getDiem2() {
        return diem2;
    }

    public void setDiem2(int diem2) {
        this.diem2 = diem2;
    }

    public String getHocky() {
        return hocky;
    }

    public void setHocky(String hocky) {
        this.hocky = hocky;
    }
}
