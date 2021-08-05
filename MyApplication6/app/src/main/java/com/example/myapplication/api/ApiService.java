package com.example.myapplication.api;

import androidx.cardview.widget.CardView;

import com.example.myapplication.Meta.DatSan;
import com.example.myapplication.Meta.HisDatSan;
import com.example.myapplication.Meta.Post;
import com.example.myapplication.Meta.SanBongMeta;
import com.example.myapplication.Meta.SearchDoiThu;
import com.example.myapplication.Meta.User;
import com.example.myapplication.Model.SanBongRespon;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {


    ApiService  apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.1.11/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class);
    @GET("doan3/getuser.php")
    Call<List<User>> getListUsers();

    @GET("doan3/getsanpham.php")
    Call<List<SanBongMeta>> getInfo();

    @GET("doan3/lichsudatsan.php")
    Call<List<HisDatSan>> getBooking();

    @GET("doan3/gettimdoithu.php")
    Call<List<SearchDoiThu>> gettimdoithu();

    @FormUrlEncoded
    @POST("doan3/datsan.php")
    Call<Post> datsan(@Field("id_san") int id_san,
                      @Field("id_customer") int id_customer,
                      @Field("checkin") String checkin,
                      @Field("checkout") String checkout,
                      @Field("sdt") String sdt
    );

    @FormUrlEncoded
    @POST("doan3/dangky.php")
    Call<User> regis(@Field("name_customer") String name,
                     @Field("gender") String gioitinh,
                     @Field("sdt") int sdt,
                     @Field("email") String email,
                     @Field("address") String address,
                     @Field("password") String password
    );

    @FormUrlEncoded
    @POST("doan3/suauser.php")
    Call<User> update(@Field("id_customer") int id,
                     @Field("password") String currentPassword,
                      @Field("pass_remember") String newPassword
    );

    @FormUrlEncoded
    @POST("doan3/huysan.php")
    Call<List<Post>> delete(@Field("booking_id") int id
    );

    @FormUrlEncoded
    @POST("doan3/timdoithu.php")
    Call<SearchDoiThu> timdoithu(@Field("name") String name,
                                 @Field("status") String status,
                                 @Field("content") String content,
                                 @Field("time") String time,
                                 @Field("sdt") int sdt,
                                 @Field("address") String address
    );

}
