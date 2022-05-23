package com.example.codelab_4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
}