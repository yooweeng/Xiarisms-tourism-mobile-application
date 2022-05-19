package com.example.swe311_final_assignment_swe1904867;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ValidateEmailActivity extends AppCompatActivity {

    EditText email;
    TextView errorEmail;
    Button confirm;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validateemail);

        db=new DatabaseHelper(this);

        email=findViewById(R.id.etEmailValidate);
        errorEmail=findViewById(R.id.tvErrorEmailValidate);
        confirm=findViewById(R.id.btnConfirmValidate);

        errorEmail.setVisibility(View.INVISIBLE);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().equals(db.getActiveUsername())){
                    errorEmail.setVisibility(View.INVISIBLE);
                    Intent intent=new Intent(ValidateEmailActivity.this, ChangePasswordActivity.class);
                    startActivity(intent);
                }
                else{
                    errorEmail.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}