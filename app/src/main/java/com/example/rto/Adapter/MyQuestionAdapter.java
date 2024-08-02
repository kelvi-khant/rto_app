package com.example.rto.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rto.Model.QuestionBankModel;
import com.example.rto.R;

import java.util.ArrayList;
import java.util.List;

public class MyQuestionAdapter extends  RecyclerView.Adapter<MyQuestionAdapter.ViewHolder>{

    private ArrayList<QuestionBankModel> dataholder;


    public MyQuestionAdapter(ArrayList<QuestionBankModel> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public MyQuestionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.questionans,parent,false);
        return new ViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull MyQuestionAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.question.setText(dataholder.get(position).getQuestion());
        holder.ans.setText(dataholder.get(position).getAns());

        if (dataholder.get(position).isBookmark())
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
                if (dataholder.get(position).isBookmark())
                {
                    dataholder.get(position).setBookmark(false);
                }
                else
                {
                    dataholder.get(position).setBookmark(true);
                }

                notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView question,ans;
        ImageView imageView;
         LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            question=itemView.findViewById(R.id.txtQuestion);
            ans=itemView.findViewById(R.id.txtAnswer);
            imageView=itemView.findViewById(R.id.imageSave);
            linearLayout= itemView.findViewById(R.id.ll_question);

        }
    }
}
