package com.example.rto.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rto.Adapter.MyQuestionAdapter;
import com.example.rto.Adapter.MyTrafficAdapter;
import com.example.rto.Model.QuestionBankModel;
import com.example.rto.Model.TrafficSignModel;
import com.example.rto.R;

import java.util.ArrayList;


public class TrafficSignsFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<TrafficSignModel> TrafficSignlist;
    ConstraintLayout constraintLayout;
    public static TrafficSignsFragment trafficSignsFragment;
    public TrafficSignsFragment() {
        // Required empty public constructor
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_traffic_signs, container, false);
        recyclerView=view.findViewById(R.id.recyclerView);
        constraintLayout=view.findViewById(R.id.nobookmark);
        trafficSignsFragment=this;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        TrafficSignlist=new ArrayList<>();

        TrafficSignModel trafficSignModel1=new TrafficSignModel("1.",R.drawable.stop,false,getResources().getString(R.string.trafficname1));
        TrafficSignlist.add(trafficSignModel1);

        TrafficSignModel trafficSignModel2=new TrafficSignModel("2.",R.drawable.giveway,false,getResources().getString(R.string.trafficname2));
        TrafficSignlist.add(trafficSignModel2);

        TrafficSignModel trafficSignModel3=new TrafficSignModel("3.",R.drawable.noentry,false,getResources().getString(R.string.trafficname3));
        TrafficSignlist.add(trafficSignModel3);

        TrafficSignModel trafficSignModel4=new TrafficSignModel("4.",R.drawable.noenterycarbike,false,getResources().getString(R.string.trafficname4));
        TrafficSignlist.add(trafficSignModel4);

        TrafficSignModel trafficSignModel5=new TrafficSignModel("5.",R.drawable.truks,false,getResources().getString(R.string.trafficname5));
        TrafficSignlist.add(trafficSignModel5);

        TrafficSignModel trafficSignModel6=new TrafficSignModel("6.",R.drawable.bulllock,false,getResources().getString(R.string.trafficname6));
        TrafficSignlist.add(trafficSignModel6);

        TrafficSignModel trafficSignModel7=new TrafficSignModel("7.",R.drawable.firstaid,false,getResources().getString(R.string.trafficname7));
        TrafficSignlist.add(trafficSignModel7);

        TrafficSignModel trafficSignModel8=new TrafficSignModel("8.",R.drawable.pedestrianprohibited,false,getResources().getString(R.string.trafficname8));
        TrafficSignlist.add(trafficSignModel8);

        TrafficSignModel trafficSignModel9=new TrafficSignModel("9.",R.drawable.noturnright,false,getResources().getString(R.string.trafficname9));
        TrafficSignlist.add(trafficSignModel9);

        TrafficSignModel trafficSignModel10=new TrafficSignModel("10.",R.drawable.uturn,false,getResources().getString(R.string.trafficname10));
        TrafficSignlist.add(trafficSignModel10);

        TrafficSignModel trafficSignModel11=new TrafficSignModel("11.",R.drawable.speedlimit,false,getResources().getString(R.string.trafficname11));
        TrafficSignlist.add(trafficSignModel11);

        TrafficSignModel trafficSignModel12=new TrafficSignModel("12.",R.drawable.noparking,false,getResources().getString(R.string.trafficname12));
        TrafficSignlist.add(trafficSignModel12);

        TrafficSignModel trafficSignModel13=new TrafficSignModel("13.",R.drawable.nostopping,false,getResources().getString(R.string.trafficname13));
        TrafficSignlist.add(trafficSignModel13);

        TrafficSignModel trafficSignModel14=new TrafficSignModel("14.",R.drawable.turnleft,false,getResources().getString(R.string.trafficname14));
        TrafficSignlist.add(trafficSignModel14);

        TrafficSignModel trafficSignModel15=new TrafficSignModel("15.",R.drawable.ahead,false,getResources().getString(R.string.trafficname15));
        TrafficSignlist.add(trafficSignModel15);

        TrafficSignModel trafficSignModel16=new TrafficSignModel("16.",R.drawable.compulsoryright,false,getResources().getString(R.string.trafficname16));
        TrafficSignlist.add(trafficSignModel16);

        TrafficSignModel trafficSignModel17=new TrafficSignModel("17.",R.drawable.compulsoryleft,false,getResources().getString(R.string.trafficname17));
        TrafficSignlist.add(trafficSignModel17);

        TrafficSignModel trafficSignModel18=new TrafficSignModel("18.",R.drawable.keepleft,false,getResources().getString(R.string.trafficname18));
        TrafficSignlist.add(trafficSignModel18);

        TrafficSignModel trafficSignModel19=new TrafficSignModel("19.",R.drawable.turnright,false,getResources().getString(R.string.trafficname19));
        TrafficSignlist.add(trafficSignModel19);

        TrafficSignModel trafficSignModel20=new TrafficSignModel("20.",R.drawable.petrolstation,false,getResources().getString(R.string.trafficname20));
        TrafficSignlist.add(trafficSignModel20);

        TrafficSignModel trafficSignModel21=new TrafficSignModel("21.",R.drawable.curveright,false,getResources().getString(R.string.trafficname21));
        TrafficSignlist.add(trafficSignModel21);

        TrafficSignModel trafficSignModel22=new TrafficSignModel("22.",R.drawable.roundabout,false,getResources().getString(R.string.trafficname22));
        TrafficSignlist.add(trafficSignModel22);

        recyclerView.setAdapter(new MyTrafficAdapter(TrafficSignlist));
        constraintLayout.setVisibility(View.GONE);
        return view;
    }
    public void getBookmark() {


        ArrayList<TrafficSignModel> bookmarks = new ArrayList<>();
        for (int i = 0; i < TrafficSignlist.size(); i++) {

            if (TrafficSignlist.get(i).isBookmark()) {
                bookmarks.add(TrafficSignlist.get(i));
            }

        }
        recyclerView.setAdapter(new MyTrafficAdapter(bookmarks));
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
        recyclerView.setAdapter(new MyTrafficAdapter(TrafficSignlist));
    }
}