package com.example.swe311_final_assignment_swe1904867;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText email,password,reenterPassword;
    TextView errorEmail,errorPassword,errorReenterPassword;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        db=new DatabaseHelper(this);
        email=findViewById(R.id.etEmailRegister);
        password=findViewById(R.id.etPasswordRegister);
        reenterPassword=findViewById(R.id.etReenterPasswordRegister);
        errorEmail=findViewById(R.id.tvErrorEmailRegister);
        errorPassword=findViewById(R.id.tvErrorPasswordRegister);
        errorReenterPassword=findViewById(R.id.tvErrorReenterPasswordRegister);
        register=findViewById(R.id.btnRegister);

        //invisible all the error msg
        errorEmail.setVisibility(View.INVISIBLE);
        errorPassword.setVisibility(View.INVISIBLE);
        errorReenterPassword.setVisibility(View.INVISIBLE);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateSignUp(email.getText().toString(),password.getText().toString(),
                        reenterPassword.getText().toString());
            }
        });
    }

    public void validateSignUp(String userEmail,String userPwd,String reenterPwd){

        errorEmail.setVisibility(View.INVISIBLE);
        errorPassword.setVisibility(View.INVISIBLE);
        errorReenterPassword.setVisibility(View.INVISIBLE);

        if(!userEmail.contains("@")||!userEmail.contains(".com")){
            errorEmail.setVisibility(View.VISIBLE);
            return;
        }

        if(!userPwd.equals(reenterPwd)||userPwd.equals("")){
            errorPassword.setVisibility(View.VISIBLE);
            errorReenterPassword.setVisibility(View.VISIBLE);
            return;
        }

        db.insertData(userEmail,userPwd,"1");
        Toast.makeText(this, "Sign up successful", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(SignupActivity.this,SuccessLoginSplashActivity.class);
        startActivity(intent);
    }
}