package com.example.hustlers.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hustlers.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AdminDashboard extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        listView = (ListView) findViewById(R.id.listView);

        CollectionReference col = db.collection("appointment");

        List<String> list = new ArrayList<>();
        col.whereEqualTo("isVerified", false).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    Runnable r = new Runnable() {
                        @Override
                        public void run() {
                            for(QueryDocumentSnapshot doc : task.getResult()){
                                list.add(doc.getId());

                                Log.d("Data in loop", String.valueOf(list));
                            }
                        }
                    };
                    r.run();
                    ArrayAdapter arrayAdapter = new ArrayAdapter(AdminDashboard.this, android.R.layout.simple_list_item_1, list);

                    listView.setAdapter(arrayAdapter);
                }
                else{
                    Log.d("Dashboard", "unsuccessful");
                }
            }
        });



        listView.setClickable(true);
        Log.d("Data", String.valueOf(list));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(AdminDashboard.this, AdminVerificationActivity.class);
                String appId = (String)listView.getItemAtPosition(i);
                intent.putExtra("appId",appId);
                startActivity(intent);
                finish();
            }
        });
    }
}