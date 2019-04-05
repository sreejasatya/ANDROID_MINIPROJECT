package com.examplebus.user.busapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.BreakIterator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    public static long endTime;
    public static long startTime;
    public static BreakIterator time;
    public static int p;
    public static BreakIterator speed;
    public static BreakIterator dist;
    public static DialogInterface locate;
    public Button but1;
    public void init()
    {
        but1= findViewById(R.id.startbutton);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent click=new Intent(MainActivity.this,LoginPage.class);
                startActivity(click);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
}
