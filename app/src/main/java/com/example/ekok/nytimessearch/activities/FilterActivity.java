package com.example.ekok.nytimessearch.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;

import com.example.ekok.nytimessearch.DatePickerFragment;

import java.util.Calendar;

/**
 * Created by ekok on 6/22/16.
 */
public class FilterActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    // attach to an onclick handler to show the date picker
    public void showDatePickerDialog(View v) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void onSubmit(View v) {
        Intent i = new Intent();
        setResult(RESULT_OK, i);
        finish();
    }

    // handle the date selected
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        // store the values selected into a Calendar instance
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, monthOfYear);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
    }
}
