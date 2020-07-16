package com.example.android.droidcafe;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;

import java.lang.reflect.Array;
import java.util.Calendar;

/**
 * This activity shows the order chosen.  The order is sent as data
 * with the intent to launch this activity.
 */
public class OrderActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        Spinner spinner = findViewById(R.id.label_spinner);
        if(spinner != null)
            spinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.labels_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if(spinner != null)
            spinner.setAdapter(adapter);

        // Get the intent and its data.
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.order_textview);
        textView.setText(message);
    }
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();




    }




    public void onRadioButtonClicked(View view) {
        Boolean checked = ((RadioButton)view).isChecked();

        switch (view.getId())
        {
            case R.id.sameday:
                if(checked)
                    displayToast(getString(R.string.same_day_messenger_service));
                break;
            case R.id.nextday:
                if(checked)
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;

            case R.id.pickup:
                if(checked)
                    displayToast(getString(R.string.pick_up));
                break;
            default:
                break;
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }





    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }


    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string +
                "/" + day_string + "/" + year_string);
        Toast.makeText(this, "Date: " + dateMessage,
                Toast.LENGTH_SHORT).show();
    }


}