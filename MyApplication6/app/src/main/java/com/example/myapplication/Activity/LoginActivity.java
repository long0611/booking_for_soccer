package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Adapter.ListSanAdapter;
import com.example.myapplication.Fragment.FragmentHome;
import com.example.myapplication.Fragment.FragmentUser;
import com.example.myapplication.Meta.SanBongMeta;
import com.example.myapplication.Meta.User;
import com.example.myapplication.R;
import com.example.myapplication.api.ApiService;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnLogin;
    private TextView tvDangKy;

    public static int idCustomer;
    public static String name;
    public static String gioitinh;
    public static int sdt;
    public static String email;
    public static String diachi;
    public static String password;

    private List<User> mListUser;
    private User mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUserName = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText)findViewById(R.id.edt_password);
        tvDangKy = findViewById(R.id.tvDangKy);
        btnLogin = findViewById(R.id.btnLogin);
        mListUser = new ArrayList<>();
        getListUser();
        XuLy();
    }

    private void XuLy() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickLogin();
            }
        });
        tvDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisActivity.class);
                startActivity(intent);
            }
        });
    }

    private void clickLogin(){

        String strUsername = edtUserName.getText().toString().trim();
        String strPassword = edtPassword.getText().toString().trim();

        if(mListUser == null || mListUser.isEmpty()){
            return;
        }
        boolean isHasUser = false;
        for (User user : mListUser){
            if(strUsername.equals(user.getUsername()) && strPassword.equals(user.getPassword())){
                isHasUser = true;
                mUser = user;

                idCustomer = user.getId();
                name = user.getName();
                password = user.getPassword();
                gioitinh = user.getGioitinh();
                sdt = user.getSdt();
                email = user.getUsername();
                diachi = user.getAddress();

                break;
            }
        }
        if (isHasUser){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(LoginActivity.this, "Tài khoản hoặc mật khẩu sai", Toast.LENGTH_SHORT).show();
        }

    }

    private void getListUser(){
        ApiService.apiService.getListUsers()
                .enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        mListUser = response.body();
                        Log.e("List User", mListUser.size() + "");
                    }
                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Call api Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }


}