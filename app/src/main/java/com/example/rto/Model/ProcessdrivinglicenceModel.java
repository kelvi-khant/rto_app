package com.example.rto.Model;

public class ProcessdrivinglicenceModel {
    String title;
    boolean pic;
    String defination;

    public String getDefination() {
        return defination;
    }

    public void setDefination(String defination) {
        this.defination = defination;
    }

    public ProcessdrivinglicenceModel(String title, boolean pic, String defination) {
        this.title = title;
        this.pic = pic;
        this.defination=defination;
    }

    public String getText() {
        return title;
    }

    public void setText(String title) {
        this.title = title;
    }
    public boolean getPic() {
        return pic;
    }

    public void setPic(boolean pic) {
        this.pic = pic;
    }
}
