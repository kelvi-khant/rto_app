package com.example.rto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class PrivacypolicyActivity extends AppCompatActivity {

    TextView privacypolic;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacypolicy);
        Actionbar.SetActionBar(this,getResources().getString(R.string.privacy_policy),findViewById(R.id.action_bar));

        privacypolic=findViewById(R.id.privacypolicy);
        privacypolic.setText(getResources().getString(R.string.defination2));

    }
    public void back(View view) {

        onBackPressed();
        finish();
    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent(getApplicationContext(), SettingActivity.class));
        finish();
  }
}