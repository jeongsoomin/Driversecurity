package com.example.goldentime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView timertv;
    private Button backbt;
    private CountDownTimer countdown ;
    private int remainingtime=30;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        timertv = findViewById(R.id.timertv);
        backbt = findViewById(R.id.backbt);

        countdown=new CountDownTimer(30000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                remainingtime=(int)millisUntilFinished/1000;
                timertv.setText(String.valueOf(remainingtime));
            }

            @Override
            public void onFinish() {
                timertv.setText("Finished");//30초 타이머가 끝나면 자동으로 지도페이지로 넘어가게
                Intent intent = new Intent(MainActivity2.this, MapsActivity.class);
                startActivity(intent);


            }
        };
        countdown.start();
        backbt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}