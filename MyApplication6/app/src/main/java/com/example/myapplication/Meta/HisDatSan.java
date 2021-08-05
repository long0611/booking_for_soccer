package com.example.myapplication.Meta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HisDatSan {
    @SerializedName("booking_id")
    @Expose
    private Integer bookingId;
    @SerializedName("id_san")
    @Expose
    private Integer idSan;
    @SerializedName("id_customer")
    @Expose
    private Integer idCustomer;
    @SerializedName("checkin")
    @Expose
    private String checkin;
    @SerializedName("checkout")
    @Expose
    private String checkout;
    @SerializedName("sdt")
    @Expose
    private String sdt;
    @SerializedName("san_name")
    @Expose
    private String sanName;

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getIdSan() {
        return idSan;
    }

    public void setIdSan(Integer idSan) {
        this.idSan = idSan;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getSanName() {
        return sanName;
    }

    public void setSanName(String sanName) {
        this.sanName = sanName;
    }
}
