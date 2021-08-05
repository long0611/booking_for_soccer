package com.example.myapplication.Meta;

import java.io.Serializable;
import java.util.List;

public class SanBongMeta implements Serializable {
    private int id;
    private String tensan;
    private String sdt;
    private float giasan;
    private int tinhtrang;
    private String diachi;
    private String anh;
    private String ngay;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensan() {
        return tensan;
    }

    public void setTensan(String tensan) {
        this.tensan = tensan;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String masan) {
        this.sdt = sdt;
    }

    public float getGiasan() {
        return giasan;
    }

    public void setGiasan(float giasan) {
        this.giasan = giasan;
    }

    public int getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(int tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getAddress() {
        return diachi;
    }

    public void setAddress(String address) {
        this.diachi = address;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

}
