package com.example.admin2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class bookinRdrive extends AppCompatActivity {

    RecyclerView bookingrecycleView;
    ArrayList<bookindataclass> list;
    DatabaseReference databaseReference;
    BookinAdpter adapte;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookin_rdrive);
        bookingrecycleView = findViewById(R.id.bookingrecycleView);
        databaseReference = FirebaseDatabase.getInstance().getReference("Hotelbook");
        list = new ArrayList<>();
        bookingrecycleView.setLayoutManager(new LinearLayoutManager(this));
        adapte = new BookinAdpter( this,list);
        bookingrecycleView.setAdapter(adapte);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                   bookindataclass bookindataclass = dataSnapshot.getValue(bookindataclass.class);
                    list.add(bookindataclass);
                }
                adapte.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });    }
}