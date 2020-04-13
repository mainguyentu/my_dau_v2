package com.example.my_dau_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class TTCNSV_Activity extends AppCompatActivity {

    TextView txtuser;
    TextView txtnamesv,txtmasv,txtclasssv,txtkhoasv,txtphonenumbersv;


    public final SQLiteCommitSV sqlsv = new SQLiteCommitSV(this,"schoolsManager",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_t_c_n_s_v_);
        Anhxa();

        Intent it = getIntent();
        String masv = it.getStringExtra("masv");
        Sinhvien sv = sqlsv.getSinhvien(masv);
        Log.d("LOG____", "onCreate: "+sv);
        txtuser.setText(sv.getTen());

        txtnamesv.setText(sv.getTen());
        txtmasv.setText(sv.getMasv());
        txtclasssv.setText(sv.getLop());
        txtkhoasv.setText(sv.getKhoa());
        txtphonenumbersv.setText(String.valueOf(sv.getPhonenumber()));


    }


    public void Anhxa(){
        txtuser = findViewById(R.id.txt_ttcn_user);
        txtmasv = findViewById(R.id.txt_masv_v2);
        txtnamesv = findViewById(R.id.txt_namesv_v2);
        txtclasssv = findViewById(R.id.txt_classsv_v2);
        txtkhoasv = findViewById(R.id.txt_khoa_v2);
        txtphonenumbersv = findViewById(R.id.txt_phonesv_v2);
    }

//    public String getData(String masv){
//        Sinhvien sv = sqlsv.getSinhvien(masv);
//        String name = sv.getTen();
//        return name;
//    }
}
