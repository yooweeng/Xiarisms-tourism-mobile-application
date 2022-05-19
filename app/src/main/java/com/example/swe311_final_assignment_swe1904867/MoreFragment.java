package com.example.swe311_final_assignment_swe1904867;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MoreFragment extends Fragment {

    TextView username,editProfile,changePwd,logout;
    DatabaseHelper db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_more,container,false);

        db=new DatabaseHelper(getContext());

        username=view.findViewById(R.id.tvUsernameMore);
        editProfile=view.findViewById(R.id.tvEditProfile);
        changePwd=view.findViewById(R.id.tvChangePassword);
        logout=view.findViewById(R.id.tvLogout);

        username.setText(db.getActiveUsername());

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),EditProfileActivity.class);
                startActivity(intent);
            }
        });

        changePwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),ValidateEmailActivity.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.resetAllStatus();
                Intent intent=new Intent(getActivity(),WelcomeSplashActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }
}
