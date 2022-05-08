package com.example.codelab02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView recvMsg;
    Button btnReply;
    EditText edtReply;
    public static final String REPLY_MESSAGE = "com.example.codelab02.SecondActiviy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recvMsg = findViewById(R.id.recvMsg);
        btnReply = findViewById(R.id.btnReply);
        edtReply = findViewById(R.id.replyText);

        Intent callerIntent = getIntent();
        String strMessage = callerIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        if (strMessage != null) {
            recvMsg.setText(strMessage);
        }

        btnReply.setOnClickListener(v -> {
            Intent replyIntent = new Intent(SecondActivity.this, MainActivity.class);
            replyIntent.putExtra(REPLY_MESSAGE, edtReply.getText().toString());
            setResult(RESULT_OK, replyIntent);
            finish();
        });
    }
}