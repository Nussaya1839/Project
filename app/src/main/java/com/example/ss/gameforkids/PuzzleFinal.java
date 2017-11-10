package com.example.ss.gameforkids;

import android.content.Intent;;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PuzzleFinal extends AppCompatActivity {
    private int score = 0;
    private String strscore, strReceiveScore;
    private TextView tvScore;
    private Button btn1, btn2;
    private ImageView pika;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_final);

        strReceiveScore = getIntent().getStringExtra("score");
        score = Integer.parseInt(strReceiveScore);
        strscore = Integer.toString(score);

        tvScore = (TextView) findViewById(R.id.tvScore);
        tvScore.setText(Integer.toString(score) + "   คะแนน");

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PuzzleFinal.this, ListPuzzle.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intents = new Intent(PuzzleFinal.this, MenuGame.class);
                startActivity(intents);
            }
        });

        pika = (ImageView) findViewById(R.id.pika);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);
        pika.startAnimation(animation);
    }
}
