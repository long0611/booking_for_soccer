package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Meta.ListsanMeta;
import com.example.myapplication.R;

import java.util.List;

public class ListSanAdapter extends RecyclerView.Adapter<ListSanAdapter.ListSanViewHolder> {
    private List<ListsanMeta> metaList;
    public ListSanAdapter (List<ListsanMeta>metaList){
        this.metaList = metaList;
    }


    @NonNull
    @Override
    public ListSanAdapter.ListSanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_itemsan,parent,false);
    return new ListSanViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ListSanAdapter.ListSanViewHolder holder, int position) {
        int resource = metaList.get(position).getAvatarSan();
        String name = metaList.get(position).getNameSan();
        String adr = metaList.get(position).getAdress();

        holder.setData(resource,name,adr);



    }

    @Override
    public int getItemCount() {
        return metaList.size();
    }

    public class ListSanViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;
        private TextView textView1;


        public ListSanViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_San);
            textView = itemView.findViewById(R.id.txt_tenSan);
            textView1= itemView.findViewById(R.id.txt_diaChi);

        }

        public void setData(int resource, String name, String adr) {
            imageView.setImageResource(resource);
            textView.setText(name);
            textView1.setText(adr);

        }
    }
}
