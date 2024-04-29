package com.example.calculator;

import android.content.Intent;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.media.MediaPlayer;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
TextView one,two,three,four,five,six,seven,eight,nine,zero,dot,plus,minus,div,multiply,equal,back,clear,on_bracket,off_bracket,status;
ImageButton tools_screen;
String answer;
String ans="";
boolean symbol=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clear=findViewById(R.id.textView1);
        status=findViewById(R.id.textView23);
        back=findViewById(R.id.textView2);
        one=findViewById(R.id.textView13);
        two=findViewById(R.id.textView14);
        three=findViewById(R.id.textView15);
        four=findViewById(R.id.textView9);
        five=findViewById(R.id.textView10);
        six=findViewById(R.id.textView11);
        seven=findViewById(R.id.textView5);
        eight=findViewById(R.id.textView6);
        nine=findViewById(R.id.textView7);
        dot=findViewById(R.id.textView17);
        zero=findViewById(R.id.textView18);
        plus=findViewById(R.id.textView20);
        minus=findViewById(R.id.textView16);
        div=findViewById(R.id.textView8);
        multiply=findViewById(R.id.textView12);
        equal=findViewById(R.id.textView19);
        tools_screen=findViewById(R.id.imageButton);
        on_bracket=findViewById(R.id.textView3);
        off_bracket=findViewById(R.id.textView4);
        Vibrator vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        final MediaPlayer tone= MediaPlayer.create(this,R.raw.touchtone);
        Intent intent= new Intent(this,Maths_tools_page.class);
        one.setOnClickListener(v -> {
            tone.start();
            ans=ans+"1";
            status.setText(ans);
            symbol=false;
        });
        two.setOnClickListener(v -> {
            tone.start();
            ans=ans+"2";
            status.setText(ans);
            symbol=false;
        });
        three.setOnClickListener(v -> {
            tone.start();
            ans=ans+"3";
            status.setText(ans);
            symbol=false;
        });
        four.setOnClickListener(v -> {
            tone.start();
            ans=ans+"4";
            status.setText(ans);
            symbol=false;
        });
        five.setOnClickListener(v -> {
            tone.start();
            ans=ans+"5";
            status.setText(ans);
            symbol=false;
        });
        six.setOnClickListener(v -> {
            tone.start();
            ans=ans+"6";
            status.setText(ans);
            symbol=false;
        });
        seven.setOnClickListener(v -> {
            tone.start();
            ans=ans+"7";
            status.setText(ans);
            symbol=false;
        });
        eight.setOnClickListener(v -> {
            tone.start();
            ans=ans+"8";
            status.setText(ans);
            symbol=false;
        });
        nine.setOnClickListener(v -> {
            tone.start();
            ans=ans+"9";
            status.setText(ans);
            symbol=false;
        });
        zero.setOnClickListener(v -> {
            tone.start();
            ans=ans+"0";
            status.setText(ans);
            symbol=false;
        });
        dot.setOnClickListener(v -> {
            tone.start();
            ans=ans+".";
            status.setText(ans);
            symbol=false;

        });
        multiply.setOnClickListener(v -> {
            if(!symbol){
                ans=ans+" * ";
                status.setText(ans);
                symbol=true;
            }

        });
        plus.setOnClickListener(v -> {
            if(!symbol){
                ans=ans+"+";
                status.setText(ans);
                symbol=true;
            }
        });
        minus.setOnClickListener(v -> {
            ans=ans+"-";
            status.setText(ans);
            symbol=true;
        });
        div.setOnClickListener(v -> {
            if(!symbol){
                ans=ans+" / ";
                status.setText(ans);
                symbol=true;
            }
        });

        back.setOnClickListener(v -> {
            int strlen =ans.length();
            if (strlen==0){
                Toast.makeText(MainActivity.this, "Enter Expression", Toast.LENGTH_SHORT).show();
            }
            else if (symbol){
                    ans=ans.substring(0,strlen-3);
                    status.setText(ans);
                    symbol=false;
                }
            else {
                ans = ans.substring(0, strlen-1);
                status.setText(ans);
            }
        });
        equal.setOnClickListener(v -> {
            if(Build.VERSION.SDK_INT >=26){
                vibrator.vibrate(VibrationEffect.createOneShot(100,VibrationEffect.DEFAULT_AMPLITUDE));
            }
            else{
                vibrator.vibrate(100);
            }

            Expression exp = new Expression(ans);
            answer= String.valueOf(exp.calculate());
            double d=Double.parseDouble(answer);
            int answer2= ((int) d);
            if(d == answer2 ){
                answer=Integer.toString(answer2);
                status.setText(answer);
            }
           else {
                d = Math.floor(d * 1000) / 1000;
                ans = answer;
                answer = Double.toString(d);
                status.setText(answer);
            }
        });
        clear.setOnClickListener(v -> {
            ans="";
            status.setText(ans);
            symbol=true;
        });
        on_bracket.setOnClickListener(v -> {
            ans=ans+"(";
          status.setText(ans);
        });
        off_bracket.setOnClickListener(v -> {
            if(!symbol){
                ans=ans+")";
                status.setText(ans);
                symbol=true;
            }
        });
        tools_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);

            }
        });

    }
}