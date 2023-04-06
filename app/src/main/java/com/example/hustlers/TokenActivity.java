package com.example.hustlers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hustlers.Admin.AdminDashboard;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class TokenActivity extends AppCompatActivity {


    FirebaseFirestore db = FirebaseFirestore.getInstance();
    ListView listToken;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token_acticity);

        listToken = (ListView) findViewById(R.id.listToken);
        GetTokens getTokens = new GetTokens();
        String uid = getIntent().getStringExtra("uid");


        CollectionReference appRef = db.collection("appointment");

        List<String> list = new ArrayList<>();

        appRef.whereEqualTo("uid", uid).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if(!queryDocumentSnapshots.isEmpty()){
                    List<DocumentSnapshot> l = queryDocumentSnapshots.getDocuments();
                    for (DocumentSnapshot d : l) {
                        String docId = d.getString("docId");
                        if (docId.equals("001"))
                            name = "Harsh";
                        else if (docId.equals("002"))
                            name = "Ashwin";
                        else if (docId.equals("003"))
                            name = "Savio";
                        else if (docId.equals("004"))
                            name = "Sarthak";

                        list.add("ApplicationID: "+d.getId()+"\nDoctor Name: "+name+"\nVerified: "+d.getBoolean("isVerified")+"\nToken: "+d.getLong("token"));
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(TokenActivity.this, android.R.layout.simple_list_item_1, list);
                    listToken.setAdapter(arrayAdapter);
                }
            }
        });
    }
}