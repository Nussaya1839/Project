package com.example.ss.gameforkids;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.media.MediaPlayer;

public class PuzzleAnimal10 extends AppCompatActivity {
    ImageView imv1, imv2, imv3, imv4, imv5;
    ImageView imO, imA, imE, imU;
    private String msg = "debug";
    private int score = 0;
    private String strscore, strReceiveScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_animal10);
        final MediaPlayer correct = MediaPlayer.create(this, R.raw.correct);
        final MediaPlayer incorrect = MediaPlayer.create(this, R.raw.incorrect);

        strReceiveScore = getIntent().getStringExtra("score");
        score = Integer.parseInt(strReceiveScore);
        imO= (ImageView) findViewById(R.id.imO);
        imA= (ImageView) findViewById(R.id.imA);
        imE= (ImageView) findViewById(R.id.imE);
        imU= (ImageView) findViewById(R.id.imU);
        imv2 = (ImageView) findViewById(R.id.imv2);

        imO.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imO);

                v.startDrag(dragData, myShadow, null, 0);
                return true;
            }
        });

        imA.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imA);

                return true;
            }
        });

        imE.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imE);

                v.startDrag(dragData, myShadow, null, 0);
                return true;
            }
        });

        imU.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imU);

                v.startDrag(dragData, myShadow, null, 0);
                return true;
            }
        });

        imv2.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()) {
                    case DragEvent.ACTION_DROP:
                        Log.d(msg, "ACTION_DROP event " + event.getClipData().getItemAt(0).getText());
                        int itemId = Integer.parseInt((String) event.getClipData().getItemAt(0).getText());
                        if ((itemId == R.id.imO)) {
                            correct.start();
                            score++;
                            Toast.makeText(getApplicationContext(), "ถูกต้อง", Toast.LENGTH_LONG).show();
                            float gx = imv2.getX();
                            float gy = imv2.getY();
                            imO.setX(gx);
                            imO.setY(gy);
                            enable( false );
                            delay();

                        }
                        if (itemId == R.id.imA) {
                            incorrect.start();
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv2.getX();
                            float gy = imv2.getY();
                            imA.setX(gx);
                            imA.setY(gy);
                            enable( false );
                            delay();
                        }
                        if ((itemId == R.id.imE)) {
                            incorrect.start();
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv2.getX();
                            float gy = imv2.getY();
                            imE.setX(gx);
                            imE.setY(gy);
                            enable( false );
                            delay();
                        }
                        if ((itemId == R.id.imU)) {
                            incorrect.start();
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv2.getX();
                            float gy = imv2.getY();
                            imU.setX(gx);
                            imU.setY(gy);
                            enable( false );
                            delay();
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        imO.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("id", "" + imO.getId());
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(imO);

                    imO.startDrag(data, shadowBuilder, imO, 0);

                    return true;
                } else {
                    return false;
                }
            }
        });
        imA.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("id", "" + imA.getId());
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(imA);

                    imA.startDrag(data, shadowBuilder, imA, 0);

                    return true;
                } else {
                    return false;
                }
            }
        });
        imE.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("id", "" + imE.getId());
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(imE);

                    imE.startDrag(data, shadowBuilder, imE, 0);

                    return true;
                } else {
                    return false;
                }
            }
        });
        imU.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("id", "" + imU.getId());
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(imU);

                    imU.startDrag(data, shadowBuilder, imU, 0);

                    return true;
                } else {
                    return false;
                }
            }
        });

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
                Intent nextquest = new Intent(getApplicationContext(), PuzzleFinal.class);
                strscore = Integer.toString(score);
                nextquest.putExtra("score", strscore);
                startActivity(nextquest);

            }
        }, 3000);
    }

    public void onBackPressed() {
        startActivity(new Intent(this, ListPuzzle.class));
    }
}
