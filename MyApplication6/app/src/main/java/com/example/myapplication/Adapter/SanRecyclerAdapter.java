package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Activity.SanDetailActivity;
import com.example.myapplication.Fragment.FragmentHome;
import com.example.myapplication.Fragment.FragmentUser;
import com.example.myapplication.R;
import com.example.myapplication.Meta.SanBongMeta;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SanRecyclerAdapter extends RecyclerView.Adapter<SanRecyclerAdapter.RecyclerViewHolder>{
    private List<SanBongMeta> sanBongMetas;
    private Context context;

    public SanRecyclerAdapter(List<SanBongMeta> sanBongMetas, Context context) {
        this.sanBongMetas = sanBongMetas;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.san_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.tenSan.setText(sanBongMetas.get(position).getTensan());
        holder.tenDoiDangThue.setText(sanBongMetas.get(position).getAddress());
        holder.giaSan.setText("0"+sanBongMetas.get(position).getSdt());
        Picasso.get().load(sanBongMetas.get(position).getAnh()).error(R.drawable.san1).into(holder.imgSanBong);
        if (sanBongMetas.get(position).getTinhtrang() == 1){
            holder.emptyStatus.setVisibility(View.INVISIBLE);
            holder.cardSanWrapper.setCardBackgroundColor(Color.parseColor("#178e96"));
            holder.cardCurrentHiring.setCardBackgroundColor(Color.parseColor("#178e96"));
        }
        else {
            holder.cardCurrentHiring.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return sanBongMetas.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView tenSan;
        TextView emptyStatus;
        CardView cardCurrentHiring;
        TextView tenDoiDangThue;
        CardView cardSanWrapper;
        TextView giaSan;
        ImageView imgSanBong;


        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tenSan = (TextView) itemView.findViewById(R.id.tenSan);
            giaSan = (TextView) itemView.findViewById(R.id.giaSan);
            tenDoiDangThue = (TextView) itemView.findViewById(R.id.tenDoi);
            cardSanWrapper = (CardView) itemView.findViewById(R.id.cardSanWrapper);
            cardCurrentHiring = (CardView) itemView.findViewById(R.id.cardCurrentHiring);
            emptyStatus = (TextView) itemView.findViewById(R.id.emptyStatus);
            imgSanBong = (ImageView) itemView.findViewById(R.id.imgSanBong);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), SanDetailActivity.class);
                    intent.putExtra("SanBongIndex", sanBongMetas.get(getAdapterPosition()));
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}