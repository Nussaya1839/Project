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

public class PuzzleOrgans1 extends AppCompatActivity {
    ImageView imv1, imv2, imv3;
    ImageView imB, imS, imR, imN;
    private String msg = "debug";
    private int score = 0;
    private String strscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_organs1);
        final MediaPlayer correct = MediaPlayer.create(this, R.raw.correct);
        final MediaPlayer incorrect = MediaPlayer.create(this, R.raw.incorrect);

        imB= (ImageView) findViewById(R.id.imB);
        imS= (ImageView) findViewById(R.id.imS);
        imR= (ImageView) findViewById(R.id.imR);
        imN= (ImageView) findViewById(R.id.imN);
        imv1 = (ImageView) findViewById(R.id.imv1);

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

        imS.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imS);

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

        imN.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imN);

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
                        if ((itemId == R.id.imB)) {
                            incorrect.start();
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv1.getX();
                            float gy = imv1.getY();
                            imB.setX(gx);
                            imB.setY(gy);
                            enable( false );
                            delay();
                        }
                        if (itemId == R.id.imS) {
                            incorrect.start();
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv1.getX();
                            float gy = imv1.getY();
                            imS.setX(gx);
                            imS.setY(gy);
                            enable( false );
                            delay();
                        }
                        if (itemId == R.id.imR) {
                            correct.start();
                            score++;
                            Toast.makeText(getApplicationContext(), "ถูกต้อง", Toast.LENGTH_LONG).show();
                            float gx = imv1.getX();
                            float gy = imv1.getY();
                            imR.setX(gx);
                            imR.setY(gy);
                            enable( false );
                            delay();
                        }
                        if ((itemId == R.id.imN)) {
                            incorrect.start();
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv1.getX();
                            float gy = imv1.getY();
                            imN.setX(gx);
                            imN.setY(gy);
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
        imR.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("id", "" + imR.getId());
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(imR);

                    imR.startDrag(data, shadowBuilder, imR, 0);

                    return true;
                } else {
                    return false;
                }
            }
        });
        imN.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("id", "" + imN.getId());
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(imN);

                    imN.startDrag(data, shadowBuilder, imN, 0);

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
                Intent nextquest = new Intent(getApplicationContext(), PuzzleOrgans2.class);
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
