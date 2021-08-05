package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.Adapter.LichSuAdapter;
import com.example.myapplication.Meta.HisDatSan;
import com.example.myapplication.Meta.LichSuMeta;
import com.example.myapplication.Meta.Post;
import com.example.myapplication.Meta.SanBongMeta;
import com.example.myapplication.Meta.User;
import com.example.myapplication.R;
import com.example.myapplication.api.ApiService;
import com.scwang.wave.MultiWaveHeader;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LichSuDatSan extends AppCompatActivity {
    private MultiWaveHeader waveHeader,waveFooter;
    private TextView backHis;
    private RecyclerView recyclerLS;
    private List<HisDatSan> mHis;
    private List<SanBongMeta> mSanBong;
    public static int idSan1;
    int id;
    public static String sanName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lichsudatsan);
        recyclerLS = (RecyclerView) findViewById(R.id.rcv_lichsu);


        ApiService.apiService.getBooking()
                .enqueue(new Callback<List<HisDatSan>>() {
                    @Override
                    public void onResponse(Call<List<HisDatSan>> call, Response<List<HisDatSan>> response) {
                        mHis = response.body();
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(LichSuDatSan.this,LinearLayoutManager.VERTICAL,false);
                        recyclerLS.setAdapter(new LichSuAdapter(LichSuDatSan.this,mHis));
                        recyclerLS.setLayoutManager(linearLayoutManager);
                    }
                    @Override
                    public void onFailure(Call<List<HisDatSan>> call, Throwable t) {

                    }
                });
        xuly();
    }

    private void xuly() {
        waveHeader = findViewById(R.id.wave_header);
        waveFooter = findViewById(R.id.wave_footer);
        backHis = findViewById(R.id.backLichSu);


        waveHeader.setVelocity(1);
        waveHeader.setProgress(1);
        waveHeader.isRunning();
        waveHeader.setGradientAngle(45);
        waveHeader.setWaveHeight(40);
        waveHeader.setStartColor(Color.argb(20,72,209,204));
        waveHeader.setCloseColor(Color.argb(50,23,142,150));

        waveFooter.setVelocity(1);
        waveFooter.setProgress(1);
        waveFooter.isRunning();
        waveFooter.setGradientAngle(45);
        waveFooter.setWaveHeight(40);
        waveFooter.setCloseColor(Color.argb(20,72,209,204));
        waveFooter.setStartColor(Color.argb(50,23,142,150));

    }
}