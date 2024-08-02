package com.example.rto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.rto.Adapter.RTOofficeAdapter;
import com.example.rto.Model.RTOofficeModel;

import java.util.ArrayList;

public class RTOofficeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Activity activity=RTOofficeActivity.this;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtooffice);

        Actionbar.SetActionBar(this,getResources().getString(R.string.rto_offices),findViewById(R.id.action_bar));

        initVal();
        setLocalData();
        setOnClickListener();


    }

    private void initVal() {
        recyclerView=findViewById(R.id.recyclear);
    }

    private void setLocalData() {
        ArrayList<RTOofficeModel> list=new ArrayList<>();


        list.add(new RTOofficeModel(getResources().getString(R.string.city1) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city2) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city3) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city4) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city5) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city6) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city7) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city8) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city9) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city10) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city11) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city12) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city13) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city14) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city15) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city16) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city17) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city18) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city19) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city20) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city21) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city22) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city23) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city24) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city25) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city26) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city27) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city30) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city31) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city32) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city33) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city34) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city35) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city36) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city37) ,R.drawable.back));
        list.add(new RTOofficeModel(getResources().getString(R.string.city38) ,R.drawable.back));

        RTOofficeAdapter adapter=new RTOofficeAdapter(list,this);

        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListener() {
    }

    public void back(View view) {

        onBackPressed();
    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent(getApplicationContext(), SettingActivity.class));
        finish();
    }
}