package com.example.hustlers;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class GetTokens {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String name;

    public List<String> getList(String uid) {

        CollectionReference appRef = db.collection("appointment");

        List<String> list = new ArrayList<>();

        appRef.whereEqualTo("uid", uid).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for (QueryDocumentSnapshot query : task.getResult()) {

                    String docId = query.getString("docId");
                    if (docId.equals("001"))
                        name = "Harsh";
                    else if (docId.equals("002"))
                        name = "Ashwim";
                    else if (docId.equals("003"))
                        name = "Savio";
                    else if (docId.equals("004"))
                        name = "Sarthak";

                    list.add(query.getId() + " " + name + " " + query.getBoolean("isVerified") + " " + query.getLong("token"));
                }
            }
        });

        return list;
    }
}
