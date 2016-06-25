package com.example.ekok.nytimessearch.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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

    // Fires every time a checkbox is checked or unchecked
    CompoundButton.OnCheckedChangeListener checkListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton view, boolean checked) {
            // compoundButton is the checkbox
            // boolean is whether or not checkbox is checked
            // Check which checkbox was clicked
            switch(view.getId()) {
                case R.id.cbArts:
                    if (checked) {

                    } else {
                        // Remove the meat
                    }
                    break;
                case R.id.cbFashion:
                    if (checked) {
                        // Cheese me
                    } else {
                        // I'm lactose intolerant
                    }
                    break;
                case R.id.cbSports:
                    if (checked) {
                        // Cheese me
                    } else {
                        // I'm lactose intolerant
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
    }

    public void setupCheckboxes() {
        CheckBox checkArts = (CheckBox) findViewById(R.id.cbArts);
        CheckBox checkFashion = (CheckBox) findViewById(R.id.cbFashion);
        CheckBox checkSports = (CheckBox) findViewById(R.id.cbSports);

        checkArts.setOnCheckedChangeListener(checkListener);
        checkFashion.setOnCheckedChangeListener(checkListener);
        checkSports.setOnCheckedChangeListener(checkListener);
    }

    public void onSubmit(View v) {
        EditText etDate = (EditText) findViewById(R.id.etDate);
        Spinner spinnerSort = (Spinner) findViewById(R.id.spinnerSort);

        CheckBox cbArts = (CheckBox) findViewById(R.id.cbArts);
        CheckBox cbFashion = (CheckBox) findViewById(R.id.cbFashion);
        CheckBox cbSports = (CheckBox) findViewById(R.id.cbSports);

        setupCheckboxes();

        boolean isArtsChecked = cbArts.isChecked();
        boolean isFashionChecked = cbFashion.isChecked();
        boolean isSportsChecked = cbSports.isChecked();

        cbArts.setChecked(true);
        cbFashion.setChecked(true);
        cbSports.setChecked(true);

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
