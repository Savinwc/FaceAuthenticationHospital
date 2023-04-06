package com.example.hustlers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.onurkaganaldemir.ktoastlib.KToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientDashboard extends AppCompatActivity {
    ListView listView;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_dashboard);

        listView = (ListView) findViewById(R.id.listViewPatient);

        CollectionReference ref = db.collection("doctor");
        List<String> list = new ArrayList<>();
        ref.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    Runnable r = new Runnable() {
                        @Override
                        public void run() {
                            for (QueryDocumentSnapshot snapshot : task.getResult()) {
                                list.add(snapshot.getString("name"));
                            }
                        }
                    };
                    r.run();

                    ArrayAdapter arrayAdapter = new ArrayAdapter(PatientDashboard.this, android.R.layout.simple_list_item_1, list);
                    listView.setAdapter(arrayAdapter);
                } else {
                    Log.d("Doctor", "Not Loaded");
                }
            }
        });


        listView.setClickable(true);
        Log.d("Data Patient", String.valueOf(list));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String docName = (String) listView.getItemAtPosition(i);

                CollectionReference appRef = db.collection("appointment");

                ref.whereEqualTo("name", docName).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot snapshot : task.getResult()) {
                                long token = snapshot.getLong("token");
                                String docId = snapshot.getId();

                                Map<String, Object> map = new HashMap<>();
                                map.put("uid", getIntent().getStringExtra("name"));
                                map.put("docId", docId);

                                appRef.document("AppID").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                        if (task.isSuccessful()) {
                                            long appId = task.getResult().getLong("currentAppId") + 1;
                                            map.put("isVerified", false);
                                            map.put("token", 0);
                                            appRef.document("AppID").update("currentAppId", appId).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void unused) {
                                                    appRef.document(String.valueOf(appId)).set(map);


                                                    Intent intent = new Intent(PatientDashboard.this, MenuActivity.class);
                                                    intent.putExtra("name", getIntent().getStringExtra("name"));
                                                    startActivity(intent);
                                                    KToast.customBackgroudToast(PatientDashboard.this, "Appointment Booked", Gravity.BOTTOM, KToast.LENGTH_AUTO, R.drawable.background_toast, null ,R.drawable.ic_infinite_white);
                                                    finish();
                                                }

                                                ;
                                            });
                                        }
                                    }

                                    ;
                                });
                            }
                        }
                    }
                });
            }
        });





    }
}