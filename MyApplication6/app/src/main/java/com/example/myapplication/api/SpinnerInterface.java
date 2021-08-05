package com.example.myapplication.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SpinnerInterface {
    String JSONURL = "http://192.168.1.11/";

    @GET("doan3/getsanbong.php")
    Call<String> getSanBong();
}
