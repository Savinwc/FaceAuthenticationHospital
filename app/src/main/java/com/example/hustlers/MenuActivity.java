package com.example.hustlers;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    TextView name_tv;
    ImageView chatbot_btn;
    ImageView logout_btn;

    ImageView appointmnet;

    ImageView tokenImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        String name = getIntent().getStringExtra("name");
        name_tv = (TextView) findViewById(R.id.name_tv);
        name_tv.setText(name);

        chatbot_btn = (ImageView)findViewById(R.id.chatbot_btn);
        logout_btn = (ImageView)findViewById(R.id.logout_btn);

        appointmnet = (ImageView) findViewById(R.id.appointment_btn);

        tokenImage = (ImageView) findViewById(R.id.tokenImage);

        chatbot_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this,ChatBotActivity.class);
                startActivity(intent);
            }
        });

        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                builder.setMessage("Do you want to Sign Out?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Intent intent = new Intent(MenuActivity.this,LoginPageActivity.class);
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

        appointmnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, PatientDashboard.class);
                intent.putExtra("name", getIntent().getStringExtra("name"));
                startActivity(intent);
            }
        });

        tokenImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, TokenActivity.class);
                intent.putExtra("uid", getIntent().getStringExtra("name"));
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        //Do nothing
    }
}