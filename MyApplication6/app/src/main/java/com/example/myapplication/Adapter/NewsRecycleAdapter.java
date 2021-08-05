package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.Meta.TintucMeta;

import java.util.List;

public class NewsRecycleAdapter extends RecyclerView.Adapter<NewsRecycleAdapter.MyViewHolder > {

    Context mContext;
    List<TintucMeta>mData;

    public NewsRecycleAdapter(Context mContext, List<TintucMeta> mData){
        this.mContext = mContext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.tintuc_item,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRecycleAdapter.MyViewHolder holder, int position) {
            holder.tv_name.setText(mData.get(position).getTennguoidang());
            holder.tv_cap.setText(mData.get(position).getCapstatus());
            holder.img.setImageResource(mData.get(position).getAnhStatus());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name;
        private TextView tv_cap;
        private ImageView img;


        public MyViewHolder(View itemView){
            super(itemView);

            tv_name = (TextView) itemView.findViewById(R.id.tennguoidang);
            tv_cap = (TextView) itemView.findViewById(R.id.capstatus);
            img = (ImageView) itemView.findViewById(R.id.anhStatus);
        }
    }
}
