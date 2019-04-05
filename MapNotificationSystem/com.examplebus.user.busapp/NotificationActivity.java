package com.examplebus.user.busapp;

import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class SpeedTracker extends AppCompatActivity {
    private Chronometer chronometer;
    private long pauseoffset;
    private boolean running;
    TextView t;			
    public Button but1,but2,but3,but4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_tracker);
        chronometer=findViewById(R.id.chrono);
        init();
        t=findViewby(R.id.Text);
        but1=findViewById(R.id.buttonstart);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(SystemClock.elapsedRealtime()-pauseoffset==t.getText().toString())
{
  Toast.makeText(SpeedTracker.this,”YOU REACHED YOUR DESTINATION”,Toast.make_length()).show();
}

            }
        });

        but2=findViewById(R.id.buttonstop);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopchrono(v);
            }
        });
        but3=findViewById(R.id.buttonreset);
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetchrono(v);
            }
        });

    }

    public void startchrono(View V)
    {
        if(!running)
        {
            chronometer.setBase(SystemClock.elapsedRealtime()-pauseoffset);
            chronometer.start();
            running=true;
        }

    }
    public void stopchrono(View V)
    {
        if (running)
        {

            chronometer.stop();
            pauseoffset=SystemClock.elapsedRealtime()-chronometer.getBase();
            running=false;
        }

    }
    public void resetchrono(View V)
    {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseoffset=0;


    }
}

