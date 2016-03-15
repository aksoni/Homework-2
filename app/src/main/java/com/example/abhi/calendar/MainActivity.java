package com.example.abhi.calendar;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


   /* protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }*/

    private static String currentDate;
    private static String selectedDateString;
    CalendarView calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //sets the main layout of the activity
        setContentView(R.layout.activity_main);

        //initializes the calendarview
        initializeCalendar();
    }

    public void initializeCalendar() {
        calendar = (CalendarView) findViewById(R.id.calendar);
        //sets the listener to be notified upon selected date change.
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                String myFormat = "MM/dd/yy";
                Calendar myCalendar = Calendar.getInstance();
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, day);
                SimpleDateFormat selectedDate = new SimpleDateFormat(myFormat, Locale.US);
                selectedDateString = selectedDate.format(myCalendar.getTime());
            }
        });
    }


    public static String getCurrentDate()
    {
        return currentDate;
    }
    public void onClickAdd (View view)
    {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    public void onClickView (View view)
    {
        Intent intent = new Intent(this, ViewActivity.class);
        startActivity(intent);
    }

    public static String getSelectedDate()
    {
        return selectedDateString;
    }


}
