package com.example.codelab_4_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ImageView donutImgView = null;
    ImageView iceImgView = null;
    ImageView froyoImgView = null;

    FloatingActionButton fab = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        donutImgView = findViewById(R.id.imageDonut);
        donutImgView.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "You order a Donut", Toast.LENGTH_LONG).show();
        });

        iceImgView = findViewById(R.id.imageIceCream);
        iceImgView.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "You order a Ice Cream", Toast.LENGTH_LONG).show();
        });

        froyoImgView = findViewById(R.id.imageFroyo);
        donutImgView.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "You order a Donut", Toast.LENGTH_LONG).show();
        });

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "You add to cart", Toast.LENGTH_LONG).show();
            Intent orderIntent = new Intent(MainActivity.this, OrderActivity.class);
            startActivity(orderIntent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
//            case R.id.action_settings:
//                Intent intent = new Intent(MainActivity.this,
//                        OrderActivity.class);
//                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
//                startActivity(intent);
//                return true;
            case R.id.action_logout:
                Toast.makeText(this, getString(R.string.action_logout), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings:
                Toast.makeText(this, getString(R.string.action_settings), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_contact:
                Toast.makeText(this, getString(R.string.action_contact), Toast.LENGTH_SHORT).show();
                return true;
            default:
                // Do nothing
        }

        return super.onOptionsItemSelected(item);
    }
}

