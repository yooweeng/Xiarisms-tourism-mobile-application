package com.example.swe311_final_assignment_swe1904867;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.PlanItemViewHolder> {

    Context context;
    ArrayList<PlanItemModelClass> planList;

    public PlanAdapter(Context context, ArrayList<PlanItemModelClass> planList) {
        this.context=context;
        this.planList=planList;
    }

    @NonNull
    @Override
    public PlanItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_recycleview_item_display_plan,parent,false);
        return new PlanItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanItemViewHolder holder, int position) {
        PlanItemModelClass planItem=planList.get(position);
        holder.planName.setText(planItem.getTitle());
        holder.planNote.setText(planItem.getNote());
        if(planItem.getImage()==0){
            holder.planImage.setImageResource(R.drawable.hakkaearthbuilding);
        }
        if(planItem.getImage()==1){
            holder.planImage.setImageResource(R.drawable.shuzhuanggarden);
        }
        if(planItem.getImage()==2){
            holder.planImage.setImageResource(R.drawable.wuyuanwanwetland);
        }
        if(planItem.getImage()==3){
            holder.planImage.setImageResource(R.drawable.zhongshanstreet);
        }
        if(planItem.getImage()==4){
            holder.planImage.setImageResource(R.drawable.gingerduck);
        }
        if(planItem.getImage()==5){
            holder.planImage.setImageResource(R.drawable.tonganfengrou);
        }
        if(planItem.getImage()==6){
            holder.planImage.setImageResource(R.drawable.tusundong);
        }
        if(planItem.getImage()==7){
            holder.planImage.setImageResource(R.drawable.yuwantangmian);
        }
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.db.deletePlan(planList.get(position).getPlanId());
                Toast.makeText(context, "Plan deleted", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context,MainActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return planList.size();
    }

    public static class PlanItemViewHolder extends RecyclerView.ViewHolder{

        TextView planName,planNote;
        ImageView planImage;
        Button delete;
        DatabaseHelper db;

        public PlanItemViewHolder(@NonNull View itemView) {
            super(itemView);

            planName=itemView.findViewById(R.id.tvPlanName);
            planNote=itemView.findViewById(R.id.tvPlanNote);
            planImage=itemView.findViewById(R.id.ivPlanImage);
            delete=itemView.findViewById(R.id.btnDeletePlan);

            db=new DatabaseHelper(itemView.getContext());
        }
    }
}