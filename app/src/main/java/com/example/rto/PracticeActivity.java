package com.example.rto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rto.Adapter.PracticeQuestionAdapter;
import com.example.rto.Model.CustomViewPager;
import com.example.rto.Model.PracticeQuestionModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PracticeActivity extends AppCompatActivity {

    TextView question, practicemenu, questioncount;

    ArrayList<PracticeQuestionModel> practiceQuestion;
    public  static ViewPager2 viewPager;
    public static int currentQuestionIndex;
    View openmenu;
    public static CardView next, prevButton;
    LinearLayout linearLayout, optionview;
    int selectoption;
    public  static int selectedOption = -1;
    Dialog dialog,dialog2;
    public static PracticeActivity practiceActivity;

    @SuppressLint({"MissingInflatedId", "WrongViewCast", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        initVal();
        setLocalData();
        setOnClickListener();

    }

    private void initVal() {

        questioncount = findViewById(R.id.tv_questioncount);
        prevButton = findViewById(R.id.previous);
        next = findViewById(R.id.next);
        practiceActivity = this;
        optionview = findViewById(R.id.li_optionview);
        linearLayout = findViewById(R.id.linearLayoutquestion);
        viewPager = findViewById(R.id.vp_viewpager);
        question = findViewById(R.id.practicequestion);
        practicemenu = findViewById(R.id.tv_spinnername);
        openmenu = findViewById(R.id.practicemenu);

    }

    private void setLocalData() {

        practiceQuestion = new ArrayList<>();

        PracticeQuestionModel practiceQuestionModel1 = new PracticeQuestionModel(getResources().getString(R.string.practicequestion1),
                "",
                false,
                getResources().getString(R.string.ans11), getResources().getString(R.string.ans12), getResources().getString(R.string.ans13),
                "", "", "",
                1);
        practiceQuestion.add(practiceQuestionModel1);
        PracticeQuestionModel practiceQuestionModel2 = new PracticeQuestionModel(getResources().getString(R.string.practicequestion2),
                "",
                false,
                "", "", "",
                "file:///android_asset/image/noparking.png", "file:///android_asset/image/stop.png", "file:///android_asset/image/nostopping.png",
                1);
        practiceQuestion.add(practiceQuestionModel2);
        PracticeQuestionModel practiceQuestionModel3 = new PracticeQuestionModel(getResources().getString(R.string.practicequestion3), "",
                false,
                "", "", "",
                "file:///android_asset/image/keepleft.png", "file:///android_asset/image/turnright.png", "file:///android_asset/image/turnleft.png",
                3);
        practiceQuestion.add(practiceQuestionModel3);
        PracticeQuestionModel practiceQuestionModel4 = new PracticeQuestionModel(getResources().getString(R.string.practicequestion4), "",
                false,
                getResources().getString(R.string.ans41), getResources().getString(R.string.ans42), getResources().getString(R.string.ans43),
                "", "", "",
                1);
        practiceQuestion.add(practiceQuestionModel4);
        PracticeQuestionModel practiceQuestionModel5 = new PracticeQuestionModel(getResources().getString(R.string.practicequestion5), "",
                false,
                getResources().getString(R.string.ans51), getResources().getString(R.string.ans52), getResources().getString(R.string.ans53),
                "", "", "",
                1);
        practiceQuestion.add(practiceQuestionModel5);
        PracticeQuestionModel practiceQuestionModel6 = new PracticeQuestionModel(getResources().getString(R.string.practicequestion6), "file:///android_asset/image/stop.png",
                false,
                getResources().getString(R.string.ans61), getResources().getString(R.string.ans62), getResources().getString(R.string.ans63),
                "", "", "",
                1);
        practiceQuestion.add(practiceQuestionModel6);
        PracticeQuestionModel practiceQuestionModel7 = new PracticeQuestionModel(getResources().getString(R.string.practicequestion7), "",
                false,
                "", "", "",
                "file:///android_asset/image/giveway.png", "file:///android_asset/image/noparking.png", "file:///android_asset/image/stop.png",
                1);
        practiceQuestion.add(practiceQuestionModel7);
//        PracticeQuestionModel practiceQuestionModel8 = new PracticeQuestionModel(getResources().getString(R.string.practicequestion8), "",
//                false,
//                getResources().getString(R.string.ans81), getResources().getString(R.string.ans82), getResources().getString(R.string.ans83),
//                "", "", "",
//                3);
//        practiceQuestion.add(practiceQuestionModel8);
//        PracticeQuestionModel practiceQuestionModel9 = new PracticeQuestionModel(getResources().getString(R.string.practicequestion9), "",
//                false,
//                getResources().getString(R.string.ans91), getResources().getString(R.string.ans92), getResources().getString(R.string.ans93),
//                "", "", "",
//                2);
//        practiceQuestion.add(practiceQuestionModel9);
        Collections.shuffle(practiceQuestion, new Random(System.currentTimeMillis()));
        PracticeQuestionAdapter practiceQuestionAdapter = new PracticeQuestionAdapter(this,practiceQuestion);

        viewPager.setAdapter(practiceQuestionAdapter);
        viewPager.setOffscreenPageLimit(1);
    }

    private void setOnClickListener() {
        questioncount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(PracticeActivity.this);
                dialog.setContentView(R.layout.questioncountdailog);

                TextView cancle=dialog.findViewById(R.id.cancel1);
                TextView go=dialog.findViewById(R.id.go);

                EditText editText=dialog.findViewById(R.id.et_dailog);

                cancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                go.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (!editText.getText().toString().isEmpty()) {
                            int getPosition = Integer.parseInt(editText.getText().toString());
                            viewPager.setCurrentItem(getPosition - 1, false);
                        }
                        dialog.dismiss();

                    }

                });
                dialog.show();
            }
        });

        openmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(PracticeActivity.this, openmenu);
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.practice_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.option_1:
                                practicemenu.setText(getResources().getString(R.string.All));

                                PracticeQuestionAdapter practiceQuestionAdapter = new PracticeQuestionAdapter(PracticeActivity.this,practiceQuestion );

                                viewPager.setAdapter(practiceQuestionAdapter);
                                return true;

                            case R.id.option_2:
                                practicemenu.setText(getResources().getString(R.string.Bookmark));

                                ArrayList<PracticeQuestionModel> bookmarks = new ArrayList<>();
                                for (int i = 0; i < practiceQuestion.size(); i++) {

                                    if (practiceQuestion.get(i).isBookmark()) {
                                        bookmarks.add(practiceQuestion.get(i));
                                    }
                                }
                                viewPager.setAdapter(new PracticeQuestionAdapter( PracticeActivity.this,bookmarks));

                                return true;
                            case R.id.option_3:
                                practicemenu.setText(getResources().getString(R.string.TRAFFIC_SIGNS));
                                ArrayList<PracticeQuestionModel> trafficSigns = new ArrayList<>();
                                for (int i = 0; i < practiceQuestion.size(); i++) {

                                    if (practiceQuestion.get(i).getOption1()==practiceQuestion.get(i).getOption2()) {
                                        trafficSigns.add(practiceQuestion.get(i));
                                    }
                                }

                                viewPager.setAdapter(new PracticeQuestionAdapter(PracticeActivity.this, trafficSigns));

                                return true;
                            case R.id.option_4:
                                practicemenu.setText(getResources().getString(R.string.Questions));
                                ArrayList<PracticeQuestionModel> Question = new ArrayList<>();
                                for (int i = 0; i < practiceQuestion.size(); i++) {

                                    if (practiceQuestion.get(i).getOption3image()==practiceQuestion.get(i).getQuestionimage()) {
                                        Question.add(practiceQuestion.get(i));
                                        questioncount.setText((currentQuestionIndex + 1) + "/" + Question.size());
                                    }
                                }

                                questioncount.setText((currentQuestionIndex + 1) + "/" + Question.size());
                                viewPager.setAdapter(new PracticeQuestionAdapter(PracticeActivity.this, Question));

                                return true;

                            default:
                                return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });
        questioncount.setText((currentQuestionIndex + 1) + "/" + practiceQuestion.size());
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                currentQuestionIndex = position;
                questioncount.setText((currentQuestionIndex + 1) + "/" + practiceQuestion.size());
                if (position > 0) {
                    prevButton.setVisibility(View.VISIBLE);
                } else {
                    prevButton.setVisibility(View.GONE);
                }

                if (position == practiceQuestion.size()-1) {
                    next.setVisibility(View.GONE);
                } else {

                    next.setVisibility(View.VISIBLE);
                }
                selectoption=PracticeQuestionAdapter.selectedOption;
            }


            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (currentQuestionIndex < practiceQuestion.size() - 1) {
                    currentQuestionIndex++;
                    viewPager.setCurrentItem(currentQuestionIndex);

                }
            }
        });
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex--;
                    viewPager.setCurrentItem(currentQuestionIndex);
                }
            }
        });
    }

    public void back(View view) {

        onBackPressed();
        finish();
    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent(getApplicationContext(), SecondActivity.class));
        finish();

    }
}