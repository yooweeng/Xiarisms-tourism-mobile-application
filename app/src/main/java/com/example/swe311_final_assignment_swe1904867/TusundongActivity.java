package com.example.swe311_final_assignment_swe1904867;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TusundongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tusundong);

        Button detail;
        detail=findViewById(R.id.btnDetailTusundong);
        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://zh.wikipedia.org/wiki/File:Tusundong_Xiamen.jpg"));
                startActivity(Intent.createChooser(intent,"Title"));
            }
        });
    }
}