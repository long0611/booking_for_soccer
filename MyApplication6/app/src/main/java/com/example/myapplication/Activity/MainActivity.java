package com.example.myapplication.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Fragment.FragmentBook;
import com.example.myapplication.Fragment.FragmentHome;
import com.example.myapplication.Fragment.FragmentNews;
import com.example.myapplication.Fragment.FragmentSearch;
import com.example.myapplication.Fragment.FragmentUser;
import com.example.myapplication.Meta.SanBongMeta;
import com.example.myapplication.Meta.User;
import com.example.myapplication.R;
import com.example.myapplication.api.ApiService;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<SanBongMeta> mSanBong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

            bottomNav.setOnNavigationItemSelectedListener(navListener);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentHome()).commit();

    }

    private  BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()){
                        case  R.id.nav_home:
                            selectedFragment = new FragmentHome();
                            break;
                        case  R.id.nav_book:
                            selectedFragment = new FragmentBook();
                            break;
//                        case  R.id.nav_search:
//                            selectedFragment = new FragmentSearch();
//                            break;
                        case  R.id.nav_news:
                            selectedFragment = new FragmentSearch();
                            break;

                        case R.id.nav_user:
                            selectedFragment = new FragmentUser();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };
}