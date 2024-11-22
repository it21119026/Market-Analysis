package com.example.gh_app;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class Market extends AppCompatActivity {

    private EditText dateEdt;
    private Spinner countySpinner; // Change to Spinner for country selection
    private TextView marketResult; // TextView to display server response

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        dateEdt = findViewById(R.id.idEdtDate);
        countySpinner = findViewById(R.id.idCountySpinner); // Initialize county Spinner
        marketResult = findViewById(R.id.marketresult); // Initialize marketResult TextView

        // Populate the Spinner with country options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.country_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countySpinner.setAdapter(adapter);

        dateEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
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
                Market.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        dateEdt.setText("" + year);
                    }
                },
                year, month, day);
        datePickerDialog.show();
    }
}