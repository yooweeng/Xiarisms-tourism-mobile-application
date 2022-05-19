package com.example.swe311_final_assignment_swe1904867;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlanFragment extends Fragment {

    RecyclerView planRv;
    PlanAdapter planAdapter;
    ArrayList<PlanItemModelClass> planList;

    Button add;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_plan,container,false);

        planRv=view.findViewById(R.id.rvDisplayPlan);
        planRv.setHasFixedSize(true);
        planRv.setLayoutManager(new LinearLayoutManager(getContext()));

        planList=new ArrayList<>();
        planAdapter=new PlanAdapter(getContext(),planList);
        planRv.setAdapter(planAdapter);

        DatabaseHelper db;
        db=new DatabaseHelper(getContext());

        Cursor cursor=db.getPlanData();
        if(cursor!=null){
            if(cursor.moveToFirst()){
                do{
                    int planId=cursor.getInt((cursor.getColumnIndex("plan_id")));
                    String name=cursor.getString((cursor.getColumnIndex("name")));
                    String note=cursor.getString((cursor.getColumnIndex("note")));
                    int image=cursor.getInt((cursor.getColumnIndex("image")));
                    PlanItemModelClass item=new PlanItemModelClass(planId,name,note,image);
                    planList.add(item);
                }while(cursor.moveToNext());
                planAdapter.notifyDataSetChanged();
            }
        }

        add=view.findViewById(R.id.btnAddPlan);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PlanFragment_AddPlanFragment()).commit();
            }
        });

        return view;
    }
}
