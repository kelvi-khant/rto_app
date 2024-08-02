package com.example.rto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TermsandCondtionActivity extends AppCompatActivity {

    TextView TermsandCondtions;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termsand_condtion);


        Actionbar.SetActionBar(this,getResources().getString(R.string.terms_amp_conditions),findViewById(R.id.action_bar));

        TermsandCondtions=findViewById(R.id.termscondtion);
        TermsandCondtions.setText(getResources().getString(R.string.defination1));


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