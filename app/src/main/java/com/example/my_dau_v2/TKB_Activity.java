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

public class TKB_Activity extends AppCompatActivity {
    TextView txtT2_1,txtT2_2,txtT2_3,txtT2_4;
    TextView txtT3_1,txtT3_2,txtT3_3,txtT3_4;
    TextView txtT4_1,txtT4_2,txtT4_3,txtT4_4;
    TextView txtT5_1,txtT5_2,txtT5_3,txtT5_4;
    TextView txtT6_1,txtT6_2,txtT6_3,txtT6_4;
    TextView txtT7_1,txtT7_2,txtT7_3,txtT7_4;
    TextView txtuser;
    Spinner spnNamhoc,spnHocky,spnTuanhoc;
    ArrayList<String> arrNH;
    ArrayList<String> arrHK;
    ArrayList<String> arrTH;
    public final SQLCommitTKB sqltkb = new SQLCommitTKB(this,"schoolsManager", null, 1);
    public final SQLiteCommitSV sqlsv = new SQLiteCommitSV(this, "schollManager",null,1);
    String strnamhoc,strhocky,strtuanhoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_k_b_);

        Anhxa();
        arrNH = new ArrayList<String>();
        arrHK = new ArrayList<String>();
        arrTH = new ArrayList<String>();
        Addarr();
        Addadapter();

        Intent it = getIntent();
        final String masv = it.getStringExtra("masv");
        txtuser.setText(sqlsv.getSinhvien(masv).getTen());

//        spnNamhoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                strnamhoc = spnNamhoc.getSelectedItem().toString();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        spnHocky.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                strhocky = spnHocky.getSelectedItem().toString();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        spnTuanhoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                strtuanhoc = spnTuanhoc.getSelectedItem().toString();
//
//                ThoiKhoaBieu tkb = sqltkb.getTKB(masv,strnamhoc,strhocky,strtuanhoc);
//
//                txtT2_1.setText(tkb.getMonhoc());
//                txtT2_2.setText(tkb.getPhong());
//                txtT2_3.setText(tkb.getTime());
//                txtT2_4.setText(tkb.getGiangvien());
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
    }


    public void Anhxa(){
        spnNamhoc = findViewById(R.id.spinnernamhoc);
        spnHocky = findViewById(R.id.spinnerhocky);
        spnTuanhoc = findViewById(R.id.spinnertuanhoc);
        txtuser = findViewById(R.id.txtuser);
        txtT2_1 = findViewById(R.id.txtT2_1);
        txtT2_2 = findViewById(R.id.txtT2_2);
        txtT2_3 = findViewById(R.id.txtT2_3);
        txtT2_4 = findViewById(R.id.txtT2_4);
        txtT3_1 = findViewById(R.id.txtT3_1);
        txtT3_2 = findViewById(R.id.txtT3_2);
        txtT3_3 = findViewById(R.id.txtT3_3);
        txtT3_4 = findViewById(R.id.txtT3_4);
        txtT4_1 = findViewById(R.id.txtT4_1);
        txtT4_2 = findViewById(R.id.txtT4_2);
        txtT4_3 = findViewById(R.id.txtT4_3);
        txtT4_4 = findViewById(R.id.txtT4_4);
//        txtT5_1 = findViewById();
//        txtT5_2 = findViewById();
//        txtT5_3 = findViewById();
//        txtT5_4 = findViewById();
//        txtT6_1 = findViewById();
//        txtT6_2 = findViewById();
//        txtT6_3 = findViewById();
//        txtT6_4 = findViewById();
//        txtT7_1 = findViewById();
//        txtT7_2 = findViewById();
//        txtT7_3 = findViewById();
//        txtT7_4 = findViewById();
    }

    public void Addarr(){
        arrNH.add("2016-2017");
        arrNH.add("2017-2018");
        arrNH.add("2018-2019");
        arrHK.add("Học kỳ I");
        arrHK.add("Học kỳ II");
        arrHK.add("Học kỳ hè");
        arrTH.add("10");
        arrTH.add("11");
        arrTH.add("12");
    }

    public void Addadapter(){
        ArrayAdapter arradNH = new ArrayAdapter(TKB_Activity.this,android.R.layout.simple_spinner_item,arrNH);
        arradNH.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnNamhoc.setAdapter(arradNH);
        ArrayAdapter arradHK = new ArrayAdapter(TKB_Activity.this,android.R.layout.simple_spinner_item,arrHK);
        arradHK.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnHocky.setAdapter(arradHK);
        ArrayAdapter arradTH = new ArrayAdapter(TKB_Activity.this,android.R.layout.simple_spinner_item,arrTH);
        arradTH.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnTuanhoc.setAdapter(arradTH);
    }
}





