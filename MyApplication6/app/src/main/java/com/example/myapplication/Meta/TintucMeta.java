package com.example.myapplication.Meta;

public class TintucMeta {
    int anhStatus;
    String tennguoidang;
    String capstatus;


    public TintucMeta(int anhStatus, String tennguoidang, String capstatus) {
        this.anhStatus = anhStatus;
        this.tennguoidang = tennguoidang;
        this.capstatus = capstatus;
    }

    public int getAnhStatus() {
        return anhStatus;
    }

    public void setAnhStatus(int anhStatus) {
        this.anhStatus = anhStatus;
    }

    public String getTennguoidang() {
        return tennguoidang;
    }

    public void setTennguoidang(String tennguoidang) {
        this.tennguoidang = tennguoidang;
    }

    public String getCapstatus() {
        return capstatus;
    }

    public void setCapstatus(String capstatus) {
        this.capstatus = capstatus;
    }
}