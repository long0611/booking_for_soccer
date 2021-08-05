package com.example.myapplication.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Post {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("tensan")
@Expose
private String tensan;
@SerializedName("sdt")
@Expose
private String sdt;
@SerializedName("giasan")
@Expose
private String giasan;
@SerializedName("tinhtrang")
@Expose
private Integer tinhtrang;
@SerializedName("diachi")
@Expose
private String diachi;
@SerializedName("anh")
@Expose
private String anh;
@SerializedName("ngay")
@Expose
private String ngay;

public Integer getId() {
return id;
}

public void setId(Integer id) {
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

public void setSdt(String sdt) {
this.sdt = sdt;
}

public String getGiasan() {
return giasan;
}

public void setGiasan(String giasan) {
this.giasan = giasan;
}

public Integer getTinhtrang() {
return tinhtrang;
}

public void setTinhtrang(Integer tinhtrang) {
this.tinhtrang = tinhtrang;
}

public String getDiachi() {
return diachi;
}

public void setDiachi(String diachi) {
this.diachi = diachi;
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