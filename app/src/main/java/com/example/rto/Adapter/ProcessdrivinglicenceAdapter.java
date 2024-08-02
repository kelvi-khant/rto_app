package com.example.rto.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rto.Model.ProcessdrivinglicenceModel;
import com.example.rto.Model.RTOofficeModel;
import com.example.rto.R;

import java.util.ArrayList;

public class ProcessdrivinglicenceAdapter extends RecyclerView.Adapter<ProcessdrivinglicenceAdapter.Viewholder> {
    ArrayList<ProcessdrivinglicenceModel> list;
    Context context;

    public ProcessdrivinglicenceAdapter(ArrayList<ProcessdrivinglicenceModel> list,Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ProcessdrivinglicenceAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rtooffices,parent,false);
        return new Viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ProcessdrivinglicenceAdapter.Viewholder holder, @SuppressLint("RecyclerView") int position) {

        ProcessdrivinglicenceModel models=list.get(position);
        holder.title.setText(models.getText());

        holder.imageView.setImageResource(R.drawable.back);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (list.get(position).getPic()) {
                    holder.defination.setText(models.getDefination());
                    holder.imageView.setImageResource(R.drawable.back);
                    holder.title.setVisibility(View.VISIBLE);
                    holder.defination.setVisibility(View.GONE);
                    list.get(position).setPic(false);
                } else {
                    holder.imageView.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                    holder.defination.setText(models.getDefination());
                    holder.defination.setVisibility(View.VISIBLE);
                    holder.title.setVisibility(View.VISIBLE);
                    list.get(position).setPic(true);
                }
           }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView title,defination;
        ImageView imageView;
        LinearLayout linearLayout;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_rtoooficename);
            defination = itemView.findViewById(R.id.tv_defination);
            imageView   = itemView.findViewById(R.id.imageview);
            linearLayout=itemView.findViewById(R.id.processdrivinglicensefrom);
        }
    }
}
