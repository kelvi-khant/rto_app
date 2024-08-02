package com.example.rto.Model;

public class QuestionBankModel {

    boolean isBookmark;
    String question;
    String ans;

    public QuestionBankModel(String question, String ans,boolean isBookmark) {
        this.question = question;
        this.ans = ans;
        this.isBookmark = isBookmark;
    }

    public boolean isBookmark() {
        return isBookmark;
    }

    public void setBookmark(boolean bookmark) {
        isBookmark = bookmark;
    }



    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
}
