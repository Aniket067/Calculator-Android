package com.example.calculator;

import android.content.Intent;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

public class Quadratic_Equation extends AppCompatActivity {
    TextView homescreen;
    private TextView ans;
    private EditText a;
    private EditText b;
    private EditText c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratic_equation);
        homescreen=findViewById(R.id.home_screen1);
        Button submit = findViewById(R.id.button);
        ans=findViewById(R.id.textView37);
        a=findViewById(R.id.editTextNumberSigned);
        b=findViewById(R.id.editTextNumberSigned2);
        c=findViewById(R.id.editTextNumberSigned3);
        Intent intent = new Intent(this,MainActivity.class);
        Vibrator vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        homescreen.setOnClickListener(v -> {
            startActivity(intent);
            finish();
        });
        submit.setOnClickListener(v -> {
            String a1 = a.getText().toString();
            String b1 = b.getText().toString();
            String c1 = c.getText().toString();
            float a=Float.parseFloat(a1);
            float b=Float.parseFloat(b1);
            float c=Float.parseFloat(c1);
            double d;
            if(Build.VERSION.SDK_INT >=26){
                vibrator.vibrate(VibrationEffect.createOneShot(80,VibrationEffect.DEFAULT_AMPLITUDE));
            }
            else{
                vibrator.vibrate(100);
            }

            d= ((b * b) - (4 * a * c));


            if (d > 0) {
                Toast.makeText(Quadratic_Equation.this, "Real and diffrent roots", Toast.LENGTH_SHORT).show();
                double x = (Math.floor(((-b + Math.pow(((b * b) - 4 * a * c), 0.5)) / (2 * a)) * 10000)) / 10000;
                double y = (Math.floor(((-b - Math.pow(((b * b) - 4 * a * c), 0.5)) / (2 * a)) * 10000)) / 10000;

                ans.setText("Roots Are =  " + '\n' + '\n' + x + " , " + '\n' + '\n' + y);
            }
            if (d == 0.0) {
                Toast.makeText(Quadratic_Equation.this, "Perfect Square One root", Toast.LENGTH_SHORT).show();
                double x = (Math.floor((-b) / (2 * a) * 10000)) / 10000;

                ans.setText("Root Are = " + '\n' + '\n' + x);
            }
            if (d < 0) {
                Toast.makeText(Quadratic_Equation.this, "Imaginary roots", Toast.LENGTH_SHORT).show();
                double floor = Math.floor(((-b) / (2 * a)) * 10000);
                double x = (Math.floor(((-b) / (2 * a)) * 10000)) / 10000;
                double y = (Math.floor((Math.pow((-((b * b) - (4 * a * c))), 0.5) / (2 * a)) * 10000)) / 10000;

                ans.setText("complex roots are = " + '\n' + '\n' + x + " + " + y + "i , " + '\n' + '\n' + x + " - " + y + "i");
            }
        });
    }
    public void retry1(View v){
        Intent intent = new Intent(this,Quadratic_Equation.class);
        startActivity(intent);
        finish();
    }
}