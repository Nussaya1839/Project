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

public class PuzzleBody10 extends AppCompatActivity {
    ImageView imv1, imv2, imv3, imv4;
    ImageView imA, imU, imW, imK;
    private String msg = "debug";
    private int score = 0;
    private String strscore, strReceiveScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_body10);
        final MediaPlayer correct = MediaPlayer.create(this, R.raw.correct);
        final MediaPlayer incorrect = MediaPlayer.create(this, R.raw.incorrect);

        strReceiveScore = getIntent().getStringExtra("score");
        score = Integer.parseInt(strReceiveScore);
        imA= (ImageView) findViewById(R.id.imA);
        imU= (ImageView) findViewById(R.id.imU);
        imW= (ImageView) findViewById(R.id.imW);
        imK= (ImageView) findViewById(R.id.imK);
        imv1 = (ImageView) findViewById(R.id.imv1);

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

        imU.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imU);

                return true;
            }
        });

        imW.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imW);

                v.startDrag(dragData, myShadow, null, 0);
                return true;
            }
        });

        imK.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imK);

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
                        if ((itemId == R.id.imA)) {
                            incorrect.start();
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv1.getX();
                            float gy = imv1.getY();
                            imA.setX(gx);
                            imA.setY(gy);
                            delay();
                        }
                        if (itemId == R.id.imU) {
                            incorrect.start();
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv1.getX();
                            float gy = imv1.getY();
                            imU.setX(gx);
                            imU.setY(gy);
                            delay();
                        }
                        if ((itemId == R.id.imW)) {
                            incorrect.start();
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv1.getX();
                            float gy = imv1.getY();
                            imW.setX(gx);
                            imW.setY(gy);
                            delay();
                        }
                        if ((itemId == R.id.imK)) {
                            correct.start();
                            score++;
                            Toast.makeText(getApplicationContext(), "ถูกต้อง", Toast.LENGTH_LONG).show();
                            float gx = imv1.getX();
                            float gy = imv1.getY();
                            imK.setX(gx);
                            imK.setY(gy);
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
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(imA);

                    imA.startDrag(data, shadowBuilder, imA, 0);

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
        imW.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("id", "" + imW.getId());
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(imW);

                    imW.startDrag(data, shadowBuilder, imW, 0);

                    return true;
                } else {
                    return false;
                }
            }
        });
        imK.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("id", "" + imK.getId());
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(imK);

                    imK.startDrag(data, shadowBuilder, imK, 0);

                    return true;
                } else {
                    return false;
                }
            }
        });

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
        }, 1000);
    }

    public void onBackPressed() {
        startActivity(new Intent(this, ListPuzzle.class));
    }
}
