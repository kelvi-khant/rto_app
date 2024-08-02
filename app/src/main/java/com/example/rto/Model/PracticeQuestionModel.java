package com.example.rto.Model;

public class PracticeQuestionModel {

    String question;
   String questionimage;
    boolean isBookmark;
    String option1;
    String option2;
    String option3;
    String option1image;
    String option2image;
    String option3image;
    int correctanswer;



    public PracticeQuestionModel(String question, String questionimage , boolean isBookmark, String option1, String option2, String option3, String option1image, String option2image, String option3image, int correctanswer) {
        this.question = question;
        this.questionimage = questionimage;
        this.isBookmark = isBookmark;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option1image = option1image;
        this.option2image = option2image;
        this.option3image = option3image;
        this.correctanswer = correctanswer;

    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public  String getQuestionimage() {
        return questionimage;
    }

    public void setQuestionimage(String questionimage) {
        this.questionimage = questionimage;
    }
  
    public boolean isBookmark() {
        return isBookmark;
    }

    public void setBookmark(boolean bookmark) {
        isBookmark = bookmark;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption1image() {
        return option1image;
    }

    public void setOption1image(String option1image) {
        this.option1image = option1image;
    }

    public String getOption2image() {
        return option2image;
    }

    public void setOption2image(String option2image) {
        this.option2image = option2image;
    }

    public String getOption3image() {
        return option3image;
    }

    public void setOption3image(String option3image) {
        this.option3image = option3image;
    }
    public int getCorrectanswer() {
        return correctanswer;
    }

    public void setCorrectanswer(int correctanswer) {
        this.correctanswer = correctanswer;
    }
}
