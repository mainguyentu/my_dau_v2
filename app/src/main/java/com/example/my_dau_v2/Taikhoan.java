package com.example.my_dau_v2;

public class Taikhoan {
    public Integer id;
    public String user;
    public String password;
    public String masv;

    public Taikhoan(String user, String password, String masv) {
        this.user = user;
        this.password = password;
        this.masv = masv;
    }

    public Taikhoan(String password, String masv) {
        this.password = password;
        this.masv = masv;
    }

    public Taikhoan(Integer id, String user, String password) {
        this.id = id;
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }
}
