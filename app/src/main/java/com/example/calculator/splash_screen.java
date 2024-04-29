package com.example.calculator;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class splash_screen extends AppCompatActivity {
    ImageView imgb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        imgb=findViewById(R.id.imageView);
        Intent intent = new Intent(this,MainActivity.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imgb.animate().alpha(0).setDuration(2000);
                startActivity(intent);
                finish();
            }
        },3000);
    }
    }
