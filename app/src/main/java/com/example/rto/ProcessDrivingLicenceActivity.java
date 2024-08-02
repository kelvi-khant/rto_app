package com.example.rto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.rto.Adapter.ProcessdrivinglicenceAdapter;
import com.example.rto.Adapter.RTOofficeAdapter;
import com.example.rto.Model.ProcessdrivinglicenceModel;
import com.example.rto.Model.RTOofficeModel;

import java.util.ArrayList;

public class ProcessDrivingLicenceActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Activity activity=ProcessDrivingLicenceActivity.this;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_driving_licence);
        Actionbar.SetActionBar(this,getResources().getString(R.string.process_of_driving_licence),findViewById(R.id.action_bar));

        initVal();
        setLocalData();
        setOnClickListener();

    }

    private void initVal() {
        recyclerView=findViewById(R.id.recyclear);
    }

    private void setLocalData() {
        ArrayList<ProcessdrivinglicenceModel>list=new ArrayList<>();

        list.add(new ProcessdrivinglicenceModel(  getResources().getString(R.string.processt1),false,
                getResources().getString(R.string.process1)));
        list.add(new ProcessdrivinglicenceModel(  getResources().getString(R.string.processt2),false,
                getResources().getString(R.string.process2)));
        list.add(new ProcessdrivinglicenceModel(  getResources().getString(R.string.processt3),false,
                getResources().getString(R.string.process3)));
        list.add(new ProcessdrivinglicenceModel(  getResources().getString(R.string.processt4),false,
                getResources().getString(R.string.process4)));
        list.add(new ProcessdrivinglicenceModel(  getResources().getString(R.string.processt5),false,
                getResources().getString(R.string.process5)));
        list.add(new ProcessdrivinglicenceModel(  getResources().getString(R.string.processt6),false,
                getResources().getString(R.string.process6)));

        ProcessdrivinglicenceAdapter adapter=new ProcessdrivinglicenceAdapter(list,this);

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
