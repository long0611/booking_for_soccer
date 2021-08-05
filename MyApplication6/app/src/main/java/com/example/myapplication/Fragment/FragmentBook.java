package com.example.myapplication.Fragment;



import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.Activity.TimDoiThu;
import com.example.myapplication.Adapter.DoiThuRecycleAdapter;
import com.example.myapplication.Meta.DoiThuMeta;
import com.example.myapplication.Meta.SearchDoiThu;
import com.example.myapplication.R;
import com.example.myapplication.api.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentBook extends Fragment {
    private List<SearchDoiThu> mSearchTDT;
    private DoiThuRecycleAdapter mDoiThu;
    private RecyclerView mRecyclerView;
    private TextView DangBai;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_book, container, false);
        DangBai = (TextView) view.findViewById(R.id.btnDangBai);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclersearch);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        uiBtn();

        ApiService.apiService.gettimdoithu().enqueue(new Callback<List<SearchDoiThu>>() {
            @Override
            public void onResponse(Call<List<SearchDoiThu>> call, Response<List<SearchDoiThu>> response) {
                mSearchTDT = response.body();
                mDoiThu = new DoiThuRecycleAdapter(mSearchTDT,getActivity());
                mRecyclerView.setAdapter(mDoiThu);
            }
            @Override
            public void onFailure(Call<List<SearchDoiThu>> call, Throwable t) {

            }
        });
        return view;
    }

    private void uiBtn() {
        DangBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TimDoiThu.class);
                startActivity(intent);
            }
        });
    }
}