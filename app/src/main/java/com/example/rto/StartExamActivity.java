package com.example.rto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rto.Adapter.ExamAdapter;
import com.example.rto.Adapter.PracticeQuestionAdapter;
import com.example.rto.Model.ExamquestionModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

public class StartExamActivity extends AppCompatActivity {
    TextView question, practicemenu, questioncount;

    private static  final  long COUNTDOWN_IN_MILLIS=48000;
    ArrayList<ExamquestionModel> ExamQuestion;
    public  static ViewPager2 viewPager;
    public static int currentQuestionIndex;

    public static CardView next, prevButton;
    TextView countdown;
    LinearLayout linearLayout, optionview;
    public static  StartExamActivity startExamActivity;
    private ColorStateList colorStateList;
    private CountDownTimer countDownTimer;
    private long timeleftmillis;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_exam);

        initVal();
        setLocalData();
        setOnClickListener();

    }

    private void initVal() {
        questioncount = findViewById(R.id.tv_questioncount);
        prevButton = findViewById(R.id.previous);
        next = findViewById(R.id.next);
        startExamActivity=this;
        countdown=findViewById(R.id.countdwon);
        colorStateList=countdown.getTextColors();
        optionview = findViewById(R.id.li_optionview);
        linearLayout = findViewById(R.id.linearLayoutquestion);
        viewPager = findViewById(R.id.vp_viewpager);
        question = findViewById(R.id.practicequestion);
        practicemenu = findViewById(R.id.tv_spinnername);
    }

    private void setLocalData() {
        ExamQuestion = new ArrayList<>();


        ExamquestionModel examquestionModel1 = new ExamquestionModel(getResources().getString(R.string.practicequestion1),
                "file:///android_asset/image/noparking.png",
                false,
                getResources().getString(R.string.ans11), getResources().getString(R.string.ans12), getResources().getString(R.string.ans13),
                "", "", "",1);
        ExamQuestion.add(examquestionModel1);

        ExamquestionModel examquestionModel2 = new ExamquestionModel(getResources().getString(R.string.practicequestion2),
                "",
                false,
                "", "","",
                "file:///android_asset/image/noparking.png", "file:///android_asset/image/stop.png", "file:///android_asset/image/nostopping.png",
                1);
        ExamQuestion.add(examquestionModel2);

        ExamquestionModel examquestionModel3 = new ExamquestionModel(getResources().getString(R.string.practicequestion3), "",
                false,
                "", "", "",
                "file:///android_asset/image/keepleft.png", "file:///android_asset/image/turnright.png", "file:///android_asset/image/turnleft.png",
                3);
        ExamQuestion.add(examquestionModel3);

        ExamquestionModel examquestionModel4 = new ExamquestionModel(getResources().getString(R.string.practicequestion4), "",
                false,
                getResources().getString(R.string.ans41), getResources().getString(R.string.ans42), getResources().getString(R.string.ans43),
                "", "", "",
                1);
        ExamQuestion.add(examquestionModel4);

        ExamquestionModel examquestionModel5 = new ExamquestionModel(getResources().getString(R.string.practicequestion5), "",
                false,
                getResources().getString(R.string.ans51), getResources().getString(R.string.ans52), getResources().getString(R.string.ans53),
                "", "", "",
                1);
        ExamQuestion.add(examquestionModel5);
        Collections.shuffle(ExamQuestion, new Random(System.currentTimeMillis()));
        ExamAdapter examAdapter = new ExamAdapter(this,ExamQuestion);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setUserInputEnabled(false);
        viewPager.setAdapter(examAdapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                currentQuestionIndex = position;
                questioncount.setText((currentQuestionIndex + 1) + "/" + ExamQuestion.size());
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }

                timeleftmillis=COUNTDOWN_IN_MILLIS;
                Sartcountdown();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

    }
    private void setOnClickListener() {
    }

    public void back(View view) {

        onBackPressed();
    }

    @Override
    public void onBackPressed() {

        Dialog dialog = new Dialog(StartExamActivity.this);
        dialog.setContentView(R.layout.examexit);
        Button no =dialog.findViewById(R.id.btnno);
        Button yes =dialog.findViewById(R.id.btnyes);

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        dialog.dismiss();
            }
        });
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SecondActivity.class));
                finish();
            }
        });
        dialog.show();

    }
    public void Sartcountdown(){
        countDownTimer=new CountDownTimer(timeleftmillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                    timeleftmillis=millisUntilFinished;
                    updatecountdowntext();

            }

            @Override
            public void onFinish() {

                timeleftmillis=0;
                updatecountdowntext();
                if (currentQuestionIndex < ExamQuestion.size() - 1) {
                    currentQuestionIndex++;
                    viewPager.setCurrentItem(currentQuestionIndex);

                }
                Toast.makeText(StartExamActivity.this, "nextquestion"+currentQuestionIndex, Toast.LENGTH_SHORT).show();

            }
        }.start();
    }
    public void updatecountdowntext(){
            int minites=(int)(timeleftmillis/1000)/60;
            int second=(int)(timeleftmillis/1000) % 60;

            String timeFormatted=String.format(Locale.getDefault(),"%02d:%02d",minites,second);

            countdown.setText(timeFormatted);

            if (timeleftmillis<10000){
                countdown.setTextColor(Color.RED);
            }else{
                countdown.setTextColor(colorStateList);
            }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(countDownTimer != null) {

            countDownTimer.cancel();

        }
    }
}