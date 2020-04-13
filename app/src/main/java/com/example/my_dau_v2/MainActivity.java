package com.example.my_dau_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnDN;
    ArrayList<Sinhvien> arrsinhvien = new ArrayList<Sinhvien>();
    ArrayList<Taikhoan> arrtaikhoan = new ArrayList<Taikhoan>();
    ArrayList<ThoiKhoaBieu> arrtkb = new ArrayList<ThoiKhoaBieu>();
    ArrayList<Diem> arrDiem = new ArrayList<Diem>();
    public final SQLCommitTK sqltk = new SQLCommitTK(this, "schoolsManager", null, 1);
    public final SQLiteCommitSV sqlsv = new SQLiteCommitSV(this, "schoolsManager", null, 1);
    public final SQLCommitTKB sqltkb = new SQLCommitTKB(this,"schoolsManager",null,1);
    public final SQLCommitDiem sqldiem = new SQLCommitDiem(this,"schoolsManager", null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Addarr();
        if(sqlsv.getAllSV().size() == 0){
            for (int i = 0 ; i<10; i++){
                sqlsv.Addsinhvien(arrsinhvien.get(i));
            }
        }
        Addarrtk();
        if(sqltk.checkEmpty() == true){
            for(int i = 0 ; i<10 ; i++){
                sqltk.Addtaikhoan(arrtaikhoan.get(i));
            }
        }
        Addarrtkb();
        if(sqltkb.checkEmpty() == true){
            for(int i = 0; i<15;i++){
                sqltkb.AddTKB(arrtkb.get(i));
            }
        }
        AddarrDiem();
        if(sqldiem.checkEmpty() == true){
            for(int i = 0;i<4;i++){
                sqldiem.Adddiem(arrDiem.get(i));
            }
        }
        btnDN = findViewById(R.id.btn_main);
        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,DangNhap_Activity.class);
                startActivity(it);
            }
        });
    }

    public void Addarr(){
        arrsinhvien.add(new Sinhvien("MNT2410","Mai Nguyen Tu","16CT","CN",011));
        arrsinhvien.add(new Sinhvien("0B16DDCD","Nguyen Van B","16DD","CD",012));
        arrsinhvien.add(new Sinhvien("0C16CTCN","Nguyen Van C","16CT","CN",013));
        arrsinhvien.add(new Sinhvien("0D17CTCN","Nguyen Van D","17CT","CN",014));
        arrsinhvien.add(new Sinhvien("0E16TATA","Nguyen Van E","16TA","TA",015));
        arrsinhvien.add(new Sinhvien("0D18TATA","Nguyen Van F","18TA","TA",016));
        arrsinhvien.add(new Sinhvien("0G16TTTT","Nguyen Van G","16TT","TT",017));
        arrsinhvien.add(new Sinhvien("0H16TTTT","Nguyen Van H","16TT","TT",001));
        arrsinhvien.add(new Sinhvien("0K18KTKT","Nguyen Van K","18KT","KT",002));
        arrsinhvien.add(new Sinhvien("0L18KTKT","Nguyen Van L","18KT","KT",010));
    }

    public void Addarrtk(){
        arrtaikhoan.add(new Taikhoan("MNT2410","1","MNT2410"));
        arrtaikhoan.add(new Taikhoan("0B16DDCD","1","0B16DDCD"));
        arrtaikhoan.add(new Taikhoan("0C16CTCN","1","0C16CTCN"));
        arrtaikhoan.add(new Taikhoan("0D17CTCN","1","0D17CTCN"));
        arrtaikhoan.add(new Taikhoan("0E16TATA","1","0E16TATA"));
        arrtaikhoan.add(new Taikhoan("0D18TATA","1","0D18TATA"));
        arrtaikhoan.add(new Taikhoan("0G16TTTT","1","0G16TTTT"));
        arrtaikhoan.add(new Taikhoan("0H16TTTT","1","0H16TTTT"));
        arrtaikhoan.add(new Taikhoan("0K18KTKT","1","0K18KTKT"));
        arrtaikhoan.add(new Taikhoan("0L18KTKT","1","0L18KTKT"));

    }

    public void Addarrtkb(){
        arrtkb.add(new ThoiKhoaBieu("MNT2410","Java","Thao","6-10","305","2018-2019","Học kỳ I","10","Thứ 2"));
        arrtkb.add(new ThoiKhoaBieu("MNT2410","Android","Uy","1-5","204","2016-2017","Học kỳ I","5","Thứ 5"));
        arrtkb.add(new ThoiKhoaBieu("MNT2410","Mac-II","Toan","6-10","507","2019-2020","Học kỳ II","5","Thứ 6"));
        arrtkb.add(new ThoiKhoaBieu("0D17CTCN","","","","","","","",""));
        arrtkb.add(new ThoiKhoaBieu("0G16TTTT","","","","","","","",""));
        arrtkb.add(new ThoiKhoaBieu("0D18TATA","","","","","","","",""));
        arrtkb.add(new ThoiKhoaBieu("0G16TTTT","","","","","","","",""));
        arrtkb.add(new ThoiKhoaBieu("0L18KTKT","","","","","","","",""));
        arrtkb.add(new ThoiKhoaBieu("0L18KTKT","","","","","","","",""));
        arrtkb.add(new ThoiKhoaBieu("0L18KTKT","","","","","","","",""));
        arrtkb.add(new ThoiKhoaBieu("0L18KTKT","","","","","","","",""));
        arrtkb.add(new ThoiKhoaBieu("0D17CTCN","","","","","","","",""));
        arrtkb.add(new ThoiKhoaBieu("0H16TTTT","","","","","","","",""));
        arrtkb.add(new ThoiKhoaBieu("0H16TTTT","","","","","","","",""));
        arrtkb.add(new ThoiKhoaBieu("0H16TTTT","","","","","","","",""));
    }

    public void AddarrDiem(){
        arrDiem.add(new Diem("MNT2410","Java",10,9,"Học kỳ I"));
        arrDiem.add(new Diem("MNT2410","C++",8,7,"Học kỳ II"));
        arrDiem.add(new Diem("0B16DDCD","MacII",10,9,"Học kỳ I"));
        arrDiem.add(new Diem("0B16DDCD","DaiSo",8,7,"Học kỳ II"));

    }
}
