package com.example.rto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.rto.Fragment.QuestionFragment;
import com.example.rto.Fragment.TrafficSignsFragment;

public class DrivingSchoolActivity extends AppCompatActivity {
    TextView nameTextView;
    View openmenu;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driving_school);

        initVal();
        setLocalData();
        setOnClickListener();

    }

    private void initVal() {
        nameTextView = findViewById(R.id.tv_nameTextView);
        openmenu=findViewById(R.id.openmenu);
    }

    private void setLocalData() {
    }

    private void setOnClickListener() {
        openmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(DrivingSchoolActivity.this, openmenu);
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.name_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.option_1:
                                nameTextView.setText(getResources().getString(R.string.All));
//                                QuestionFragment.questionFragment.getall();
//                                TrafficSignsFragment.trafficSignsFragment.getall();
                                return true;

                            case R.id.option_2:
                                nameTextView.setText(getResources().getString(R.string.Bookmark));
//                                QuestionFragment.questionFragment.getBookmark();
//                                TrafficSignsFragment.trafficSignsFragment.getBookmark();
                                return true;

                            default:
                                return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });
    }

    public void back(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent(getApplicationContext(), SecondActivity.class));
        finish();
    }
}