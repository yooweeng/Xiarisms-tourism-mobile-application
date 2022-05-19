package com.example.swe311_final_assignment_swe1904867;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SuccessLoginSplashActivity extends AppCompatActivity {

    TextView helloMsg,username;
    ImageView loading;
    int splashTime=3000;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successloginsplash);

        helloMsg=findViewById(R.id.tvSuccessLoginUser);
        username=findViewById(R.id.tvSuccessLoginSplashUsername);
        loading=findViewById(R.id.ivLoading);

        db=new DatabaseHelper(this);
        String s=db.getActiveUsername();

        username.setText(s);

        AnimationSet animationSet1=new AnimationSet(true);
        AnimationSet animationSet2=new AnimationSet(true);
        Animation rotate=AnimationUtils.loadAnimation(this,R.anim.rotate);
        Animation fadein=AnimationUtils.loadAnimation(this,R.anim.fadein);
        Animation fadeout=AnimationUtils.loadAnimation(this,R.anim.fadeout);

        animationSet1.addAnimation(rotate);
        animationSet1.addAnimation(fadein);
        animationSet1.addAnimation(fadeout);

        animationSet2.addAnimation(fadein);
        animationSet2.addAnimation(fadeout);

        helloMsg.startAnimation(animationSet2);
        username.startAnimation(animationSet2);
        loading.setAnimation(animationSet1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SuccessLoginSplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, splashTime);
    }
}