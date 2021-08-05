package com.example.myapplication.Meta;

public class DatSan {
    public int booking_id;
    public int id_san;
    public int id_customer;
    public String checkin;
    public String checkout;
    public String thanhtoanqua;

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public int getId_san() {
        return id_san;
    }

    public void setId_san(int id_san) {
        this.id_san = id_san;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getThanhtoanqua() {
        return thanhtoanqua;
    }

    public void setThanhtoanqua(String thanhtoanqua) {
        this.thanhtoanqua = thanhtoanqua;
    }

    public DatSan(int booking_id, int id_san, int id_customer, String checkin, String checkout, String thanhtoanqua) {
        this.booking_id = booking_id;
        this.id_san = id_san;
        this.id_customer = id_customer;
        this.checkin = checkin;
        this.checkout = checkout;
        this.thanhtoanqua = thanhtoanqua;
    }
}
