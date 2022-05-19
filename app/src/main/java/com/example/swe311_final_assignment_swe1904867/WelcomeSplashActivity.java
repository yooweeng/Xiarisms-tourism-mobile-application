package com.example.swe311_final_assignment_swe1904867;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class WelcomeSplashActivity extends AppCompatActivity {

    TextView welcomeSplashTitle;
    int splashTime=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomesplash);

        Animation fadein= AnimationUtils.loadAnimation(this,R.anim.fadein);
        welcomeSplashTitle=findViewById(R.id.tvWelcomeSplashTitle);
        welcomeSplashTitle.setAnimation(fadein);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(WelcomeSplashActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, splashTime);
    }
}