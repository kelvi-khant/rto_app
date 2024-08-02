package com.example.rto;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FormsActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms);
        Actionbar.SetActionBar(this,getResources().getString(R.string.Forms),findViewById(R.id.action_bar));
    }

    public void back(View view) {

        onBackPressed();
    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent(getApplicationContext(), SettingActivity.class));
        finish();
    }

    public void forms1(View view) {


    }
}