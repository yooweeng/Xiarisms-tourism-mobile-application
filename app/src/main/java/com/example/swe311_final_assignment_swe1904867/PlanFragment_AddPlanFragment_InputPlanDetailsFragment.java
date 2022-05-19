package com.example.swe311_final_assignment_swe1904867;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PlanFragment_AddPlanFragment_InputPlanDetailsFragment extends Fragment {

    ImageView selectedImage;
    EditText header,note;
    Button save;
    DatabaseHelper db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_plan_addplan_plandetails,container,false);

        selectedImage=view.findViewById(R.id.ivImgPlanDetails);
        header=view.findViewById(R.id.etPlanNamePlanDetails);
        note=view.findViewById(R.id.etmPlanNotePlanDetails);
        save=view.findViewById(R.id.btnSavePlanDetails);

        db=new DatabaseHelper(getContext());

        Bundle bundle=this.getArguments();
        int targetId=bundle.getInt("selectedTarget");

        if(targetId==0){
            selectedImage.setImageResource(R.drawable.hakkaearthbuilding);
        }
        if(targetId==1){
            selectedImage.setImageResource(R.drawable.shuzhuanggarden);
        }
        if(targetId==2){
            selectedImage.setImageResource(R.drawable.wuyuanwanwetland);
        }
        if(targetId==3){
            selectedImage.setImageResource(R.drawable.zhongshanstreet);
        }
        if(targetId==4){
            selectedImage.setImageResource(R.drawable.gingerduck);
        }
        if(targetId==5){
            selectedImage.setImageResource(R.drawable.tonganfengrou);
        }
        if(targetId==6){
            selectedImage.setImageResource(R.drawable.tusundong);
        }
        if(targetId==7){
            selectedImage.setImageResource(R.drawable.yuwantangmian);
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.insertPlan(targetId,header.getText().toString(),note.getText().toString());
                Toast.makeText(getActivity(), "Plan saved", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
