package com.example.travels_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.travels_app.model.Dataclass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class details_retrive extends AppCompatActivity {
    ImageView imageView;
    TextView textView,textView2,textView3,textView4,textView24;
    Button button;
    private String nodeId;
    DatabaseReference databaseReference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_details_retrive);
        imageView=findViewById(R.id.imageView2);
        textView=findViewById(R.id.editTextText);
        textView2=findViewById(R.id.editTextText2);
        textView3=findViewById(R.id.editTextText3);
        textView4=findViewById(R.id.editTextText4);
        textView24=findViewById(R.id.textView24);
        button=findViewById(R.id.button3);


        nodeId=getIntent().getStringExtra("nodeId");
displayDetails(nodeId);

    }
    public void displayDetails(String nodeId){
        databaseReference= FirebaseDatabase.getInstance().getReference("uploads").child(nodeId);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    Dataclass data=snapshot.getValue(Dataclass.class);
                        Glide.with(getApplicationContext()).load(data.getImageUrl()).into(imageView);
                    textView.setText(data.getName());
                    textView2.setText(data.getPrice());
                    textView3.setText(data.getAbout());
                    textView4.setText(data.getAbout());
                    textView24.setText(data.getLocation());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(details_retrive.this, bookhotel.class);
                startActivity(intent);
                finish();
            }
        });


    }
}