package com.example.myapplication.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Activity.DatsanActivity;
import com.example.myapplication.Activity.LichSuDatSan;
import com.example.myapplication.Activity.LoginActivity;
import com.example.myapplication.Meta.HisDatSan;
import com.example.myapplication.Meta.LayID;
import com.example.myapplication.Meta.LichSuMeta;
import com.example.myapplication.Meta.Post;
import com.example.myapplication.Meta.SanBongMeta;
import com.example.myapplication.Meta.User;
import com.example.myapplication.R;
import com.example.myapplication.api.ApiService;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LichSuAdapter extends RecyclerView.Adapter<LichSuAdapter.RecyclerViewHolder> {
    private Context context;
    private List<HisDatSan> mHis;

    public LichSuAdapter(Context context, List<HisDatSan> mHis){
        this.context = context;
        this.mHis = mHis;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public LichSuAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.lichsudatsan_item, parent, false);
        return new LichSuAdapter.RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull LichSuAdapter.RecyclerViewHolder holder, int position) {
        if(mHis.get(position).getIdCustomer() == LoginActivity.idCustomer){
            holder.tvTenSan.setText(mHis.get(position).getSanName());
            holder.tvTimeIn.setText(mHis.get(position).getCheckin());
            holder.tvThoiLuong.setText(mHis.get(position).getCheckout());
            holder.tvSdt.setText(mHis.get(position).getSdt());
            holder.delete.setVisibility(View.INVISIBLE);
        }else {
            holder.cardView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mHis.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTenSan,tvTimeIn,tvThoiLuong,tvSdt;
        private CardView cardView;
        private TextView delete;
        public RecyclerViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardLichSu);
            tvTenSan = itemView.findViewById(R.id.tvTenSan);
            tvTimeIn = itemView.findViewById(R.id.tvTimeIn);
            tvThoiLuong = itemView.findViewById(R.id.tvSoPhut);
            tvSdt = itemView.findViewById(R.id.tvSdt);
            delete = itemView.findViewById(R.id.delete);
        }
    }
}
