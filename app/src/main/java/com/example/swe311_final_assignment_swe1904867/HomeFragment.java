package com.example.swe311_final_assignment_swe1904867;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeFragment extends Fragment {

    CardView hakkaEarth,shuzhuang,zhongshanStreet,wuyuanwanWetland;
    CircleImageView hakkaEarthCiv,shuzhuangCiv,zhongshanStreetCiv,wuyuanwanWetlandCiv;
    TextView username;
    DatabaseHelper db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);

        db=new DatabaseHelper(getContext());

        username=view.findViewById(R.id.tvUsernameHome);
        hakkaEarth=view.findViewById(R.id.cvHakkaEarthBuildingHome);
        shuzhuang=view.findViewById(R.id.cvShuzhuangGardenHome);
        zhongshanStreet=view.findViewById(R.id.cvZhongshanStreet);
        wuyuanwanWetland=view.findViewById(R.id.cvWuyuanwanWetlandHome);
        hakkaEarthCiv=view.findViewById(R.id.civHakkaEarthHome);
        shuzhuangCiv=view.findViewById(R.id.civShuzhuangHome);
        zhongshanStreetCiv=view.findViewById(R.id.civZhongshanStreet);
        wuyuanwanWetlandCiv=view.findViewById(R.id.civWetlandHome);

        username.setText("Hello, "+db.getActiveUsername());

        //card view item
        hakkaEarth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),HakkaEarthBuildingActivity.class);
                startActivity(intent);
            }
        });

        shuzhuang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),ShuzhuangGardenActivity.class);
                startActivity(intent);
            }
        });

        zhongshanStreet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),ZhongshanRoadWalkingStreet.class);
                startActivity(intent);
            }
        });

        wuyuanwanWetland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),WuyuanwanWetlandParkActivity.class);
                startActivity(intent);
            }
        });

        //story item
        hakkaEarthCiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),HakkaEarthBuildingActivity.class);
                startActivity(intent);
            }
        });

        shuzhuangCiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),ShuzhuangGardenActivity.class);
                startActivity(intent);
            }
        });

        zhongshanStreetCiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),ZhongshanRoadWalkingStreet.class);
                startActivity(intent);
            }
        });

        wuyuanwanWetlandCiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),WuyuanwanWetlandParkActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
