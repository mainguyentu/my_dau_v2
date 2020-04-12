package com.example.my_dau_v2;

public class ThoiKhoaBieu {
    public Integer id;
    public String masv;
    public String mamonhoc;
    public String magiangvien;
    public String time;
    public String phong;

    public ThoiKhoaBieu(Integer id, String mamonhoc, String magiangvien, String time, String phong) {
        this.id = id;
        this.mamonhoc = mamonhoc;
        this.magiangvien = magiangvien;
        this.time = time;
        this.phong = phong;
    }

    public ThoiKhoaBieu(String masv, String mamonhoc, String magiangvien, String time, String phong) {
        this.masv = masv;
        this.mamonhoc = mamonhoc;
        this.magiangvien = magiangvien;
        this.time = time;
        this.phong = phong;
    }

    public ThoiKhoaBieu(String mamonhoc, String magiangvien, String time, String phong) {
        this.mamonhoc = mamonhoc;
        this.magiangvien = magiangvien;
        this.time = time;
        this.phong = phong;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMamonhoc() {
        return mamonhoc;
    }

    public void setMamonhoc(String mamonhoc) {
        this.mamonhoc = mamonhoc;
    }

    public String getMagiangvien() {
        return magiangvien;
    }

    public void setMagiangvien(String magiangvien) {
        this.magiangvien = magiangvien;
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
}
