package com.examplebus.user.busapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class Details extends AppCompatActivity {
    //public Button but3;




    public Button button1,button2,button3,button4 ;

    public void init()
    {
         button1 = findViewById(R.id.getdistancebutton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clickthree=new Intent(Details.this,MapsAcitvity.class));                startActivity(clickthree);

            }
        });
    }
    public void init1()
    {
        button2=findViewById(R.id.buttonlocation);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent click=new Intent(details.this,Location.class);              startActivity(click);
            }
        });
    }
    public void init2()
    {

        button3=findViewById(R.id.notificationbutton);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent click1=new Intent(Details.this,Notification.class);
                startActivity(click1);
            }
        });

    }
    public void init3()
    {

        button3=findViewById(R.id.speedbutton);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent click2=new Intent(Details.this,SpeedTracker.class);
                startActivity(click2);
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        init();
        init1();
        init2();
        init3();
            }

    }


}

