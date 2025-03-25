package com.example.travels_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class acccount_creat extends AppCompatActivity {
    TextView textView3;
    TextView textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_acccount_creat);
        textView3=findViewById(R.id.textView3);
        textView4=findViewById(R.id.textView4);


        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(acccount_creat.this, New_Registration.class);
                startActivity(intent);
                finish();
            }
        });

      textView4.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(acccount_creat.this, Login.class);
              startActivity(intent);
              finish();
          }
      });

    }
}