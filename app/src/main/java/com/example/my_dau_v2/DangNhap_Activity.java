package com.example.my_dau_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DangNhap_Activity extends AppCompatActivity {

    EditText txtID,txtPass;
    Button btnAccepct;
    String id,pass;
    public final SQLCommitTK sqltk = new SQLCommitTK(this, "schoolsManager", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap_);

        Anhxa();
//        id=txtID.getText().toString();
//        pass=txtPass.getText().toString();

        btnAccepct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Checked();
            }
        });
    }
    public void Anhxa(){
        txtID = findViewById(R.id.txtID);
        txtPass = findViewById(R.id.txtPass);
        btnAccepct = findViewById(R.id.btnAccepct);
    }
    public void putData(){
        Intent it = new Intent(DangNhap_Activity.this, MainActivity_v2.class);
        Bundle bundle = new Bundle();
        bundle.putString("uid",id);
        it.putExtra("data",bundle);
        startActivity(it);
    }
    public void Checked(){
        if((txtID.equals("") || txtPass.equals(""))||(txtID.equals("") && txtPass.equals(""))){
            Toast.makeText(DangNhap_Activity.this, "Bạn cần nhập đầy đủ thông tin đăng nhập !", Toast.LENGTH_SHORT).show();
        }else{
           if(CheckUser() && CheckPass()){
               putData();
               Toast.makeText(DangNhap_Activity.this, "Bạn đã đăng nhập thành công !", Toast.LENGTH_SHORT).show();
           }else{
               Toast.makeText(this, "Bạn đã nhập sai Tài khoản hoặc Mật khẩu !", Toast.LENGTH_SHORT).show();
           }
        }
    }
    public Boolean CheckUser(){
        String str1 = txtID.getText().toString();
        if(sqltk.getTrueFasleUser(str1)){
            return true;
        }else{
            return false;
        }
    }

    public Boolean CheckPass(){
        String str1 = txtPass.getText().toString();
        if(sqltk.getTrueFaslePass(str1)){
            return true;
        }else{
            return false;
        }
    }
}


