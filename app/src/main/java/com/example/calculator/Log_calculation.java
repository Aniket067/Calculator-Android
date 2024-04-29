package com.example.calculator;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Log_calculation extends AppCompatActivity {
    TextView homescreen;
    private Button submit;
    private TextView textView;
    private EditText base;
    private EditText value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_calculation);
        homescreen = findViewById(R.id.home_screen2);
        submit=findViewById(R.id.buttonsubmit);
        textView=findViewById(R.id.textView40);
        base=findViewById(R.id.editTextNumberSignedbase);
        value=findViewById(R.id.editTextNumberSignedvalue);
        Intent intent = new Intent(this, MainActivity.class);

        homescreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(intent);
              finish();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=base.getText().toString();
                String x=value.getText().toString();
                Double base= Double.parseDouble(s);
                Double value= Double.parseDouble(x);

                if (base==0 && value==0){
                    Toast.makeText(Log_calculation.this, "Enter the Base & value", Toast.LENGTH_SHORT).show();
                }
                else{
                if(value > 0) {

                    if (base == 1) {
                        Toast.makeText(Log_calculation.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    } else if (base < 0) {
                        Toast.makeText(Log_calculation.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Double d=(Math.log(value)/Math.log(base));
                       float f= d.floatValue();
                        textView.setText("Value   "+f);

                    }
                }
                else{
                    Toast.makeText(Log_calculation.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                 }
                }

            }
        });
    }

    public void retry2(View v){
        Intent intent = new Intent(this,Log_calculation.class);
        startActivity(intent);
        finish();
    }
}