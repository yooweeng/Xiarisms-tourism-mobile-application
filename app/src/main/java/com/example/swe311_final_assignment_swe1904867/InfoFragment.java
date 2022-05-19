package com.example.swe311_final_assignment_swe1904867;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class InfoFragment extends Fragment {

    CardView gingerDuck,tongan,tusundong,yuwantang;
    Button gingerDuckClickMoreBtn,tonganClickMoreBtn,
            tusundongClickMoreBtn,yuwantangClickMoreBtn,moreFoodBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_info,container,false);

        gingerDuck=view.findViewById(R.id.cvGingerDuckInfo);
        tongan=view.findViewById(R.id.cvTonganInfo);
        tusundong=view.findViewById(R.id.cvTusundongInfo);
        yuwantang=view.findViewById(R.id.cvYuwantangInfo);
        gingerDuckClickMoreBtn=view.findViewById(R.id.btnGingerDuckViewMoreInfo);
        tonganClickMoreBtn=view.findViewById(R.id.btnTonganViewMoreInfo);
        tusundongClickMoreBtn=view.findViewById(R.id.btnTusundongViewMoreInfo);
        yuwantangClickMoreBtn=view.findViewById(R.id.btnYuwantangViewMoreInfo);
        moreFoodBtn=view.findViewById(R.id.btnMoreFoodInfo);

        gingerDuck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),GingerDuckActivity.class);
                startActivity(intent);
            }
        });

        tongan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),TonganActivity.class);
                startActivity(intent);
            }
        });

        tusundong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),TusundongActivity.class);
                startActivity(intent);
            }
        });

        yuwantang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),YuwantangMianActivity.class);
                startActivity(intent);
            }
        });

        gingerDuckClickMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://cookingfollowme.com/ginger-duck/"));
                startActivity(Intent.createChooser(intent,"Title"));
            }
        });

        tonganClickMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.mychineserecipes.com/recipe/stewed-pork-with-shrimp-and-chestnut-tongan-fengrou/"));
                startActivity(Intent.createChooser(intent,"Title"));
            }
        });

        tusundongClickMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://zh.wikipedia.org/wiki/File:Tusundong_Xiamen.jpg"));
                startActivity(Intent.createChooser(intent,"Title"));
            }
        });

        yuwantangClickMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://sh-streetfood.org/yu-wan-fish-ball-%E9%B1%BC%E4%B8%B8/"));
                startActivity(Intent.createChooser(intent,"Title"));
            }
        });

        moreFoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.chinahighlights.com/xiamen/popular-foods.htm"));
                startActivity(Intent.createChooser(intent,"Title"));
            }
        });

        return view;
    }
}
