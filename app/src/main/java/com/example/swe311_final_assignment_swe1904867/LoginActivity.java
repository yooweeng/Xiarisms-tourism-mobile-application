package com.example.swe311_final_assignment_swe1904867;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView signupLink,errorEmail,errorPassword;
    EditText email,password;
    Button login;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db=new DatabaseHelper(this);
        signupLink=findViewById(R.id.linkSignup);
        errorEmail=findViewById(R.id.tvErrorEmailRegister);
        errorPassword=findViewById(R.id.tvErrorReenterPasswordRegister);
        email=findViewById(R.id.etEmailRegister);
        password=findViewById(R.id.etPasswordRegister);
        login=findViewById(R.id.btnRegister);

        //invisible all the error msg
        errorEmail.setVisibility(View.INVISIBLE);
        errorPassword.setVisibility(View.INVISIBLE);

        //register all users to inactive status
        db.resetAllStatus();

        signupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateUser(email.getText().toString(),password.getText().toString());
            }
        });
    }

    public void validateUser(String userEmail,String userPwd){
        if(db.checkUsernamePassword(userEmail,userPwd)){
            errorEmail.setVisibility(View.INVISIBLE);
            errorPassword.setVisibility(View.INVISIBLE);

            //update current login user with active status
            db.updateActiveStatus(userEmail);

            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(LoginActivity.this,SuccessLoginSplashActivity.class);
            startActivity(intent);
        }
        else{
            errorEmail.setVisibility(View.VISIBLE);
            errorPassword.setVisibility(View.VISIBLE);
        }
    }
}