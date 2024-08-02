package com.example.rto.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rto.Model.RTOofficeModel;
import com.example.rto.R;
import com.example.rto.RTOofficeActivity;

import java.util.ArrayList;

public class RTOofficeAdapter extends RecyclerView.Adapter<RTOofficeAdapter.ViewHolder> {
    ArrayList<RTOofficeModel> list;

    public RTOofficeAdapter(ArrayList<RTOofficeModel> list, Context context) {
        this.list = list;
        this.context = context;
    }
    Context context;
    @NonNull
    @Override
    public RTOofficeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view= LayoutInflater.from(context).inflate(R.layout.rtooffices,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RTOofficeAdapter.ViewHolder holder, int position) {
        RTOofficeModel models=list.get(position);
        holder.title.setText(models.getText());
        holder.imageView.setImageResource(models.getPic());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_rtoooficename);
            imageView   = itemView.findViewById(R.id.imageview);
        }
    }
}
