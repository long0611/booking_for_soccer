package com.example.myapplication.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Meta.DoiThuMeta;
import com.example.myapplication.Meta.SearchDoiThu;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class DoiThuRecycleAdapter extends RecyclerView.Adapter<DoiThuRecycleAdapter.RecyclerViewHolder>{
    private List<SearchDoiThu> mSearchDT;
    private Context context;

    public DoiThuRecycleAdapter(List<SearchDoiThu> mSearchDT,Context context) {
        this.mSearchDT = mSearchDT;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.search_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.tvHoTen.setText(mSearchDT.get(position).getName());
        holder.tvTittle.setText(mSearchDT.get(position).getStatus());
        holder.tvNoiDung.setText(mSearchDT.get(position).getContent());
        holder.tvTime.setText(mSearchDT.get(position).getTime());
        holder.tvSdt.setText(String.valueOf(mSearchDT.get(position).getSdt()));
        holder.tvAdress.setText(mSearchDT.get(position).getAddress());
//        holder.cardDoiThuWrapper.setCardBackgroundColor(Color.parseColor("#ffffff"));
//        holder.cardCurrentHiringDoiThu.setCardBackgroundColor(Color.parseColor("#27dd89"));
    }



    @Override
    public int getItemCount() {
        return mSearchDT.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView tvHoTen;
        TextView tvTittle;
        TextView tvNoiDung;
        TextView tvTime;
        TextView tvSdt;
        TextView tvAdress;
        CardView cardDoiThuWrapper;
        CardView cardCurrentHiringDoiThu;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tvHoTen = (TextView) itemView.findViewById(R.id.tvHoTen);
            tvTittle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvNoiDung = (TextView) itemView.findViewById(R.id.tvContentTDT);
            tvTime = (TextView) itemView.findViewById(R.id.tvThoiGianTDT);
            tvSdt = (TextView) itemView.findViewById(R.id.tvSdtTDT) ;
            tvAdress = (TextView) itemView.findViewById(R.id.tvAddressTDT);
            cardDoiThuWrapper = (CardView) itemView.findViewById(R.id.cardDoiThuWrapper);
            cardCurrentHiringDoiThu = (CardView) itemView.findViewById(R.id.cardCurrentHiringDoiThu);

        }
    }
}