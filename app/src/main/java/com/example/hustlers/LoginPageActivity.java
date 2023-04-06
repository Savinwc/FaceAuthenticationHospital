package com.example.hustlers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginPageActivity extends AppCompatActivity {

    Button face_login;
    Button admin_login;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        face_login = (Button) findViewById(R.id.patient_login_btn);
        admin_login = (Button) findViewById(R.id.admin_login_btn);
        register = (TextView) findViewById(R.id.patient_register_tv);

        face_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPageActivity.this,FaceLoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        admin_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPageActivity.this,AdminLoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPageActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        finish();
    }
}