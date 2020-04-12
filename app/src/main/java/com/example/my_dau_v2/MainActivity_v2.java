package com.example.my_dau_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_v2 extends AppCompatActivity {
    TextView txtUser;
    Button btnttcn,btntkb,btnxd,btndx;
    public final SQLCommitTK sqltk = new SQLCommitTK(this, "schoolsManager", null, 1);
    public final SQLiteCommitSV sqlsv = new SQLiteCommitSV(this, "schoolsManager", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_v2);

        Anhxa();
        txtUser.setText(getData());

        btnttcn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1 = new Intent(MainActivity_v2.this,TTCNGV_Activity.class);
                startActivity(it1);
            }
        });

        btntkb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it2 = new Intent(MainActivity_v2.this,TKB_Activity.class);
                startActivity(it2);
            }
        });

        btnxd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it3 = new Intent(MainActivity_v2.this,TTCNSV_Activity.class);
                startActivity(it3);
            }
        });
        btndx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it4 = new Intent(MainActivity_v2.this, MainActivity.class);
                startActivity(it4);
                Toast.makeText(MainActivity_v2.this, "Bạn đã đăng xuất thành công !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void Anhxa(){
        txtUser = findViewById(R.id.txtuser);
        btnttcn = findViewById(R.id.btnTTCN);
        btntkb = findViewById(R.id.btnTKB);
        btnxd = findViewById(R.id.btnXD);
        btndx = findViewById(R.id.btnDX);
    }

    public String getData(){
        Intent it = getIntent();
        Bundle bundle = it.getBundleExtra("data");
        String str1 = bundle.getString("uid");
        Taikhoan tk = sqltk.getTaikhoan(str1);
        String str2 = tk.getMasv();
        Sinhvien sv = sqlsv.getSinhvien(str2);
        String name = sv.getTen();
        return name;
    }
}
