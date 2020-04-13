package com.example.my_dau_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class XemDiem_Activity extends AppCompatActivity {

    public final SQLCommitDiem sqldiem = new SQLCommitDiem(this,"schoolsManager", null, 1);
    public final SQLiteCommitSV sqlsv = new SQLiteCommitSV(this,"schoolsManager", null, 1);
    Spinner spnhocky;
    TextView txthocky,txtuser;
    TextView txtmonhoc,txtdiemlan1,txtdiemlan2;
    TextView txtmonhoc_lan1,txtdiemlan1_lan1,txtdiemlan2_lan1;
    TextView txtmonhoc_lan2,txtdiemlan1_lan2,txtdiemlan2_lan2;
    ArrayList<String> arrHK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_diem_);
        Anhxa();
        arrHK = new ArrayList<String>();
        Addarr();
        Addadapter();

        Intent it = getIntent();
        final String masv = it.getStringExtra("masv");
        txtuser.setText(getData(masv));

//        spnhocky.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String str = spnhocky.getSelectedItem().toString();
//                Diem diem = sqldiem.getDiem(masv,str);
//                txtmonhoc_lan1.setText(diem.getMonhoc());
//                txtdiemlan1_lan1.setText(diem.getDiem1());
//                txtdiemlan2_lan1.setText(diem.getDiem2());
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
    }


    public void Anhxa(){
        spnhocky = findViewById(R.id.spnhocky);
        txthocky = findViewById(R.id.txthocky);
        txtmonhoc = findViewById(R.id.txtmonhoc);
        txtmonhoc_lan1 = findViewById(R.id.txtmonhoc_lan1);
        txtmonhoc_lan2 = findViewById(R.id.txtmonhoc_lan2);
        txtdiemlan1 = findViewById(R.id.txtdiemlan1);
        txtdiemlan1_lan1 = findViewById(R.id.txtdiemlan1_lan1);
        txtdiemlan1_lan2 = findViewById(R.id.txtdiemlan1_lan2);
        txtdiemlan2 = findViewById(R.id.txtdiemlan2);
        txtdiemlan2_lan1 = findViewById(R.id.txtdiemlan2_lan1);
        txtdiemlan2_lan2 = findViewById(R.id.txtdiemlan2_lan2);
        txtuser = findViewById(R.id.txtxemdiem_user);
    }

    public void Addarr(){
        arrHK.add("Học kỳ I");
        arrHK.add("Học kỳ II");
        arrHK.add("Học kỳ hè");
    }

    public void Addadapter(){
        ArrayAdapter arradNH = new ArrayAdapter(XemDiem_Activity.this,android.R.layout.simple_spinner_item,arrHK);
        arradNH.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnhocky.setAdapter(arradNH);
    }

    public String getData(String masv){
        Sinhvien sv = sqlsv.getSinhvien(masv);
        String name = sv.getTen();
        return name;
    }
}
