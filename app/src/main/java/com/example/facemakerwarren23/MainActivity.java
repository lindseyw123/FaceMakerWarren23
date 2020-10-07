package com.example.facemakerwarren23;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.RadioGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

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

        // reference to face (surface view) object
        Face face = findViewById(R.id.face);
        // make listener object
        Listener listener = new Listener(face);

        // set on item selected listener to spinner
        spinner.setOnItemSelectedListener(listener);

        // set on check changed listener to radio group
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(listener);

        // set on click listener to random face button
        Button randomFaceButton = findViewById(R.id.randomFaceButton);
        randomFaceButton.setOnClickListener(listener);

        // set on seek bar change listener to seek bars
        SeekBar redSeekBar = findViewById(R.id.redSeekBar);
        redSeekBar.setOnSeekBarChangeListener(listener);

        SeekBar greenSeekBar = findViewById(R.id.greenSeekBar);
        greenSeekBar.setOnSeekBarChangeListener(listener);

        SeekBar blueSeekBar = findViewById(R.id.blueSeekBar);
        blueSeekBar.setOnSeekBarChangeListener(listener);

        // set seek bars to correct progress
        redSeekBar.setProgress(listener.red);
        redSeekBar.refreshDrawableState();

        greenSeekBar.setProgress(listener.green);
        greenSeekBar.refreshDrawableState();

        blueSeekBar.setProgress(listener.blue);
        blueSeekBar.refreshDrawableState();

        // set text views to reflect progress
        TextView redNum = findViewById(R.id.redNum);
        redNum.setText("" + redSeekBar.getProgress());

        TextView greenNum = findViewById(R.id.greenNum);
        greenNum.setText("" + greenSeekBar.getProgress());

        TextView blueNum = findViewById(R.id.blueNum);
        blueNum.setText("" + blueSeekBar.getProgress());
    }
    /**
     * External Citation
     *   Date: 10 September 2020
     *   Problem: Wanted to put values in spinner
     *   Resource: Example code from class on Moodle
     *   Solution: Used example
     */
}