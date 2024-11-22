package com.example.gh_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class Soil extends AppCompatActivity {

    private Button soilButton;

    private TextView yearSpinner;
    private Spinner provinceSpinner;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soil); // Set the layout for this activity

        // Initialize views
        soilButton = findViewById(R.id.submitButton);
        yearSpinner = findViewById(R.id.yearSpinner);
        provinceSpinner = findViewById(R.id.provinceSpinner);

        // Show date picker when yearSpinner (TextView) is clicked
        yearSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        // Set up the provinceSpinner (Spinner) with data from resources
        ArrayAdapter<CharSequence> provinceAdapter = ArrayAdapter.createFromResource(this,
                R.array.provinces_array, android.R.layout.simple_spinner_item);
        provinceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        provinceSpinner.setAdapter(provinceAdapter);

        // Set listener for provinceSpinner selection changes
        provinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Handle when a province is selected
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle when no province is selected
            }
        });
    }

    // Method to show date picker dialog
    private void showDatePicker() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                Soil.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // Update yearSpinner (TextView) with selected year
                        yearSpinner.setText("" + year);
                    }
                },
                year, month, day);
        datePickerDialog.show(); // Show the date picker dialog
    }
}
