package com.example.swe311_final_assignment_swe1904867;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PlanFragment_AddPlanFragment extends Fragment {

    ImageView hakka,shuzhuang,wuyuanwan,zhonghsan,gingerduck,tongan,tusundong,yuwantang;
    DatabaseHelper db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_plan_addplan,container,false);

        hakka=view.findViewById(R.id.ivHakkaAddPlan);
        shuzhuang=view.findViewById(R.id.ivShuzhuangAddPlan);
        wuyuanwan=view.findViewById(R.id.ivWuyuanwanAddPlan);
        zhonghsan=view.findViewById(R.id.ivZhongshanAddPlan);
        gingerduck=view.findViewById(R.id.ivGingerDuckAddPlan);
        tongan=view.findViewById(R.id.ivTonganAddPlan);
        tusundong=view.findViewById(R.id.ivTusundongAddPlan);
        yuwantang=view.findViewById(R.id.ivYuwantangAddPlan);

        db=new DatabaseHelper(getContext());

        PlanFragment_AddPlanFragment_InputPlanDetailsFragment nextFrag = new PlanFragment_AddPlanFragment_InputPlanDetailsFragment();
        Bundle bundle = new Bundle();

        hakka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putInt("selectedTarget", 0);
                nextFrag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, nextFrag).commit();
            }
        });

        shuzhuang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putInt("selectedTarget", 1);
                nextFrag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, nextFrag).commit();
            }
        });

        wuyuanwan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putInt("selectedTarget", 2);
                nextFrag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, nextFrag).commit();
            }
        });

        zhonghsan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putInt("selectedTarget", 3);
                nextFrag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, nextFrag).commit();
            }
        });

        gingerduck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putInt("selectedTarget", 4);
                nextFrag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, nextFrag).commit();
            }
        });

        tongan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putInt("selectedTarget", 5);
                nextFrag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, nextFrag).commit();
            }
        });

        tusundong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putInt("selectedTarget", 6);
                nextFrag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, nextFrag).commit();
            }
        });

        yuwantang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putInt("selectedTarget", 7);
                nextFrag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, nextFrag).commit();
            }
        });

        return view;
    }
}
