package com.example.ss.gameforkids;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class PuzzleColor10 extends AppCompatActivity {
    ImageView imv1, imv2, imv3, imv4, imv5, imv6;
    ImageView imU, imL, imV, imW;
    private String msg = "debug";
    private int score = 0;
    private String strscore, strReceiveScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_color10);

        strReceiveScore = getIntent().getStringExtra("score");
        score = Integer.parseInt(strReceiveScore);
        imU= (ImageView) findViewById(R.id.imU);
        imL= (ImageView) findViewById(R.id.imL);
        imV= (ImageView) findViewById(R.id.imV);
        imW= (ImageView) findViewById(R.id.imW);
        imv6 = (ImageView) findViewById(R.id.imv6);

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

        imL.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imL);

                return true;
            }
        });

        imV.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imV);

                v.startDrag(dragData, myShadow, null, 0);
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

        imv6.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()) {
                    case DragEvent.ACTION_DROP:
                        Log.d(msg, "ACTION_DROP event " + event.getClipData().getItemAt(0).getText());
                        int itemId = Integer.parseInt((String) event.getClipData().getItemAt(0).getText());
                        if ((itemId == R.id.imU)) {
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv6.getX();
                            float gy = imv6.getY();
                            imU.setX(gx);
                            imU.setY(gy);
                            delay();

                        }
                        if (itemId == R.id.imL) {
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv6.getX();
                            float gy = imv6.getY();
                            imL.setX(gx);
                            imL.setY(gy);
                            delay();
                        }
                        if ((itemId == R.id.imV)) {
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv6.getX();
                            float gy = imv6.getY();
                            imV.setX(gx);
                            imV.setY(gy);
                            delay();
                        }
                        if ((itemId == R.id.imW)) {
                            score++;
                            Toast.makeText(getApplicationContext(), "ถูกต้อง", Toast.LENGTH_LONG).show();
                            float gx = imv6.getX();
                            float gy = imv6.getY();
                            imW.setX(gx);
                            imW.setY(gy);
                            delay();
                        }
                        break;
                    default:
                        break;
                }
                return true;
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
        imL.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("id", "" + imL.getId());
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(imL);

                    imL.startDrag(data, shadowBuilder, imL, 0);

                    return true;
                } else {
                    return false;
                }
            }
        });
        imV.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("id", "" + imV.getId());
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(imV);

                    imV.startDrag(data, shadowBuilder, imV, 0);

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

    }

    private void delay() {
        android.os.Handler myhandler = new android.os.Handler();
        myhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent nextquest = new Intent(getApplicationContext(), PuzzleAnimalFinal.class);
                strscore = Integer.toString(score);
                nextquest.putExtra("score", strscore);
                startActivity(nextquest);

            }
        }, 2000);
    }

    public void onBackPressed() {
        startActivity(new Intent(this, ListPuzzle.class));
    }
}
