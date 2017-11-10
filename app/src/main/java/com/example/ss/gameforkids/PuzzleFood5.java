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

public class PuzzleFood5 extends AppCompatActivity {
    ImageView imv1, imv2, imv3, imv4;
    ImageView imG, imT, imK, imC;
    private String msg = "debug";
    private int score = 0;
    private String strscore, strReceiveScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_food5);

        strReceiveScore = getIntent().getStringExtra("score");
        score = Integer.parseInt(strReceiveScore);
        imG= (ImageView) findViewById(R.id.imG);
        imT= (ImageView) findViewById(R.id.imT);
        imK= (ImageView) findViewById(R.id.imK);
        imC= (ImageView) findViewById(R.id.imC);
        imv3 = (ImageView) findViewById(R.id.imv3);

        imG.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imG);

                v.startDrag(dragData, myShadow, null, 0);
                return true;
            }
        });

        imT.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imT);

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
                        if ((itemId == R.id.imG)) {
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv3.getX();
                            float gy = imv3.getY();
                            imG.setX(gx);
                            imG.setY(gy);
                            delay();
                        }
                        if (itemId == R.id.imT) {
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv3.getX();
                            float gy = imv3.getY();
                            imT.setX(gx);
                            imT.setY(gy);
                            delay();
                        }
                        if (itemId == R.id.imK) {
                            Toast.makeText(getApplicationContext(), "ผิด", Toast.LENGTH_LONG).show();
                            float gx = imv3.getX();
                            float gy = imv3.getY();
                            imK.setX(gx);
                            imK.setY(gy);
                            delay();
                        }
                        if ((itemId == R.id.imC)) {
                            score++;
                            Toast.makeText(getApplicationContext(), "ถูกต้อง", Toast.LENGTH_LONG).show();
                            float gx = imv3.getX();
                            float gy = imv3.getY();
                            imC.setX(gx);
                            imC.setY(gy);
                            delay();
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        imG.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("id", "" + imG.getId());
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(imG);

                    imG.startDrag(data, shadowBuilder, imG, 0);

                    return true;
                } else {
                    return false;
                }
            }
        });
        imT.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("id", "" + imT.getId());
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(imT);

                    imT.startDrag(data, shadowBuilder, imT, 0);

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

    private void delay() {
        android.os.Handler myhandler = new android.os.Handler();
        myhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent nextquest = new Intent(getApplicationContext(), PuzzleFood6.class);
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
