package com.example.rto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

public class SecondActivity extends AppCompatActivity {

    TextView chnagestateandlanguage,textView,state,chnagelanguage,settingtextview;
    LinearLayout chnagestate,language;
    Dialog dialog,dialog2;
    ArrayList<String> arrayList;
    String language1;
    String name;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initVal();
        setLocalData();
        setOnClickListener();

    }

    private void initVal() {
        chnagestateandlanguage=findViewById(R.id.dropdownstate);
        textView=findViewById(R.id.dropdownstate);
        settingtextview=findViewById(R.id.dropdownstate);
    }

    private void setLocalData() {
        loadlocal();
        SharedPreferences prefs = getSharedPreferences("statename", MODE_PRIVATE);
        name = prefs.getString("name", "");//"No name defined" is the default value.
        textView.setText(name+"("+language1+")");
    }

    private void setOnClickListener() {
        chnagestateandlanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2 = new Dialog(SecondActivity.this);
                dialog2.setContentView(R.layout.stateandlanguage);
                dialog2.show();

                ImageView cancle=dialog2.findViewById(R.id.cancle);
                chnagestate=dialog2.findViewById(R.id.chnagestate);
                language=dialog2.findViewById(R.id.language);
                state=dialog2.findViewById(R.id.state);

                cancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog2.dismiss();
                    }
                });

                chnagelanguage=dialog2.findViewById(R.id.chnagelanguage);

                loadlocal();

                chnagestate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog = new Dialog(SecondActivity.this);
                        dialog.setContentView(R.layout.dialog_searchable_spinner);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();

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

                        EditText editText = dialog.findViewById(R.id.edit_text);
                        ListView listView = dialog.findViewById(R.id.lv_view);
                        ImageView selectoptioncancle=dialog.findViewById(R.id.cancle);

                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(SecondActivity.this, android.R.layout.simple_list_item_1,arrayList);
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
                                state.setText(arrayAdapter.getItem(i));
                                SharedPreferences.Editor editor = getSharedPreferences("statename", MODE_PRIVATE).edit();
                                editor.putString("name", arrayAdapter.getItem(i));
                                editor.apply();
                                dialog.dismiss();

                                dialog2 = new Dialog(SecondActivity.this);
                                dialog2.setContentView(R.layout.languagechnage);
                                dialog2.show();

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
                        selectoptioncancle.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                dialog.dismiss();

                            }
                        });
                    }
                });

                language.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog2 = new Dialog(SecondActivity.this);
                        dialog2.setContentView(R.layout.languagechnage);
                        dialog2.show();

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
            }
        });
    }

    private void setlocale(String language) {

        Locale locale= new Locale(language);
        Locale.setDefault(locale);

        Configuration configuration=new Configuration();
        configuration.locale=locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor=getSharedPreferences("settings",MODE_PRIVATE).edit();
        editor.putString("app_long",language);
        editor.apply();
    }

    public void loadlocal(){
        SharedPreferences sharedPreferences=getSharedPreferences("settings",MODE_PRIVATE);
        language1=sharedPreferences.getString("app_long","");
        setlocale(language1);
        textView.setText(name+"("+language1+")");
    }

    public void share(View view) {
        String appLink = "https://play.google.com/store/apps/details?id=com.example.rto";
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, " Share 'RTO Exam'" +appLink);
        startActivity(Intent.createChooser(shareIntent, "Share 'RTO Exam'"));
    }

    public void Exam(View view) {
        startActivity(new Intent(getApplicationContext(), ExamActivity.class));
        finish();
    }

    public void settings(View view) {
        startActivity(new Intent(getApplicationContext(), SettingActivity.class));
        finish();
    }

    public void Questionbank(View view) {
        startActivity(new Intent(getApplicationContext(), QuestionBankActivity.class));
        finish();
    }

    public void Practice(View view) {
        startActivity(new Intent(getApplicationContext(), PracticeActivity.class));
        finish();
    }

    public void drivingschool(View view) {
        startActivity(new Intent(getApplicationContext(), DrivingSchoolActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();

        Dialog dialog = new Dialog(SecondActivity.this);
        dialog.setContentView(R.layout.appclose);
        Button no =dialog.findViewById(R.id.btnok);
        Button yes =dialog.findViewById(R.id.btnyes);

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
        dialog.show();
    }
}