package com.example.admin2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginA extends AppCompatActivity {
    EditText editTextemail, editTextpassword;
    Button btnlogin;
    TextView textView,textView1;
    FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logina);
        mAuth=FirebaseAuth.getInstance();
        editTextemail=findViewById(R.id.emails);
        editTextpassword=findViewById(R.id.password);
        btnlogin= findViewById(R.id.button2);
        textView1=findViewById(R.id.forgotpassword);
        textView= findViewById(R.id.backRegistration);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(loginA.this,RegistrationA.class);
                startActivity(intent2);
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(loginA.this,forgetpassword.class);
                startActivity(intent2);
            }
        });





        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email,password;
                email= String.valueOf(editTextemail.getText());
                password=String.valueOf(editTextpassword.getText());
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(loginA.this, "enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(loginA.this, "enter password", Toast.LENGTH_SHORT).show();
                    return;
                }





                // fb documentation(call function "sign in  email & paswd")
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(loginA.this, "login successfull.", Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(getApplicationContext(),home.class);
                            startActivity(intent);
                            finish();

                        } else {

                            Toast.makeText(loginA.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                        }
                    }
                });


            }
        });

    }
}