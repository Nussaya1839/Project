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

public class PuzzleAnimal9 extends AppCompatActivity {
    ImageView imv1, imv2, imv3, imv4, imv5;
    ImageView imS, imC, imZ, imF;
    private String msg = "debug";
    private int score = 0;
    private String strscore, strReceiveScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_animal9);
        final MediaPlayer correct = MediaPlayer.create(this, R.raw.correct);
        final MediaPlayer incorrect = MediaPlayer.create(this, R.raw.incorrect);

        strReceiveScore = getIntent().getStringExtra("score");
        score = Integer.parseInt(strReceiveScore);
        imS= (ImageView) findViewById(R.id.imS);
        imC= (ImageView) findViewById(R.id.imC);
        imZ= (ImageView) findViewById(R.id.imZ);
        imF= (ImageView) findViewById(R.id.imF);
        imv1 = (ImageView) findViewById(R.id.imv1);

        imS.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imS);

                v.startDrag(dragData, myShadow, null, 0);
                return true;
            }
        });

        imC.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imC);

                return true;
            }
        });

        imZ.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imZ);

                v.startDrag(dragData, myShadow, null, 0);
                return true;
            }
        });

        imF.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imF);

                v.startDrag(dragData, myShadow, null, 0);
                return true;
            }
        });

        imv1.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()) {
                    case DragEvent.ACTION_DROP:
                        Log.d(msg, "ACTION_DROP event " + event.getClipData().getItemAt(0).getText());
                        int itemId = Integer.parseInt((String) event.getClipData().getItemAt(0).getText());
                        if ((itemId == R.id.imS)) {
                            incorrect.start();
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv1.getX();
                            float gy = imv1.getY();
                            imS.setX(gx);
                            imS.setY(gy);
                            enable( false );
                            delay();

                        }
                        if (itemId == R.id.imC) {
                            incorrect.start();
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv1.getX();
                            float gy = imv1.getY();
                            imC.setX(gx);
                            imC.setY(gy);
                            enable( false );
                            delay();
                        }
                        if ((itemId == R.id.imZ)) {
                            correct.start();
                            score++;
                            Toast.makeText(getApplicationContext(), "ถูกต้อง", Toast.LENGTH_LONG).show();
                            float gx = imv1.getX();
                            float gy = imv1.getY();
                            imZ.setX(gx);
                            imZ.setY(gy);
                            enable( false );
                            delay();
                        }
                        if ((itemId == R.id.imF)) {
                            incorrect.start();
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv1.getX();
                            float gy = imv1.getY();
                            imF.setX(gx);
                            imF.setY(gy);
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

        imS.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("id", "" + imS.getId());
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(imS);

                    imS.startDrag(data, shadowBuilder, imS, 0);
                    return true;
                } else {
                    return false;
                }
            }
        });
        imC.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("id", "" + imC.getId());
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(imC);

                    imC.startDrag(data, shadowBuilder, imC, 0);

                    return true;
                } else {
                    return false;
                }
            }
        });
        imZ.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("id", "" + imZ.getId());
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(imZ);

                    imZ.startDrag(data, shadowBuilder, imZ, 0);

                    return true;
                } else {
                    return false;
                }
            }
        });
        imF.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("id", "" + imF.getId());
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(imF);

                    imF.startDrag(data, shadowBuilder, imF, 0);

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
                Intent nextquest = new Intent(getApplicationContext(), PuzzleAnimal10.class);
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
