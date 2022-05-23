package com.example.codelab_2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnOpenMedia = null;
    EditText editWebUrl = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        editWebUrl = findViewById(R.id.editMedia);

        btnOpenMedia = findViewById(R.id.button);
        btnOpenMedia.setOnClickListener(v -> {
            String strUrl = editWebUrl.getText().toString();
            Uri webPageUri = Uri.parse(strUrl);

            Intent implicitIntent = new Intent(Intent.ACTION_VIEW, webPageUri);
            startActivity(implicitIntent);

            if (implicitIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(implicitIntent);
            } else {
                Log.d("abc", strUrl);
            }
        });
    }
}