package com.example.myapplication.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.Activity.LichSuDatSan;
import com.example.myapplication.Activity.LoginActivity;
import com.example.myapplication.Activity.TaiKhoan;
import com.example.myapplication.Activity.UserActivity;
import com.example.myapplication.Adapter.SlideAdapter;
import com.example.myapplication.Meta.LayID;
import com.example.myapplication.Meta.User;
import com.example.myapplication.R;
import com.example.myapplication.api.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Intent.getIntent;


public class FragmentUser extends Fragment {
    private TextView tvUserName;
    private TextView tvUserEmail;
    private View mView;
    private ImageView imgUser;
    private Button btnTaiKhoan, btnLichSu;
    private LoginActivity mLoginActivity;
    private List<User> mListUser;

    private ViewPager mSlideViewPager;
    private LinearLayout mDotsLayout;

    private TextView[] mDots;

    private SlideAdapter slideAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_user,container,false);
        initUI();

        slideAdapter = new SlideAdapter(getContext());
        mSlideViewPager.setAdapter(slideAdapter);
        addDots(0);
        mSlideViewPager.addOnPageChangeListener(viewList);

        GetButton();
        return mView;
    }
    public void initUI(){
        tvUserName =(TextView) mView.findViewById(R.id.tv_user_name);
        tvUserEmail = (TextView) mView.findViewById(R.id.tv_user_email);
        imgUser = mView.findViewById(R.id.imgUser);
        btnTaiKhoan = mView.findViewById(R.id.btnTaiKhoan);
        btnLichSu = mView.findViewById(R.id.btnLichSu);

        mSlideViewPager = mView.findViewById(R.id.slideViewPage);
        mDotsLayout = mView.findViewById(R.id.dotsLayout);

        tvUserName.setText(LoginActivity.name);
        tvUserEmail.setText(LoginActivity.email);
    }
    public void GetButton(){
        btnTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TaiKhoan.class);
                startActivity(intent);
            }
        });

        btnLichSu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(v.getContext(), LichSuDatSan.class);
                getActivity().startActivity(intent1);
            }
        });
    }
    public void addDots(int position){
        mDots = new TextView[4];
        mDotsLayout.removeAllViews();
        for (int i = 0; i < mDots.length;i++){
            mDots[i] = new TextView(getContext());
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.yellow));

            mDotsLayout.addView(mDots[i]);
        }
        if (mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.my_color));
        }
    }
    ViewPager.OnPageChangeListener viewList = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };
}