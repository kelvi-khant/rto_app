package com.example.rto;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ConfigurationInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class SettingActivity extends AppCompatActivity {

    LinearLayout from,processdrivinglicense,RTOoffice,ll_contactus,share,adddrivingschool,disclaimer1;
    TextView textView,modechange,languagee,disclaimer;
    ArrayList<String>arrayList;
    ImageView imageView;
    Dialog dialog,dialog2;


    public static  SettingActivity settingActivity;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_setting);
        Actionbar.SetActionBar(this,getResources().getString(R.string.settings_amp_help),findViewById(R.id.action_bar));
        initVal();
        setLocalData();
        setOnClickListener();

    }

    private void initVal() {

        from=findViewById(R.id.from);
        settingActivity=this;
        processdrivinglicense=findViewById(R.id.processdrivinglicense);
        RTOoffice=findViewById(R.id.RTOoffice);
        ll_contactus=findViewById(R.id.ll_contactus);
        share=findViewById(R.id.ll_share);
        adddrivingschool=findViewById(R.id.ll_adddrivingschool);
        textView=findViewById(R.id.dropdownstate);
        modechange=findViewById(R.id.tv_mode);
        languagee=findViewById(R.id.tv_language);
        disclaimer=findViewById(R.id.disclaimer);
        disclaimer1=findViewById(R.id.disclaimer1);
        imageView=findViewById(R.id.adddailog);

    }

    private void setLocalData() {

        SharedPreferences prefs = getSharedPreferences("statename", MODE_PRIVATE);
        String name = prefs.getString("name", "");//"No name defined" is the default value.
        textView.setText(name);

        SharedPreferences pref = getSharedPreferences("modename", MODE_PRIVATE);
        String modename = pref.getString("name", "");//"No name defined" is the default value.
        modechange.setText(modename);

        SharedPreferences sharedPreferences=getSharedPreferences("settings",MODE_PRIVATE);
        String language=sharedPreferences.getString("app_long","");
        //  setlocale(language);
        languagee.setText(language);

        arrayList=new ArrayList<>();

        arrayList.add("Andaman and Nicobar Islands");
        arrayList.add("Andhra Pradesh");
        arrayList.add("Arunachal Pradesh");
        arrayList.add("Assam");
        arrayList.add("Bihar");
        arrayList.add("Chandigarh");
        arrayList.add("Chhattisgarh");
        arrayList.add("Dadra and nagar Haveli");
        arrayList.add("Daman and Diu");
        arrayList.add("Delhi");
        arrayList.add("Goa");
        arrayList.add("Gujarat");
        arrayList.add("Haryana");
        arrayList.add("Himachal Pradesh");
        arrayList.add("Jammu and Kashmir");
        arrayList.add("Jharkhand");
        arrayList.add("Karanataka");
        arrayList.add("Kerala");
        arrayList.add("Lakhadweep");
        arrayList.add("Madhya Pradesh");
        arrayList.add("Maharashtra");
        arrayList.add("Manipur");
        arrayList.add("Meghalaya");
        arrayList.add("Mizoram");
        arrayList.add("Nagaland");
        arrayList.add("Odisha");
        arrayList.add("Puducherry");
        arrayList.add("Panjab");
        arrayList.add("Rajasthan");
        arrayList.add("Sikkim");
        arrayList.add("Tamil Nadu");
        arrayList.add("Telangana");
        arrayList.add("Tripura");
        arrayList.add("Uttar pradesh");
        arrayList.add("Uttarakhand");
        arrayList.add("West Bengal");

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog = new Dialog(SettingActivity.this);
                dialog.setContentView(R.layout.dialog_searchable_spinner);
//              dialog.getWindow().setLayout(650, 1400);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                EditText editText = dialog.findViewById(R.id.edit_text);
                ListView listView = dialog.findViewById(R.id.lv_view);
                ImageView selectoptioncancle=dialog.findViewById(R.id.cancle);
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(SettingActivity.this, android.R.layout.simple_list_item_1,arrayList);
                listView.setAdapter(arrayAdapter);

                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        arrayAdapter.getFilter().filter(s);

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                        textView.setText(arrayAdapter.getItem(i));
                        SharedPreferences.Editor editor = getSharedPreferences("statename", MODE_PRIVATE).edit();
                        editor.putString("name", arrayAdapter.getItem(i));
                        editor.apply();
                        dialog.dismiss();
                    }
                });
                selectoptioncancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    private void setOnClickListener() {

        modechange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog2 = new Dialog(SettingActivity.this);
                dialog2.setContentView(R.layout.layoutmodechnage);
                dialog2.show();

                TextView on=dialog2.findViewById(R.id.on);
                TextView off=dialog2.findViewById(R.id.off);
                TextView auto=dialog2.findViewById(R.id.auto);
                LinearLayout llauto=dialog2.findViewById(R.id.ll_auto);
                LinearLayout llon=dialog2.findViewById(R.id.ll_on);
                LinearLayout lloff=dialog2.findViewById(R.id.ll_off);
                ImageView modecancle=dialog2.findViewById(R.id.modecancle);

                llauto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences.Editor editor = getSharedPreferences("modename", MODE_PRIVATE).edit();
                        editor.putString("name",modechange.getText().toString());
                        editor.apply();
                    }
                });
                llon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences.Editor editor = getSharedPreferences("modename", MODE_PRIVATE).edit();
                        editor.putString("name",modechange.getText().toString());
                        editor.apply();
                    }
                });
                lloff.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences.Editor editor = getSharedPreferences("modename", MODE_PRIVATE).edit();
                        editor.putString("name",modechange.getText().toString());
                        editor.apply();
                    }
                });
                auto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences.Editor editor = getSharedPreferences("modename", MODE_PRIVATE).edit();
                        editor.putString("name",modechange.getText().toString());
                        editor.apply();
                    }
                });
                on.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        SharedPreferences.Editor editor = getSharedPreferences("modename", MODE_PRIVATE).edit();
                        editor.putString("name",modechange.getText().toString());
                        editor.apply();
                    }
                });
                off.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        SharedPreferences.Editor editor = getSharedPreferences("modename", MODE_PRIVATE).edit();
                        editor.putString("name",modechange.getText().toString());
                        editor.apply();
                    }
                });
                modecancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog2.dismiss();
                    }
                });
            }
        });

        languagee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2 = new Dialog(SettingActivity.this);
                dialog2.setContentView(R.layout.languagechnage);
                dialog2.show();
