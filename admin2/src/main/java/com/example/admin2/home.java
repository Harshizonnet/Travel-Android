package com.example.admin2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity {
    ImageView imageView,imageView2,imageView3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        imageView=findViewById(R.id.imageView);
        imageView2=findViewById(R.id.imageView6);
        imageView3=findViewById(R.id.imageView3);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(home.this, imagesuplode.class);
                startActivity(intent);
                finish();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, datauplod.class);
                startActivity(intent);
                finish();

            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(home.this, bookinRdrive.class);
                startActivity(intent);
                finish();
            }
        });
    }
}