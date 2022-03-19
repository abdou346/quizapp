package com.example.quizapp_m12.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText regmail;
    EditText regpass;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
         regmail=findViewById(R.id.mail);
        regpass=findViewById(R.id.Password);

        Button b1= findViewById(R.id.signup);
        b1.setOnClickListener(view -> {
            createuser();
        });

    }
    public void createuser(){
        String email= regmail.getText().toString();
        String pass=regpass.getText().toString();
        if (TextUtils.isEmpty(email)){
            regmail.setError("email cannot be empty");
            regmail.requestFocus();
        }else if (TextUtils.isEmpty(pass)){
            regpass.setError("password cannot be empty");
            regpass.requestFocus();
        } else{
            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(register.this, "Success",
                                Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(register.this,MainActivity.class));
                    }
                    else{
                        Toast.makeText(register.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}