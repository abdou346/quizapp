package com.example.quizapp_m12.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.webkit.WebView;
import android.os.Handler;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Resultatfinale extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView progressText;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultatfinale);
        TextView TextView01 = (TextView) findViewById(R.id.te1);
        TextView01.setText("Votre score est de       "+Global.ivar1);
        Button b1= findViewById(R.id.retry);
        Button b2= findViewById(R.id.quit);
        progressBar = findViewById(R.id.progress_bar);
        progressText = findViewById(R.id.progress_text);
        progressText.setText(Global.ivar1*50+"%");
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (i*50 <= Global.ivar1*50) {

                    progressBar.setProgress(i*50);
                    i++;
                    handler.postDelayed(this, Global.ivar1*50);
                } else {
                    handler.removeCallbacks(this);
                }
            }
        }, Global.ivar1*50);
        b1.setOnClickListener(view -> {
            Intent i =new Intent(this,question1.class);
            Global.ivar1=0;
            startActivity(i);


        });
        b2.setOnClickListener(view -> {
            Intent i =new Intent(this,MainActivity.class);
            Global.ivar1=0;
            startActivity(i);


        });
    }
}