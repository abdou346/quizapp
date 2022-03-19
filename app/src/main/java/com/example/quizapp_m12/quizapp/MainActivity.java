package com.example.quizapp_m12.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText mail;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

// ...
// Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_main);
        mail= findViewById(R.id.etLogin);
       password= findViewById(R.id.etPassword);
       Button b1= findViewById(R.id.bLogin);
       TextView t1= findViewById(R.id.tvRegister);
        b1.setOnClickListener(view -> {
            loginuser();

        });
        t1.setOnClickListener(v -> {
            Intent i = new Intent(this, register.class);
            startActivity(i);
        });
    }
    public void loginuser(){
        String email= mail.getText().toString();
        String pass=password.getText().toString();
        if (TextUtils.isEmpty(email)){
            mail.setError("email cannot be empty");
            mail.requestFocus();
        }else if (TextUtils.isEmpty(pass)){
            password.setError("password cannot be empty");
            password.requestFocus();
        } else{
            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(MainActivity.this, "Success",
                                Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,question1.class));
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    }




