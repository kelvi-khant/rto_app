package com.example.rto.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rto.Adapter.MyQuestionAdapter;
import com.example.rto.Adapter.QuestionBankAdapter;
import com.example.rto.Model.QuestionBankModel;
import com.example.rto.R;
import com.example.rto.SecondActivity;

import java.util.ArrayList;


public class QuestionFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<QuestionBankModel> dataholder;
    View openmenu;
    TextView nameTextView;
    ConstraintLayout constraintLayout;

   public static QuestionFragment questionFragment;

    public QuestionFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


       View view= inflater.inflate(R.layout.fragment_question, container, false);

       constraintLayout=view.findViewById(R.id.nobookmark);
        questionFragment = this;

       recyclerView=view.findViewById(R.id.recyclerView);
        nameTextView = view.findViewById(R.id.tv_nameTextView);
        ImageView openOptionsMenuButton = view.findViewById(R.id.iv_openOptionsMenuButton);

       recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


       dataholder=new ArrayList<>();

        QuestionBankModel questionBankModel1=new QuestionBankModel(getResources().getString(R.string.Question1),getResources().getString(R.string.ans1),false);
        dataholder.add(questionBankModel1);

        QuestionBankModel questionBankModel2=new QuestionBankModel(getResources().getString(R.string.Question2),getResources().getString(R.string.ans2),false);
        dataholder.add(questionBankModel2);

        QuestionBankModel questionBankModel3=new QuestionBankModel(getResources().getString(R.string.Question3),getResources().getString(R.string.ans3),false);
        dataholder.add(questionBankModel3);

        QuestionBankModel questionBankModel4=new QuestionBankModel(getResources().getString(R.string.Question4),getResources().getString(R.string.ans4),false);
        dataholder.add(questionBankModel4);

        QuestionBankModel questionBankModel5=new QuestionBankModel(getResources().getString(R.string.Question5),getResources().getString(R.string.ans5),false);
        dataholder.add(questionBankModel5);

        QuestionBankModel questionBankModel6=new QuestionBankModel(getResources().getString(R.string.Question6),getResources().getString(R.string.ans6),false);
        dataholder.add(questionBankModel6);

        QuestionBankModel questionBankModel7=new QuestionBankModel(getResources().getString(R.string.Question7),getResources().getString(R.string.ans7),false);
        dataholder.add(questionBankModel7);

        QuestionBankModel questionBankModel8=new QuestionBankModel(getResources().getString(R.string.Question8),getResources().getString(R.string.ans8),false);
        dataholder.add(questionBankModel8);

        recyclerView.setAdapter(new MyQuestionAdapter(dataholder));
        constraintLayout.setVisibility(View.GONE);
       return view;
    }

    public void getBookmark() {

            ArrayList<QuestionBankModel> bookmarks = new ArrayList<>();
            for (int i = 0; i < dataholder.size(); i++) {

                if (dataholder.get(i).isBookmark()) {
                    bookmarks.add(dataholder.get(i));
                }
            }
            recyclerView.setAdapter(new MyQuestionAdapter(bookmarks));

            if (bookmarks.size()==0){
                recyclerView.setVisibility(View.GONE);
                Toast.makeText(getContext(), "no bookmark", Toast.LENGTH_SHORT).show();
                constraintLayout.setVisibility(View.VISIBLE);
            }else{
                recyclerView.setVisibility(View.VISIBLE);
                constraintLayout.setVisibility(View.GONE);
                Toast.makeText(getContext(), "bookmark", Toast.LENGTH_SHORT).show();
            }
    }
    public void getall(){
        recyclerView.setVisibility(View.VISIBLE);
        constraintLayout.setVisibility(View.GONE);
        Toast.makeText(getContext(), "bookmarks", Toast.LENGTH_SHORT).show();
        recyclerView.setAdapter(new MyQuestionAdapter(dataholder));
    }
}