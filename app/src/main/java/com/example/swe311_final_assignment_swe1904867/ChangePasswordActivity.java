package com.example.swe311_final_assignment_swe1904867;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChangePasswordActivity extends AppCompatActivity {

    EditText password,reenterPassword;
    TextView errorPassword,errorReenterPassword;
    Button confirm;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        password=findViewById(R.id.etPasswordChange);
        reenterPassword=findViewById(R.id.etReenterPasswordChange);
        errorPassword=findViewById(R.id.tvErrorPasswordChange);
        errorReenterPassword=findViewById(R.id.tvErrorReenterPasswordChange);
        confirm=findViewById(R.id.btnConfirmChange);

        db=new DatabaseHelper(this);

        errorPassword.setVisibility(View.INVISIBLE);
        errorReenterPassword.setVisibility(View.INVISIBLE);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pwd=password.getText().toString();
                String reenterPwd=reenterPassword.getText().toString();
                if(pwd.equals(reenterPwd)){
                    errorPassword.setVisibility(View.INVISIBLE);
                    errorReenterPassword.setVisibility(View.INVISIBLE);
                    db.changeActiveUserPassword(pwd);
                    Toast.makeText(ChangePasswordActivity.this, "Change password successfully", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(ChangePasswordActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    errorPassword.setVisibility(View.VISIBLE);
                    errorReenterPassword.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}