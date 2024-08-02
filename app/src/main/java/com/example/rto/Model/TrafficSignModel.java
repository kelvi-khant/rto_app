package com.example.rto.Model;

public class TrafficSignModel {

    boolean isBookmark;
    int trafficsign;
    String trafficsignname,number;

    public TrafficSignModel(String number,int trafficsign, boolean isBookmark, String trafficsignname) {
        this.number = number;
        this.trafficsign = trafficsign;
        this.isBookmark = isBookmark;
        this.trafficsignname = trafficsignname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getTrafficsign() {
        return trafficsign;
    }

    public void setTrafficsign(int trafficsign) {
        this.trafficsign = trafficsign;
    }

    public boolean isBookmark() {
        return isBookmark;
    }

    public void setBookmark(boolean bookmark) {
        isBookmark = bookmark;
    }

    public String getTrafficsignname() {
        return trafficsignname;
    }

    public void setTrafficsignname(String trafficsignname) {
        this.trafficsignname = trafficsignname;
    }
}
