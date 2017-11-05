package com.example.ss.gameforkids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuGame extends AppCompatActivity {
    ImageView imvPuzzle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_game);

        imvPuzzle=(ImageView)findViewById(R.id.imvPuzzle);
        imvPuzzle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imvPuzzle=new Intent(MenuGame.this,PuzzleGame.class);
                startActivity(imvPuzzle);
            }
        });
    }
}
