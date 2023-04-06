package com.example.hustlers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class DoctorActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    ListView listDoctor;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        listDoctor = (ListView) findViewById(R.id.listDoctor);

        CollectionReference appRef = db.collection("appointment");

        List<String> list = new ArrayList<>();

        db.collection("doctor").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()) {
                    List<DocumentSnapshot> l = queryDocumentSnapshots.getDocuments();
                    for (DocumentSnapshot d : l) {

                        list.add("Doctor Name: "+d.getString("name")+ "\nRoom No: " + d.getLong("room") + "\nNo. of Appointments: " + d.getLong("token"));
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(DoctorActivity.this, android.R.layout.simple_list_item_1, list);
                    listDoctor.setAdapter(arrayAdapter);
                }
            }
        });

    }
}