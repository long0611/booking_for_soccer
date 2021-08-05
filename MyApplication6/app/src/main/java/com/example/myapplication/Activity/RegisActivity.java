package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Meta.User;
import com.example.myapplication.R;
import com.example.myapplication.api.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisActivity extends AppCompatActivity {
    private Button btn_regis;
    private TextView tvTitle;
    private EditText edtName,edtEmail,edtPhone,edtPass,edtAddress;
    private Spinner spnGender;
    private ProgressDialog mProgress;
    private CountDownTimer countDownTimer;
    private int i = 5;
    ArrayList<String> arrGen = new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);
        AnhXa();
        Nut();
        getGender();
    }
    private void Nut() {
        btn_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgress = new ProgressDialog(RegisActivity.this);
                mProgress.setCancelable(false);
                mProgress.setIndeterminate(true);
                mProgress.setProgress(i);
                mProgress.show();
                countDownTimer = new CountDownTimer(6000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        mProgress.setMessage("Vui lòng chờ...");
                    }
                    @Override
                    public void onFinish() {
                        mProgress.dismiss();
                    }
                }.start();
                Intent intent = new Intent(RegisActivity.this,LoginActivity.class);
                startActivity(intent);
                regis();
            }
        });
        spnGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void regis() {
        if (edtName.getText().toString().trim().isEmpty()){
            edtName.setError("Trường này không được để trống");
            edtName.requestFocus();
            return;
        }

        if (edtPhone.getText().toString().trim().isEmpty()){
            edtPhone.setError("Trường này không được để trống");
            edtPhone.requestFocus();
            return;
        }
        if (edtPhone.getText().toString().trim().length() < 10 || edtPhone.getText().toString().trim().length() > 10 ){
            edtPhone.setError("Bạn chưa nhập đúng số điện thoại");
            edtPhone.requestFocus();
            return;
        }

        if (edtEmail.getText().toString().trim().isEmpty()){
            edtEmail.setError("Email không được để trống");
            edtEmail.requestFocus();
            return;
        }

        if (edtAddress.getText().toString().trim().isEmpty()){
            edtAddress.setError("Địa chỉ không được để trống");
            edtAddress.requestFocus();
            return;
        }

        if (edtPass.getText().toString().trim().isEmpty()){
            edtPass.setError("Trường này không được để trống");
            edtPass.requestFocus();
            return;
        }
        if (edtPass.getText().toString().trim().length() < 3){
            edtPass.setError("Mật khẩu phải lớn hơn 3 ký tự");
            edtPass.requestFocus();
            return;
        }
        ApiService.apiService.regis(edtName.getText().toString().trim(),
                                    spnGender.getSelectedItem().toString(),
                                    Integer.parseInt(edtPhone.getText().toString().trim()),
                                    edtEmail.getText().toString().trim(),
                                    edtAddress.getText().toString().trim(),
                                    edtPass.getText().toString().trim()
                                    )
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful() && response.body() != null){
                            User user = response.body();
                            Toast.makeText(RegisActivity.this, "Đăng Ký thành công", Toast.LENGTH_SHORT).show();
                            onBackPressed();
                            mProgress.dismiss();
                            finish();
                        }
                    }
                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(RegisActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void getGender(){
        arrGen.add("Nam");
        arrGen.add("Nữ");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,arrGen);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnGender.setAdapter(adapter);
    }

    private void AnhXa() {
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);
        spnGender = findViewById(R.id.spnGender);
        edtPass = findViewById(R.id.edtPassword);
        edtAddress = findViewById(R.id.edtAddress);
        btn_regis = (Button) findViewById(R.id.btn_regis);
    }
}