package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.Meta.User;
import com.example.myapplication.R;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        TextView tvUserName = findViewById(R.id.tv_user_name);
        TextView tvUserEmail = findViewById(R.id.tv_user_email);

        Bundle bundleRecive = getIntent().getExtras();
        if (bundleRecive != null){
            User user = (User) bundleRecive.get("object_user");
            if (user != null){
                tvUserName.setText(user.toString());
                tvUserEmail.setText(user.getUsername());
            }
        }

    }
}