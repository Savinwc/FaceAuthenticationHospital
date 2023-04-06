package com.example.hustlers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    EditText name;
    EditText email;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText) findViewById(R.id.editTextTPersonName3);
        email = (EditText) findViewById(R.id.editTextTextPersonName);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isComplete()){
                    Map<String, String> map = new HashMap<>();
                    map.put("uid", email.getText().toString());
                    map.put("name", name.getText().toString());
                    db.collection("user").document(email.getText().toString()).set(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Intent intent = new Intent(RegisterActivity.this, RegisterFaceActivity.class);

                            intent.putExtra("name",email.getText().toString());
                            intent.putExtra("username",name.getText().toString());
                            startActivity(intent);
                        }
                    });


                }
            }
        });
    }

    private boolean isComplete() {
        if(email.getText() == null || name.getText() == null)
            return false;
        else
            return true;
    }
}