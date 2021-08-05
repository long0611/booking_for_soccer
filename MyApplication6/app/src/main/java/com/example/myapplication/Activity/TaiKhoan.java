package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Meta.User;
import com.example.myapplication.R;
import com.example.myapplication.api.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaiKhoan extends AppCompatActivity {
    private User user;
    private TextView tvName,tvGender,tvSdt,tvEmail,tvAddress;
    private EditText edtPassCu,edtPassNew;
    private Button btnRePass,btnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taikhoan);
        Anhxa();
        display();
        xuly();
    }

    private void xuly() {
        btnRePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repass();
                edtPassCu.getText().clear();
                edtPassNew.getText().clear();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
                Intent intent = new Intent(TaiKhoan.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void logout() {
        LoginActivity.email = "";
        LoginActivity.password = "";
        finish();
    }

    private void repass() {
        String pass = edtPassCu.getText().toString().trim();
        String rePass = edtPassNew.getText().toString().trim();

        if (pass.isEmpty()){
            edtPassCu.setError("Trường này không được để trống");
            edtPassCu.requestFocus();
            return;
        }
        if (pass.length() < 3){
            edtPassCu.setError("Mật khẩu phải lớn hơn 3 ký tự");
            edtPassCu.requestFocus();
            return;
        }
        if (rePass.isEmpty()){
            edtPassNew.setError("Trường này không được để trống");
            edtPassNew.requestFocus();
            return;
        }
        if (rePass.length() < 3){
            edtPassNew.setError("Mật khẩu phải lớn hơn 3 ký tự");
            edtPassNew.requestFocus();
            return;
        }
        ApiService.apiService.update(LoginActivity.idCustomer,pass,rePass)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful() && response.body()!=null){
                            Toast.makeText(TaiKhoan.this, "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(TaiKhoan.this, "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void display() {
                tvName.setText(LoginActivity.name);
                tvGender.setText(LoginActivity.gioitinh);
                tvSdt.setText("0"+String.valueOf(LoginActivity.sdt));
                tvEmail.setText(LoginActivity.email);
                tvAddress.setText(LoginActivity.diachi);

    }

    private void Anhxa() {
        tvName = findViewById(R.id.tvName);
        tvGender = findViewById(R.id.tvGender);
        tvSdt = findViewById(R.id.tvPhoneNum);
        tvEmail = findViewById(R.id.tvEmail);
        tvAddress = findViewById(R.id.tvAddress);
        edtPassCu = findViewById(R.id.edtPassCu);
        edtPassNew = findViewById(R.id.edtPassNew);
        btnRePass = findViewById(R.id.btnRePass);
        btnLogout = findViewById(R.id.btnLogout);
    }
}