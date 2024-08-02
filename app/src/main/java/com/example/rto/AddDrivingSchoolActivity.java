package com.example.rto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddDrivingSchoolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_driving_school);
        Actionbar.SetActionBar(this,getResources().getString(R.string.add_driving_school),findViewById(R.id.action_bar));
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