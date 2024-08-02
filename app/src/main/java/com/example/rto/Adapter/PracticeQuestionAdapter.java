package com.example.rto.Adapter;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import static com.google.android.gms.common.internal.ImagesContract.URL;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.rto.Model.PracticeQuestionModel;
import com.example.rto.PracticeActivity;
import com.example.rto.R;

import java.util.ArrayList;
public class PracticeQuestionAdapter extends RecyclerView.Adapter<PracticeQuestionAdapter.ViewHolder> {

    Activity context;

    ArrayList<PracticeQuestionModel> practiceQuestion;
    private int correctScore = 0;
    private int incorrectScore = 0;
    public  static int selectedOption = -1;
    private boolean questionAnswered = false;
    boolean optionSelected = false;

    public PracticeQuestionAdapter(Activity context, ArrayList<PracticeQuestionModel> practiceQuestion) {
        this.context = context;
        this.practiceQuestion = practiceQuestion;
    }

    @NonNull
    @Override
    public PracticeQuestionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.practicequestion,parent,false);
        return new ViewHolder(view);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.question.setText(practiceQuestion.get(position).getQuestion());
        Glide.with(context).load(practiceQuestion.get(position).getQuestionimage()).into(holder.questionimage);
        holder.option1.setText(practiceQuestion.get(position).getOption1());
        holder.option2.setText(practiceQuestion.get(position).getOption2());
        holder.option3.setText(practiceQuestion.get(position).getOption3());
        Glide.with(context).load(practiceQuestion.get(position).getOption1image()).into(holder.option_1);
        Glide.with(context).load(practiceQuestion.get(position).getOption2image()).into(holder.option_2);
        Glide.with(context).load(practiceQuestion.get(position).getOption3image()).into(holder.option_3);


        if (practiceQuestion.get(position).getOption1().equals("")){

            holder.option1.setVisibility(View.GONE);
            holder.option_1.setVisibility(View.VISIBLE);
            }
        else{
            holder.option_1.setVisibility(View.GONE);
            holder.option1.setVisibility(View.VISIBLE);
            }
        if (practiceQuestion.get(position).getOption2().equals("")){

            holder.option2.setVisibility(View.GONE);
            holder.option_2.setVisibility(View.VISIBLE);
        }
        else{
            holder.option_2.setVisibility(View.GONE);
            holder.option2.setVisibility(View.VISIBLE);
        }
        if (practiceQuestion.get(position).getOption3().equals("")){

            holder.option3.setVisibility(View.GONE);
            holder.option_3.setVisibility(View.VISIBLE);
        }
        else{
            holder.option_3.setVisibility(View.GONE);
            holder.option3.setVisibility(View.VISIBLE);
        }
        if (practiceQuestion.get(position).getQuestionimage().equals("")){

            holder.questionimage.setVisibility(View.GONE);
        }
        else{
            holder.questionimage.setVisibility(View.VISIBLE);
        }
        if (practiceQuestion.get(position).isBookmark())
        {
            holder.imageView.setImageResource(R.drawable.bookmarkoff);
        }
        else
        {
            holder.imageView.setImageResource(R.drawable.bookmark);
        }

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (practiceQuestion.get(position).isBookmark())
                {
                    practiceQuestion.get(position).setBookmark(false);
                }
                else
                {
                    practiceQuestion.get(position).setBookmark(true);
                }
                notifyDataSetChanged();
            }
        });

        holder.op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  if (!questionAnswered) {

                    int correctOption = practiceQuestion.get(PracticeActivity.currentQuestionIndex).getCorrectanswer();

                    if (correctOption == 1) {

                        holder.op1.setBackgroundColor(Color.GREEN);
                        correctScore++;

                    } else {

                        int correctOption1 = practiceQuestion.get(PracticeActivity.currentQuestionIndex).getCorrectanswer();
                        if (correctOption1 == 1) {
                            holder.op1.setBackgroundColor(Color.GREEN);
                        } else if (correctOption == 2) {
                            holder.op2.setBackgroundColor(Color.GREEN);
                        } else if (correctOption == 3) {
                            holder.op3.setBackgroundColor(Color.GREEN);
                        }

                        holder.op1.setBackgroundColor(Color.RED);
                        incorrectScore++;
                    }
                  //  questionAnswered = true;
                    updateScores();
              //  }


            }
        });
        holder.op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   if (!questionAnswered) {

                    int correctOption = practiceQuestion.get(PracticeActivity.currentQuestionIndex).getCorrectanswer();

                    if (correctOption == 2) {

                        holder.op2.setBackgroundColor(Color.GREEN);
                        correctScore++;

                    } else {
                        int correctOption1 = practiceQuestion.get(PracticeActivity.currentQuestionIndex).getCorrectanswer();
                        if (correctOption1 == 1) {
                            holder.op1.setBackgroundColor(Color.GREEN);
                        } else if (correctOption == 2) {
                            holder.op2.setBackgroundColor(Color.GREEN);
                        } else if (correctOption == 3) {
                            holder.op3.setBackgroundColor(Color.GREEN);
                        }
                        holder.op2.setBackgroundColor(Color.RED);
                        incorrectScore++;
                    }
                  //  questionAnswered = true;

                    updateScores();
                //}


            }
        });
        questionAnswered = false;
        holder.op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  if (!questionAnswered) {

                    int correctOption = practiceQuestion.get(PracticeActivity.currentQuestionIndex).getCorrectanswer();

                    if (correctOption == 3) {

                        holder.op3.setBackgroundColor(Color.GREEN);
                        correctScore++;

                    } else {
                        int correctOption1 = practiceQuestion.get(PracticeActivity.currentQuestionIndex).getCorrectanswer();
                        if (correctOption1 == 1) {
                            holder.op1.setBackgroundColor(Color.GREEN);
                        } else if (correctOption == 2) {
                            holder.op2.setBackgroundColor(Color.GREEN);
                        } else if (correctOption == 3) {
                            holder.op3.setBackgroundColor(Color.GREEN);
                        }
                        holder.op3.setBackgroundColor(Color.RED);
                        incorrectScore++;
                    }
                    updateScores();
                   // questionAnswered = true;

              //  }

           }
        });

    }
    public void updateScores() {
        TextView correctScoreTextView = ((Activity) context).findViewById(R.id.currectans);
        TextView incorrectScoreTextView = ((Activity) context).findViewById(R.id.wrongans);
        correctScoreTextView.setText("" + correctScore);
        incorrectScoreTextView.setText(" " + incorrectScore);
    }

    @Override
    public int getItemCount() {
        return practiceQuestion.size();
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


