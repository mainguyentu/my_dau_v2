package com.example.my_dau_v2;

public class ThoiKhoaBieu {
    public String masv;
    public String monhoc;
    public String giangvien;
    public String time;
    public String phong;
    public String namhoc;
    public String kyhoc;
    public String tuanhoc;
    public String thu;

    public ThoiKhoaBieu(String masv, String monhoc, String giangvien, String time, String phong, String namhoc, String kyhoc, String tuanhoc, String thu) {
        this.masv = masv;
        this.monhoc = monhoc;
        this.giangvien = giangvien;
        this.time = time;
        this.phong = phong;
        this.namhoc = namhoc;
        this.kyhoc = kyhoc;
        this.tuanhoc = tuanhoc;
        this.thu = thu;
    }

    public String getTime() {
        return time;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(String monhoc) {
        this.monhoc = monhoc;
    }

    public String getGiangvien() {
        return giangvien;
    }

    public void setGiangvien(String giangvien) {
        this.giangvien = giangvien;
    }

    public String getNamhoc() {
        return namhoc;
    }

    public void setNamhoc(String namhoc) {
        this.namhoc = namhoc;
    }

    public String getKyhoc() {
        return kyhoc;
    }

    public void setKyhoc(String kyhoc) {
        this.kyhoc = kyhoc;
    }

    public String getTuanhoc() {
        return tuanhoc;
    }

    public void setTuanhoc(String tuanhoc) {
        this.tuanhoc = tuanhoc;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }
}
