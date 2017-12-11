package com.example.ss.gameforkids;


import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ListenFamily1 extends AppCompatActivity {
    ImageView imvSpeaker, imvSend;
    RadioGroup raG;
    RadioButton ra1, ra2, ra3, ra4;
    private int score = 0;
    private String strscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_listen_family1 );

        ra1 = (RadioButton)findViewById(R.id.ra1);
        ra2 = (RadioButton)findViewById(R.id.ra2);
        ra3 = (RadioButton)findViewById(R.id.ra3);
        ra4 = (RadioButton)findViewById(R.id.ra4);
        raG = (RadioGroup)findViewById(R.id.raG);

        imvSpeaker = (ImageView) findViewById( R.id.imvSpeaker );
        final MediaPlayer grandfather = MediaPlayer.create( ListenFamily1.this, R.raw.grandfather );
        imvSpeaker.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grandfather.start();
            }
        } );

        imvSend = (ImageView)findViewById( R.id.imvSend );
        imvSend.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ra3.isChecked()){
                    score++;
                    Toast.makeText(getApplicationContext(), "ถูกต้อง", Toast.LENGTH_LONG).show();
                    enable( false );
                    delay();
                }
                else if(ra1.isChecked() || ra2.isChecked() || ra4.isChecked()){
                    Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                    enable( false );
                    delay();
                }
            }
        } );
    }

    protected boolean enabled = true;
    public void enable(boolean b) {
        enabled = b;
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return enabled ?
                super.dispatchTouchEvent(ev) :
                true;
    }

    private void delay() {
        android.os.Handler myhandler = new android.os.Handler();
        myhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent nextquest = new Intent(getApplicationContext(), ListenFamily2.class);
                strscore = Integer.toString(score);
                nextquest.putExtra("score", strscore);
                startActivity(nextquest);

            }
        }, 3000);
    }
}
