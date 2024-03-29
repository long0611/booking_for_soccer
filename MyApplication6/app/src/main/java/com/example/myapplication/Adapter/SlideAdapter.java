package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.myapplication.R;

import org.jetbrains.annotations.NotNull;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter(Context context){
        this.context = context;
    }

    public int[] slide_image = {
            R.drawable.logomain,
            R.drawable.address,
            R.drawable.email,
            R.drawable.phone

    };

    public String[] slide_heading = {
            "LH Sports",
            "Ngũ hành sơn, Đà Nẵng",
            "hopdeptrai052@gmail.com",
            "0919999999"
    };

    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
        return view == (ConstraintLayout)object;
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView imgTittle = (ImageView) view.findViewById(R.id.imgTittle);
        TextView tvHead = (TextView) view.findViewById(R.id.tvTittle);

        imgTittle.setImageResource(slide_image[position]);
        tvHead.setText(slide_heading[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
