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

public class PuzzleFood4 extends AppCompatActivity {
    ImageView imv1, imv2, imv3, imv4;
    ImageView imS, imB, imK, imC;
    private String msg = "debug";
    private int score = 0;
    private String strscore, strReceiveScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_food4);
        final MediaPlayer correct = MediaPlayer.create(this, R.raw.correct);
        final MediaPlayer incorrect = MediaPlayer.create(this, R.raw.incorrect);

        strReceiveScore = getIntent().getStringExtra("score");
        score = Integer.parseInt(strReceiveScore);
        imS= (ImageView) findViewById(R.id.imS);
        imB= (ImageView) findViewById(R.id.imB);
        imK= (ImageView) findViewById(R.id.imK);
        imC= (ImageView) findViewById(R.id.imC);
        imv3 = (ImageView) findViewById(R.id.imv3);

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

        imB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imB);

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

        imC.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imC);

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
                        if ((itemId == R.id.imS)) {
                            incorrect.start();
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv3.getX();
                            float gy = imv3.getY();
                            imS.setX(gx);
                            imS.setY(gy);
                            enable( false );
                            delay();
                        }
                        if (itemId == R.id.imB) {
                            incorrect.start();
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv3.getX();
                            float gy = imv3.getY();
                            imB.setX(gx);
                            imB.setY(gy);
                            enable( false );
                            delay();
                        }
                        if (itemId == R.id.imK) {
                            incorrect.start();
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv3.getX();
                            float gy = imv3.getY();
                            imK.setX(gx);
                            imK.setY(gy);
                            enable( false );
                            delay();
                        }
                        if ((itemId == R.id.imC)) {
                            correct.start();
                            score++;
                            Toast.makeText(getApplicationContext(), "ถูกต้อง", Toast.LENGTH_LONG).show();
                            float gx = imv3.getX();
                            float gy = imv3.getY();
                            imC.setX(gx);
                            imC.setY(gy);
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
                Intent nextquest = new Intent(getApplicationContext(), PuzzleFood5.class);
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
