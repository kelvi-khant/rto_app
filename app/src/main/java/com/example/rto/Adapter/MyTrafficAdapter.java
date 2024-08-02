package com.example.rto.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rto.Model.QuestionBankModel;
import com.example.rto.Model.TrafficSignModel;
import com.example.rto.R;

import java.util.ArrayList;

public class MyTrafficAdapter extends  RecyclerView.Adapter<MyTrafficAdapter.ViewHolder>{

    private ArrayList<TrafficSignModel> TrafficSignlist;

    public MyTrafficAdapter(ArrayList<TrafficSignModel> TrafficSignlist) {
        this.TrafficSignlist = TrafficSignlist;
    }

    @NonNull
    @Override
    public MyTrafficAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.trafficsign,parent,false);
        return new MyTrafficAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyTrafficAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.number.setText(TrafficSignlist.get(position).getNumber());
        holder.imageView1.setImageResource(TrafficSignlist.get(position).getTrafficsign());
        holder.trafficsignname.setText(TrafficSignlist.get(position).getTrafficsignname());
        if (TrafficSignlist.get(position).isBookmark())
        {
            holder.imageView.setImageResource(R.drawable.bookmarkoff);
        }
        else
        {
            holder.imageView.setImageResource(R.drawable.bookmark);
        }
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TrafficSignlist.get(position).isBookmark())
                {
                    TrafficSignlist.get(position).setBookmark(false);
                }
                else
                {
                    TrafficSignlist.get(position).setBookmark(true);
                }
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return  TrafficSignlist.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView trafficsignname,number;
        ImageView imageView,imageView1;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            number=itemView.findViewById(R.id.tv_number);
            trafficsignname=itemView.findViewById(R.id.tv_trafficsignname);
            imageView1=itemView.findViewById(R.id.iv_trafficsign);
            imageView=itemView.findViewById(R.id.iv_bookmark);
            linearLayout= itemView.findViewById(R.id.ll_lineartraffiic);

        }
    }
}
