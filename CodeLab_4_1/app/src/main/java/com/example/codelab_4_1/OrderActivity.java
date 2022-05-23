package com.example.codelab_4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

        spinner.setOnItemSelectedListener(this);
    }

    public void onRadioButtonClicked(View view) {
        int clickedViewId = view.getId();
        if (clickedViewId == R.id.sameday) {
            Toast.makeText(this, "Same day", Toast.LENGTH_SHORT).show();
        } else if (clickedViewId == R.id.nextday) {
            Toast.makeText(this, "Next day", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Pick up", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this, spinnerLabel, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Do nothing.
    }
}