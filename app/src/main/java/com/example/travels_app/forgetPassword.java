package com.example.travels_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgetPassword extends AppCompatActivity {
    Button button;
    EditText emails,password;
    Button forgetbutton;
    String email;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_forget_password);
       mAuth =FirebaseAuth.getInstance();
        emails=findViewById(R.id.emails);
        forgetbutton=findViewById(R.id.button2);
        forgetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateDate();
            }

            private void validateDate() {
                email=emails.getText().toString();
                if (email.isEmpty()){
                    emails.setError("Required");
                }else {
                    forgetpassword();
                }
            }
        });
    }

    private void forgetpassword() {
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(forgetPassword.this, "check your email", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(forgetPassword.this, Login.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(forgetPassword.this, "Error: "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}