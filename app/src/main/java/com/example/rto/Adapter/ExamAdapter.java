package com.example.rto.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rto.Model.ExamquestionModel;
import com.example.rto.PracticeActivity;
import com.example.rto.R;
import com.example.rto.StartExamActivity;

import java.util.ArrayList;

public class ExamAdapter  extends RecyclerView.Adapter<ExamAdapter.ViewHolder> {

    Activity context;

    ArrayList<ExamquestionModel> ExamQuestion;

    private int correctScore = 0;
    private int incorrectScore = 0;
    int selectedOption = -1;
    int isclicked=0;

    public ExamAdapter(Activity context, ArrayList<ExamquestionModel> examQuestion) {
        this.context = context;
        this. ExamQuestion = examQuestion;
    }
    @NonNull
    @Override
    public ExamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.examquestion,parent,false);
        return new ExamAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ExamAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.question.setText(ExamQuestion.get(position).getQuestion());
        Glide.with(context).load(ExamQuestion.get(position).getQuestionimage()).into(holder.questionimage);
        holder.option1.setText(ExamQuestion.get(position).getOption1());
        holder.option2.setText(ExamQuestion.get(position).getOption2());
        holder.option3.setText(ExamQuestion.get(position).getOption3());
        Glide.with(context).load(ExamQuestion.get(position).getOption1image()).into(holder.option_1);
        Glide.with(context).load(ExamQuestion.get(position).getOption2image()).into(holder.option_2);
        Glide.with(context).load(ExamQuestion.get(position).getOption3image()).into(holder.option_3);

        if (ExamQuestion.get(position).getOption1().equals("")){

            holder.option1.setVisibility(View.GONE);
            holder.option_1.setVisibility(View.VISIBLE);
        }
        else{
            holder.option_1.setVisibility(View.GONE);
            holder.option1.setVisibility(View.VISIBLE);
        }
        if (ExamQuestion.get(position).getOption2().equals("")){

            holder.option2.setVisibility(View.GONE);
            holder.option_2.setVisibility(View.VISIBLE);
        }
        else{
            holder.option_2.setVisibility(View.GONE);
            holder.option2.setVisibility(View.VISIBLE);
        }
        if (ExamQuestion.get(position).getOption3().equals("")){

            holder.option3.setVisibility(View.GONE);
            holder.option_3.setVisibility(View.VISIBLE);
        }
        else{
            holder.option_3.setVisibility(View.GONE);
            holder.option3.setVisibility(View.VISIBLE);
        }
        if (ExamQuestion.get(position).getQuestionimage().equals("")){

            holder.questionimage.setVisibility(View.GONE);
        }
        else{
            holder.questionimage.setVisibility(View.VISIBLE);
        }
        holder.op1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                    resetOptionColors(holder);
                    holder.op1.setBackgroundColor(Color.YELLOW);
                    isclicked=1;


                selectedOption = 1;
            }
        });

        holder.op2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                resetOptionColors(holder);
                holder.op2.setBackgroundColor(Color.YELLOW);
                isclicked=2;

                selectedOption = 2;
            }
        });
        holder.op3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                resetOptionColors(holder);
                holder.op3.setBackgroundColor(Color.YELLOW);

                isclicked=3;

                selectedOption = 3;
            }
        });

            StartExamActivity.next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isclicked != 0) {
                        if (StartExamActivity.currentQuestionIndex < ExamQuestion.size() - 1) {
                            StartExamActivity.currentQuestionIndex++;
                            StartExamActivity.viewPager.setCurrentItem(StartExamActivity.currentQuestionIndex);
                        }
                        int correctOption = ExamQuestion.get(StartExamActivity.currentQuestionIndex).getCorrectanswer();

                        if (correctOption == isclicked) {

                            correctScore++;

                        } else {

                            incorrectScore++;

                        }

                        updateScores();
                        isclicked=0;
                        if (ExamQuestion.size()-1==position){
                            Log.d("TAG", "onClick: "+ExamQuestion.size()+" "+position);
                            Toast.makeText(context, "absnecifrcnr", Toast.LENGTH_SHORT).show();
                        }

                    }

                }

            });

    }
    private void resetOptionColors(ViewHolder holder) {
        holder.op1.setBackgroundColor(Color.WHITE);
        holder.op2.setBackgroundColor(Color.WHITE);
        holder.op3.setBackgroundColor(Color.WHITE);
    }
    public void updateScores() {
        TextView correctScoreTextView = ((Activity) context).findViewById(R.id.currectans);
        TextView incorrectScoreTextView = ((Activity) context).findViewById(R.id.wrongans);

        correctScoreTextView.setText("" + correctScore);
        incorrectScoreTextView.setText(" " + incorrectScore);
    }

    @Override
    public int getItemCount() {
        return ExamQuestion.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView question,option1,option2,option3,correctScore,incorrectScore;
        ImageView option_1,option_2,option_3,imageView,questionimage;
        LinearLayout linearLayout;
        LinearLayout op1, op2, op3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            question=itemView.findViewById(R.id.practicequestion);
            questionimage=itemView.findViewById(R.id.questionimage);
            option1=itemView.findViewById(R.id.option1);
            option2=itemView.findViewById(R.id.option2);
            option3=itemView.findViewById(R.id.option3);
            option_1=itemView.findViewById(R.id.option1image);
            option_2=itemView.findViewById(R.id.option2image);
            option_3=itemView.findViewById(R.id.option3image);
            imageView=itemView.findViewById(R.id.iv_imagesave);
            linearLayout= itemView.findViewById(R.id.linearLayoutquestion);
            op1 = itemView.findViewById(R.id.ll_option1);
            op2 = itemView.findViewById(R.id.ll_option2);
            op3 = itemView.findViewById(R.id.ll_option3);

        }
    }

}
