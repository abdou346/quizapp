package com.example.quizapp_m12.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class question1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        Button b1 = findViewById(R.id.questionsuiv);
        RadioGroup radioGroup = findViewById(R.id.radiox);


        b1.setOnClickListener(view -> {
            int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            String selectedRbText = selectedRadioButton.getText().toString();


            if (selectedRbText.equals("cr7")) {
                Global.ivar1++;

            }

            Intent i = new Intent(this, question2.class);
            startActivity(i);



        });
    }
}