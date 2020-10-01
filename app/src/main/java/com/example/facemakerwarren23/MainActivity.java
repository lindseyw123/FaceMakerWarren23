package com.example.facemakerwarren23;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Main activity class
 * @author Lindsey Warren
 */
public class MainActivity extends AppCompatActivity {
    // array of three possible hairstyles for user to choose
    private String[] hairstyles = {"Short", "Medium", "Long"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // adding hairstyles to spinner
        ArrayAdapter<String> hairstyleAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, hairstyles);
        Spinner spinner = findViewById(R.id.hairstyleSpinner);
        spinner.setAdapter(hairstyleAdapter);
    }
    /**
     * External Citation
     *   Date: 10 September 2020
     *   Problem: Wanted to put values in spinner
     *   Resource: Example code from class on Moodle
     *   Solution: Used example
     */
}