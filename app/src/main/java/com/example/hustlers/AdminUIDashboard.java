package com.example.hustlers;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.hustlers.Admin.AdminDashboard;

public class AdminUIDashboard extends AppCompatActivity {

    ImageView admin_dashboard;
    ImageView logout;

    ImageView doctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_uidashboard);

        admin_dashboard = (ImageView) findViewById(R.id.patient_dashboard_btn);
        logout = (ImageView) findViewById(R.id.lo_btn);

        doctor = (ImageView) findViewById(R.id.imageView10);

        admin_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminUIDashboard.this, AdminDashboard.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AdminUIDashboard.this);
                builder.setMessage("Do you want to Sign Out?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Intent intent = new Intent(AdminUIDashboard.this,LoginPageActivity.class);
                                startActivity(intent);
                                finish();

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminUIDashboard.this, DoctorActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        //Do nothing
    }
}