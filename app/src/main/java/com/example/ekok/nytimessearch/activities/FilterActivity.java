package com.example.ekok.nytimessearch.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.ekok.nytimessearch.DatePickerFragment;
import com.example.ekok.nytimessearch.R;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
    }

    public void onSubmit(View v) {
        EditText etDate = (EditText) findViewById(R.id.etDate);
        Spinner spinnerSort = (Spinner) findViewById(R.id.spinnerSort);
        CheckBox cbArts = (CheckBox) findViewById(R.id.cbArts);
        CheckBox cbFashion = (CheckBox) findViewById(R.id.cbFashion);
        CheckBox cbSports = (CheckBox) findViewById(R.id.cbSports);

        Intent i = new Intent();

        i.putExtra("etDate", etDate.getText().toString());
        i.putExtra("spinnerSort", spinnerSort.toString());
        i.putExtra("cbArts", cbArts.getText().toString());
        i.putExtra("cbFashion", cbFashion.getText().toString());
        i.putExtra("cbSports", cbSports.getText().toString());

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
