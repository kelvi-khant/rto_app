package com.example.rto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.rto.Adapter.MyQuestionAdapter;
import com.example.rto.Adapter.QuestionBankAdapter;
import com.example.rto.Fragment.QuestionFragment;
import com.example.rto.Fragment.TrafficSignsFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class QuestionBankActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    View openmenu;
    TextView nameTextView;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_bank);

        initVal();
        setLocalData();
        setOnClickListener();

    }

    private void initVal() {
        nameTextView = findViewById(R.id.tv_nameTextView);
        ImageView openOptionsMenuButton = findViewById(R.id.iv_openOptionsMenuButton);

        openmenu=findViewById(R.id.openmenu);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
    }

    private void setLocalData() {
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.QUESTIONS)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.TRAFFIC_SIGNS)));
        tabLayout.setTabTextColors(Color.GRAY,Color.BLACK);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final QuestionBankAdapter adapter = new QuestionBankAdapter(this,getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setOnClickListener() {
        openmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(QuestionBankActivity.this, openmenu);
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.name_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.option_1:
                                nameTextView.setText(getResources().getString(R.string.All));
                                QuestionFragment.questionFragment.getall();
                                TrafficSignsFragment.trafficSignsFragment.getall();
                                return true;

                            case R.id.option_2:
                                nameTextView.setText(getResources().getString(R.string.Bookmark));
                                QuestionFragment.questionFragment.getBookmark();
                                TrafficSignsFragment.trafficSignsFragment.getBookmark();
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