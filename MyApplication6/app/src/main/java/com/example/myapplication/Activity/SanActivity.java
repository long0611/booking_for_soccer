package com.example.myapplication.Activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.ListSanAdapter;
import com.example.myapplication.Meta.ListsanMeta;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class SanActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ListsanMeta>metaList;
    ListSanAdapter listSanAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san);

        initData();
        initReCylerView();

    }

    private void initData() {

        metaList = new ArrayList<>();
        metaList.add(new ListsanMeta(R.drawable.san1, "Sân bóng Chuyên Việt", "Trung Tâm TDTT Quốc Phòng 3,  98 Tiểu La, Quận Hải Châu, Thành Phố Đà Nẵng"));
        metaList.add(new ListsanMeta(R.drawable.san5, " Sân bóng đá Trương Vương", "560 Trưng Nữ Vương, quận hải Châu, TP. Ðà Nẵng"));
        metaList.add(new ListsanMeta(R.drawable.san10, "Sân bóng mini Nam Hải Vân", "01 Đỗ Đăng Tuyển – Cẩm Lệ – TP Đà Nẵng"));



    }

    private void initReCylerView() {
        recyclerView = findViewById(R.id.rcv_listSan);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        listSanAdapter = new ListSanAdapter(metaList);
        recyclerView.setAdapter(listSanAdapter);
        listSanAdapter.notifyDataSetChanged();

    }
}