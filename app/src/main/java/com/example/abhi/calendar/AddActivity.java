package com.example.abhi.calendar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class AddActivity extends AppCompatActivity {

    private static String eventTitle;
    private static String eventDate;
    private static String eventTime;
    private static ArrayList<Event> eventList = new ArrayList<>();
    private EditText dateEditText;
    private EditText timeEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        createDatePicker();
        createTimePicker();
    }

    private void createDatePicker()
    {
        dateEditText = (EditText) findViewById(R.id.date);


        dateEditText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(AddActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    Calendar myCalendar = Calendar.getInstance();

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };


    private void updateLabel() {

        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        eventDate = sdf.format(myCalendar.getTime());
        dateEditText.setText(eventDate);
    }

    private void createTimePicker() {
        timeEditText = (EditText) findViewById(R.id.time);
        timeEditText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(AddActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        eventTime = selectedHour + ":" + selectedMinute;
                        timeEditText.setText(eventTime );
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });
    }
    public void onClickAddEvent (View view)
    {
        EditText title = (EditText) findViewById(R.id.title);
        eventTitle = title.getText().toString();

        Event newEvent = new Event(eventTitle, eventDate, eventTime);
        eventList.add(newEvent);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public static ArrayList<Event> getEventList()
    {
        return eventList;
    }



}
