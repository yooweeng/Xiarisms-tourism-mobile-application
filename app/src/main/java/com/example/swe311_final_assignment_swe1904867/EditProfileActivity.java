package com.example.swe311_final_assignment_swe1904867;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditProfileActivity extends AppCompatActivity {

    TextView username;
    EditText email,password;
    Button editProfile,removeAccount;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        db=new DatabaseHelper(this);

        username=findViewById(R.id.tvUsernameEdit);
        email=findViewById(R.id.etEmailEdit);
        password=findViewById(R.id.etPasswordEdit);
        editProfile=findViewById(R.id.btnEditProfileEdit);
        removeAccount=findViewById(R.id.btnRemoveAccountEdit);

        username.setText(db.getActiveUsername());
        email.setText(db.getActiveUsername());
        password.setText(db.getActivePassword());

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.changeActiveUserPassword(password.getText().toString());
                Toast.makeText(EditProfileActivity.this,"Edit profile successfully",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(EditProfileActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        removeAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteActiveUsernameAccount();
                Toast.makeText(EditProfileActivity.this, "Account successfully removed", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(EditProfileActivity.this,WelcomeSplashActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}