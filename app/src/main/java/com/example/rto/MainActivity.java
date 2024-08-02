package com.example.rto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVal();
        setLocalData();
        setOnClickListener();

        loadlocal();

    }

    private void initVal() {

    }

    private void setLocalData() {
        ImageView splashImage = findViewById(R.id.splashImage);
        Animation zoomAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom_animation);
        splashImage.startAnimation(zoomAnimation);

        zoomAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                // Animation has ended, start the next activity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
    }

    private void setOnClickListener() {
    }

    private void setlocale(String language) {

        Locale locale= new Locale(language);
        Locale.setDefault(locale);

        Configuration configuration=new Configuration();
        configuration.locale=locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());

//        SharedPreferencesManager.getInstance(activity).savePreferences("languageCode", "gu");

        SharedPreferences.Editor editor=getSharedPreferences("settings",MODE_PRIVATE).edit();
        editor.putString("app_long",language);
        editor.apply();
    }
    public void loadlocal(){
        SharedPreferences sharedPreferences=getSharedPreferences("settings",MODE_PRIVATE);
        String language=sharedPreferences.getString("app_long","");
        setlocale(language);
    }

}