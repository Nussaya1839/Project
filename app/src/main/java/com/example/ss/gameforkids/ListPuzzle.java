package com.example.ss.gameforkids;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListPuzzle extends AppCompatActivity {

    ListView list_puzzle;
    String[] st_category ={"Colors (สีต่าง ๆ)", "Animals (สัตว์)", "My Body (ร่างกาย)", "Food (อาหาร)",
            "Internal Organs (อวัยวะภายใน)", "Kitchen (ห้องครัว)", "Natural (ธรรมชาติ)", "Tool Supplies (เครื่องมือช่าง)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_puzzle);
        list_puzzle = (ListView)findViewById(R.id.list_puzzle);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListPuzzle.this,
                android.R.layout.simple_expandable_list_item_1, st_category);
        list_puzzle.setAdapter(adapter);

        list_puzzle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position){
                    case 0 :
                        intent = new Intent(getApplicationContext(),PuzzleColor1.class);
                        startActivity(intent);
                        break;

                    case 1 :
                        intent = new Intent(getApplicationContext(),PuzzleAnimal1.class);
                        startActivity(intent);
                        break;

                    case 2 :
                        intent = new Intent(getApplicationContext(),PuzzleBody1.class);
                        startActivity(intent);
                        break;

                    case 3 :
                        intent = new Intent(getApplicationContext(),PuzzleFood1.class);
                        startActivity(intent);
                        break;

                    case 4 :
                        intent = new Intent(getApplicationContext(),PuzzleOrgans1.class);
                        startActivity(intent);
                        break;

                    case 5 :
                        intent = new Intent(getApplicationContext(),PuzzleKitchen1.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list_puzzle, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.homes) {
            startActivity(new Intent(this, MenuGame.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
