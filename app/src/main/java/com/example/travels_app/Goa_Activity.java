package com.example.travels_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Goa_Activity extends AppCompatActivity {
    ImageView imageView13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_goa);
        imageView13=findViewById(R.id.imageView13);

        imageView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Goa_Activity.this, DetailsActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}