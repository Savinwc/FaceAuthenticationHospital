package com.example.hustlers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hustlers.Admin.AdminDashboard;
import com.onurkaganaldemir.ktoastlib.KToast;

public class AdminLoginActivity extends AppCompatActivity {


    EditText name;
    EditText password;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        name = (EditText) findViewById(R.id.editTextTPersonName2);
        password = (EditText) findViewById(R.id.editTextTPersonName4);
        Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCorrect()) {
                    Intent intent = new Intent(AdminLoginActivity.this, AdminUIDashboard.class);
                    startActivity(intent);
                    KToast.customBackgroudToast(AdminLoginActivity.this, "Login Successful", Gravity.BOTTOM, KToast.LENGTH_AUTO, R.drawable.background_toast, null ,R.drawable.ic_infinite_white);
                }else{
                    KToast.warningToast(AdminLoginActivity.this, "Incorrect Credentials", Gravity.BOTTOM, KToast.LENGTH_AUTO);
                }
            }
        });
    }
    private boolean isCorrect() {
        return name.getText().toString().trim().equals("admin") && password.getText().toString().trim().equals("admin");
    }
}