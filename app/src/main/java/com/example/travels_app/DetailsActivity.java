package com.example.travels_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travels_app.adapter.MyAdapter;
import com.example.travels_app.adapter.OnClick;
import com.example.travels_app.model.Dataclass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity implements OnClick {
    private MyAdapter myAdapter;
    private RecyclerView mrecyclerView;

    private DatabaseReference mdatabaseReference;
    ArrayList<Dataclass> uploads;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_details);
        mrecyclerView=findViewById(R.id.place_recycler);
        uploads = new ArrayList<>();
        myAdapter = new MyAdapter(this, uploads,this);
        mrecyclerView.setHasFixedSize(true);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mrecyclerView.setAdapter(myAdapter);

        mdatabaseReference = FirebaseDatabase.getInstance().getReference("uploads");

        mdatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Dataclass data=dataSnapshot.getValue(Dataclass.class);
                    data.setNodeId(dataSnapshot.getKey());
                    uploads.add(data);
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Firebase", "Error fetching data", error.toException());
            }
        });
    }

    @Override
    public void ItemOnClick(String nodeId) {
        Log.d("nodeId","Node Id "+nodeId);
        Intent i=new Intent(getApplicationContext(),details_retrive.class);
        i.putExtra("nodeId",nodeId);
        startActivity(i);
    }
}

