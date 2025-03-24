package com.example.travels_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class New_Registration extends AppCompatActivity {
    EditText editTextemail, editTextpassword;
    Button btnreg;
    TextView textView;
    FirebaseAuth mAuth;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_registration);
        mAuth=FirebaseAuth.getInstance();
        editTextemail=findViewById(R.id.regemail);
        editTextpassword=findViewById(R.id.regpass);
        btnreg= findViewById(R.id.btnreg);
        textView= findViewById(R.id.loginnow);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(New_Registration.this,Login.class);
                startActivity(intent2);
                finish();
            }
        });


        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email,password;
                email= String.valueOf(editTextemail.getText());
                password=String.valueOf(editTextpassword.getText());
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(New_Registration.this, "enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(New_Registration.this, "enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                //fb doc mathi copy
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(New_Registration.this, "Account created.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent= new Intent(getApplicationContext(),Home_Page.class);
                                    startActivity( intent);

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(New_Registration.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        //password visible unvisible code

    }
}
