package com.example.rto.Model;

public class RTOofficeModel {


    String title;
    int pic;

    public RTOofficeModel(String title,int pic) {
        this.title = title;
        this.pic = pic;
    }

    public String getText() {
        return title;
    }

    public void setText(String title) {
        this.title = title;
    }
    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}