//              final String language[]={"Engligh","Gujrati","Hindi"};
//              dialog.setTitle("select language");
                TextView gujrati=dialog2.findViewById(R.id.gujrati);
                TextView hindi=dialog2.findViewById(R.id.Hindi);
                TextView english=dialog2.findViewById(R.id.English);
                ImageView languge=dialog2.findViewById(R.id.languagecancle);

                gujrati.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        setlocale("gu");
                        recreate();
                        startActivity(new Intent(getApplicationContext(), SecondActivity.class));
                        finish();
                    }
                });
                hindi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setlocale("hi");
                        recreate();
                        startActivity(new Intent(getApplicationContext(), SecondActivity.class));
                        finish();
                    }
                });
                english.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setlocale("en");
                        recreate();
                        startActivity(new Intent(getApplicationContext(), SecondActivity.class));
                        finish();
                    }
                });
                languge.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog2.dismiss();
                    }
                });
            }
        });

        from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FormsActivity.class));
                finish();
            }
        });

        processdrivinglicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ProcessDrivingLicenceActivity.class));
                finish();
            }
        });
        RTOoffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RTOofficeActivity.class));
                finish();
            }
        });
        ll_contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ContactusActivity.class));
                finish();
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String appLink = "https://play.google.com/store/apps/details?id=com.example.rto";
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, " Share 'RTO Exam'" +appLink);
                startActivity(Intent.createChooser(shareIntent, "Share 'RTO Exam'"));
            }
        });
        adddrivingschool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddDrivingSchoolActivity.class));
                finish();
            }
        });

        disclaimer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(SettingActivity.this);
                dialog.setContentView(R.layout.disclamer);

                dialog.show();

                Button button=dialog.findViewById(R.id.close);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(SettingActivity.this);
                dialog.setContentView(R.layout.adddailog);

                dialog.show();

                ImageView button=dialog.findViewById(R.id.close);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                Button adddriving=dialog.findViewById(R.id.adddriving);

                adddriving.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), AddDrivingSchoolActivity.class));
                        finish();
                    }
                });
            }
        });
    }

    private void setlocale(String language) {

        String lang="";
        if (language=="gu"){
            lang="Gujrati";
        }else if (language=="hi"){
            lang="Hindi";
        }else {
            lang="English";
        }

        Locale locale= new Locale(language);
        Locale.setDefault(locale);

        Configuration configuration=new Configuration();
        configuration.locale=locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor=getSharedPreferences("settings",MODE_PRIVATE).edit();
        editor.putString("app_long",lang);
        editor.apply();

    }
    public void loadlocal(){
//        SharedPreferences sharedPreferences=getSharedPreferences("settings",MODE_PRIVATE);
//        String language=sharedPreferences.getString("app_long","");
//        Log.d("TAG", "loadlocal: "+language);
//        setlocale(language);
//        languagee.setText(language);

    }

    public void back(View view) {
      onBackPressed();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), SecondActivity.class));
        finish();
    }

    public void privcypolicy(View view) {
        startActivity(new Intent(getApplicationContext(), PrivacypolicyActivity.class));
        finish();
    }

    public void termsconditions(View view) {
        startActivity(new Intent(getApplicationContext(), TermsandCondtionActivity.class));
        finish();
    }

}