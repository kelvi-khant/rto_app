package com.example.rto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ExamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
    }


    public void back(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent(getApplicationContext(), SecondActivity.class));
        finish();
    }

    public void startexam(View view) {
        startActivity(new Intent(getApplicationContext(), StartExamActivity.class));
        finish();
    }


}