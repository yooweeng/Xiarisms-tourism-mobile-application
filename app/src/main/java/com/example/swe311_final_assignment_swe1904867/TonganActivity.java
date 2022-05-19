package com.example.swe311_final_assignment_swe1904867;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TonganActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tongan);

        Button detail;
        detail=findViewById(R.id.btnDetailTongan);
        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.mychineserecipes.com/recipe/stewed-pork-with-shrimp-and-chestnut-tongan-fengrou/"));
                startActivity(Intent.createChooser(intent,"Title"));
            }
        });
    }
}