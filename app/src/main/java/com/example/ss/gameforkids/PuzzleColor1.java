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

public class PuzzleColor1 extends AppCompatActivity {
    ImageView imv1, imv2, imv3, imv4;
    ImageView imE, imA, imI, imO;
    private String msg = "debug";
    private int score = 0;
    private String strscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_color1);

        imE= (ImageView) findViewById(R.id.imE);
        imA= (ImageView) findViewById(R.id.imA);
        imI= (ImageView) findViewById(R.id.imI);
        imO= (ImageView) findViewById(R.id.imO);
        imv2 = (ImageView) findViewById(R.id.imv2);

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

        imI.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imI);

                v.startDrag(dragData, myShadow, null, 0);
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

        imv2.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()) {
                    case DragEvent.ACTION_DROP:
                        Log.d(msg, "ACTION_DROP event " + event.getClipData().getItemAt(0).getText());
                        int itemId = Integer.parseInt((String) event.getClipData().getItemAt(0).getText());
                        if ((itemId == R.id.imE)) {
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv2.getX();
                            float gy = imv2.getY();
                            imE.setX(gx);
                            imE.setY(gy);
                            delay();
                        }
                        if (itemId == R.id.imA) {
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv2.getX();
                            float gy = imv2.getY();
                            imA.setX(gx);
                            imA.setY(gy);
                            delay();
                        }
                        if (itemId == R.id.imI) {
                            score++;
                            Toast.makeText(getApplicationContext(), "ถูกต้อง", Toast.LENGTH_LONG).show();
                            float gx = imv2.getX();
                            float gy = imv2.getY();
                            imI.setX(gx);
                            imI.setY(gy);
                            delay();
                        }
                        if ((itemId == R.id.imO)) {
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv2.getX();
                            float gy = imv2.getY();
                            imO.setX(gx);
                            imO.setY(gy);
                            delay();
                        }
                        break;
                    default:
                        break;
                }
                return true;
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
        imI.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("id", "" + imI.getId());
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(imI);

                    imI.startDrag(data, shadowBuilder, imI, 0);

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
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(imO);

                    imO.startDrag(data, shadowBuilder, imO, 0);

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
                Intent nextquest = new Intent(getApplicationContext(), PuzzleColor2.class);
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
