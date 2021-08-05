package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Meta.SanBongMeta;
import com.example.myapplication.Meta.User;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class SanDetailActivity extends AppCompatActivity {
    private ImageView imgSan;
    private Button btnDatsan;
    private Button btnVitri;
    private Button btnChiaSeViTri;
    private TextView tvTinhTrang,tvTinhTrang2;
    private TextView tvSanDetail,back;
    private TextView tvAddressDetail;
    private TextView tvPhone;
    private TextView tvGia;
    private List<SanBongMeta> sanBongMetas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandetail);
        Anhxa();
        getData();
        EvenButton();
    }

    private void getData() {
        SanBongMeta sanBongMeta = (SanBongMeta) getIntent().getSerializableExtra("SanBongIndex");
        tvSanDetail.setText(sanBongMeta.getTensan());
        tvAddressDetail.setText(sanBongMeta.getAddress());
        tvPhone.setText("0"+sanBongMeta.getSdt());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        tvGia.setText(decimalFormat.format(sanBongMeta.getGiasan())+ "Đ/Tiếng" );
        if (sanBongMeta.getTinhtrang() == 1){
            tvTinhTrang2.setVisibility(View.VISIBLE);
            tvTinhTrang.setVisibility(View.INVISIBLE);
        }
        else {
            tvTinhTrang2.setVisibility(View.INVISIBLE);
            tvTinhTrang.setVisibility(View.VISIBLE);
        }
        Picasso.get().load(sanBongMeta.getAnh()).placeholder(R.drawable.san1)
                .error(R.drawable.san1)
                .into(imgSan);
    }

    private void EvenButton(){
        btnDatsan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),DatsanActivity.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SanDetailActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void Anhxa(){
        imgSan = findViewById(R.id.imgSanDetail);
        btnDatsan = findViewById(R.id.btnDatSan);
        btnVitri = findViewById(R.id.btnVitri);
        btnChiaSeViTri = findViewById(R.id.btnChiaSe);
        tvTinhTrang = findViewById(R.id.tvTinhtrang);
        tvSanDetail = findViewById(R.id.tvSanDetail);
        tvTinhTrang2 = findViewById(R.id.tvTinhtrang2);
        tvAddressDetail = findViewById(R.id.tvAddressDetail);
        tvPhone = findViewById(R.id.tvPhone);
        tvGia = findViewById(R.id.tvGia);
        back = findViewById(R.id.back);
    }

}