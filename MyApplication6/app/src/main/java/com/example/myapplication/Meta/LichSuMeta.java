package com.example.myapplication.Meta;

public class LichSuMeta {
    String tensan;
    String timein;
    String thoiluong;
    String sdt;

    public LichSuMeta(String tensan, String timein, String thoiluong, String sdt) {
        this.tensan = tensan;
        this.timein = timein;
        this.thoiluong = thoiluong;
        this.sdt = sdt;
    }

    public String getTensan() {
        return tensan;
    }

    public void setTensan(String tensan) {
        this.tensan = tensan;
    }

    public String getTimein() {
        return timein;
    }

    public void setTimein(String timein) {
        this.timein = timein;
    }

    public String getThoiluong() {
        return thoiluong;
    }

    public void setThoiluong(String thoiluong) {
        this.thoiluong = thoiluong;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
