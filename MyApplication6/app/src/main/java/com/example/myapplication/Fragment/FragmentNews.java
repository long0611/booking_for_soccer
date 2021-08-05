package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.NewsRecycleAdapter;
import com.example.myapplication.Meta.TintucMeta;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentNews extends Fragment {
    
    View v;
    private RecyclerView newsRecyclerView;
    private List<TintucMeta> listTintucMeta;

    public  FragmentNews(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_news,container,false);
        newsRecyclerView = (RecyclerView) v.findViewById(R.id.rcv_news);
        NewsRecycleAdapter newsRecycleAdapter =  new NewsRecycleAdapter(getContext(),listTintucMeta);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        newsRecyclerView.setAdapter(newsRecycleAdapter);

        return  v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listTintucMeta = new ArrayList<>();
        listTintucMeta.add(new TintucMeta(R.drawable.news1,"24h.com","Juventus mở màn “bom tấn” mùa hè, tính đưa Griezmann về thay Ronaldo"));
        listTintucMeta.add(new TintucMeta(R.drawable.news2,"Đinh Phan Bảo Long","Thầy Park bổ sung thủ môn ĐT Việt Nam đi UAE vì \"sự cố Đặng Văn Lâm\""));
        listTintucMeta.add(new TintucMeta(R.drawable.new3,"Trần Văn Hợp","Guardiola giành giải HLV hay nhất"));
    }
}