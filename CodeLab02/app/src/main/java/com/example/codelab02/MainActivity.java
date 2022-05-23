package com.example.codelab02;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnSend;
    EditText edtMsg;
    TextView tvRep;

    // Đặt là static để bên SecondActivity gọi đc MainActivity.EXTRA_MESSAGE
    public static final String EXTRA_MESSAGE = "com.example.codelab02.MainActivity";
    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST && resultCode == RESULT_OK) {
            if (data != null) {
                String strReplyMsg = data.getStringExtra(SecondActivity.REPLY_MESSAGE);
                tvRep.setText(strReplyMsg);
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = findViewById(R.id.btnSend);
        edtMsg = findViewById(R.id.msgText);
        tvRep = findViewById(R.id.textView);

        if (savedInstanceState != null) {
            tvRep.setText(savedInstanceState.getString("reply_content"));
        }

        btnSend.setOnClickListener(v -> {
            Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
            myIntent.putExtra(EXTRA_MESSAGE, edtMsg.getText().toString());

            startActivityForResult(myIntent, TEXT_REQUEST);
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        String strContent = tvRep.getText().toString();

        outState.putString("reply_content", strContent);
    }
}