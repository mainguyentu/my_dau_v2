package com.example.my_dau_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class TKB_Activity extends AppCompatActivity {

    Spinner spnNamhoc,spnHocky,spnTuanhoc;
    ArrayList<String> arrNH;
    ArrayList<String> arrHK;
    ArrayList<String> arrTH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_k_b_);

        Anhxa();
        arrNH = new ArrayList<String>();
        arrHK = new ArrayList<String>();
        arrTH = new ArrayList<String>();
        Addarr();

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


    public void Anhxa(){
        spnNamhoc = findViewById(R.id.spinnernamhoc);
        spnHocky = findViewById(R.id.spinnerhocky);
        spnTuanhoc = findViewById(R.id.spinnertuanhoc);
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
}
