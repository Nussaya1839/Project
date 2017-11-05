package com.example.ss.gameforkids;

import android.content.ClipData;
import android.content.ClipDescription;
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

public class PuzzleBathroom2 extends AppCompatActivity {
    ImageView imv1, imv2, imv3, imv4;
    ImageView imB, imF, imP, imL;
    private String msg = "debug";
    private int score = 0;
    private String strscore, strReceiveScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_bathroom2);

        strReceiveScore = getIntent().getStringExtra("score");
        score = Integer.parseInt(strReceiveScore);
        imB= (ImageView) findViewById(R.id.imB);
        imF= (ImageView) findViewById(R.id.imF);
        imP= (ImageView) findViewById(R.id.imP);
        imL= (ImageView) findViewById(R.id.imL);
        imv4 = (ImageView) findViewById(R.id.imv4);

        imB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imB);

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

                return true;
            }
        });

        imP.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imP);

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

                v.startDrag(dragData, myShadow, null, 0);
                return true;
            }
        });

        imv4.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()) {
                    case DragEvent.ACTION_DROP:
                        Log.d(msg, "ACTION_DROP event " + event.getClipData().getItemAt(0).getText());
                        int itemId = Integer.parseInt((String) event.getClipData().getItemAt(0).getText());
                        if ((itemId == R.id.imB)) {
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv4.getX();
                            float gy = imv4.getY();
                            imB.setX(gx);
                            imB.setY(gy);
                            delay();

                        }
                        if (itemId == R.id.imF) {
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv4.getX();
                            float gy = imv4.getY();
                            imF.setX(gx);
                            imF.setY(gy);
                            delay();
                        }
                        if ((itemId == R.id.imP)) {
                            score++;
                            Toast.makeText(getApplicationContext(), "ถูกต้อง", Toast.LENGTH_LONG).show();
                            float gx = imv4.getX();
                            float gy = imv4.getY();
                            imP.setX(gx);
                            imP.setY(gy);
                            delay();
                        }
                        if ((itemId == R.id.imL)) {
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv4.getX();
                            float gy = imv4.getY();
                            imL.setX(gx);
                            imL.setY(gy);
                            delay();
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        imB.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("id", "" + imB.getId());
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(imB);

                    imB.startDrag(data, shadowBuilder, imB, 0);

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
        imP.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("id", "" + imP.getId());
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(imP);

                    imP.startDrag(data, shadowBuilder, imP, 0);

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

    }

    private void delay() {
        android.os.Handler myhandler = new android.os.Handler();
        myhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent nextquest = new Intent(getApplicationContext(), PuzzleBathroom3.class);
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
