package com.example.asynctaskloader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnSearch = null;
    EditText editText = null;
    TextView textTitle = null;
    TextView textAuthor = null;
    Loader loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSearch = findViewById(R.id.btn_search);
        editText = findViewById(R.id.editText);
        textTitle = findViewById(R.id.textTitle);
        textAuthor = findViewById(R.id.author);
        loader = new Loader(this, textTitle, textAuthor);

        if (getSupportLoaderManager().getLoader(0) != null) {
            getSupportLoaderManager().initLoader(0, null, loader);
        }

        if (btnSearch != null) {
            btnSearch.setOnClickListener(this::searchBooks);
        }
    }

    public void searchBooks(View view) {
        String queryString = editText.getText().toString();

        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected()
                && queryString.length() != 0) {

            Bundle queryBundle = new Bundle();
            queryBundle.putString("queryString", queryString);
            getSupportLoaderManager().restartLoader(0, queryBundle, loader);

            textAuthor.setText("");
            textTitle.setText(R.string.loading);
        }

        else {
            if (queryString.length() == 0) {
                textAuthor.setText("");
                textTitle.setText(R.string.no_search_term);
            } else {
                textAuthor.setText("");
                textTitle.setText(R.string.no_network);
            }
        }
    }
}