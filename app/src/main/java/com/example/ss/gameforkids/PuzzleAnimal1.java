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

public class PuzzleAnimal1 extends AppCompatActivity {
    ImageView imv1, imv2, imv3, imv4;
    ImageView imA, imE, imO, imR;
    private String msg = "debug";
    private int score = 0;
    private String strscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_animal1);
        final MediaPlayer correct = MediaPlayer.create(this, R.raw.correct);
        final MediaPlayer incorrect = MediaPlayer.create(this, R.raw.incorrect);

        imA= (ImageView) findViewById(R.id.imA);
        imE= (ImageView) findViewById(R.id.imE);
        imO= (ImageView) findViewById(R.id.imO);
        imR= (ImageView) findViewById(R.id.imR);
        imv3 = (ImageView) findViewById(R.id.imv3);

        imA.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imA);

                v.startDrag(dragData, myShadow, null, 0);
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

                return true;
            }
        });

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

        imR.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imR);

                v.startDrag(dragData, myShadow, null, 0);
                return true;
            }
        });

        imv3.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()) {
                    case DragEvent.ACTION_DROP:
                        Log.d(msg, "ACTION_DROP event " + event.getClipData().getItemAt(0).getText());
                        int itemId = Integer.parseInt((String) event.getClipData().getItemAt(0).getText());
                        if ((itemId == R.id.imA)) {
                            correct.start();
                            score++;
                            Toast.makeText(getApplicationContext(), "ถูกต้อง", Toast.LENGTH_LONG).show();
                            float gx = imv3.getX();
                            float gy = imv3.getY();
                            imA.setX(gx);
                            imA.setY(gy);
                            enable( false );
                            delay();
                        }
                        if (itemId == R.id.imE) {
                            incorrect.start();
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv3.getX();
                            float gy = imv3.getY();
                            imE.setX(gx);
                            imE.setY(gy);
                            enable( false );
                            delay();
                        }  if ((itemId == R.id.imO)) {
                            incorrect.start();
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv3.getX();
                            float gy = imv3.getY();
                            imO.setX(gx);
                            imO.setY(gy);
                            enable( false );
                            delay();
                        }
                        if ((itemId == R.id.imR)) {
                            incorrect.start();
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv3.getX();
                            float gy = imv3.getY();
                            imR.setX(gx);
                            imR.setY(gy);
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

        imA.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("id", "" + imA.getId());
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder( imA);

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
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder( imE);

                    imE.startDrag(data, shadowBuilder, imE, 0);

                    return true;
                } else {
                    return false;
                }
            }
        });
        imO.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("id", "" + imO.getId());
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder( imO);

                    imO.startDrag(data, shadowBuilder, imO, 0);

                    return true;
                } else {
                    return false;
                }
            }
        });
        imR.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("id", "" + imR.getId());
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder( imR);

                    imR.startDrag(data, shadowBuilder, imR, 0);

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
                Intent nextquest = new Intent(getApplicationContext(), PuzzleAnimal2.class);
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
