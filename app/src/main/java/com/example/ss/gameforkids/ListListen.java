package com.example.ss.gameforkids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListListen extends AppCompatActivity {
    ListView list_listen;
    String[] st_category ={"Family (ครอบครัว)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_list_listen );

        list_listen = (ListView)findViewById(R.id.list_listen);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListListen.this,
                android.R.layout.simple_expandable_list_item_1, st_category);
        list_listen.setAdapter(adapter);

        list_listen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position){
                    case 0 :
                        intent = new Intent(getApplicationContext(),ListenFamily1.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list_listen, menu);
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
