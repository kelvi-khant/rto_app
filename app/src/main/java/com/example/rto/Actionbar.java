package com.example.rto;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Actionbar {
    public static void SetActionBar(Activity activity, String title, View view){

        TextView tv_actionbartitle=view.findViewById(R.id.tv_actionbarname);
        ImageView iv_back=view.findViewById(R.id.iv_back);

        tv_actionbartitle.setText(title);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activity.onBackPressed();
            }
        });

    }
}
