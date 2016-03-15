package com.example.abhi.calendar;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {
ArrayList<String> eventInfoList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        LinearLayout layout=(LinearLayout)findViewById(R.id.eventInfo);
        for(int i = 0; i < AddActivity.getEventList().size(); i++) {
            Event a = AddActivity.getEventList().get(i);
            if(a.getDate().equals(MainActivity.getSelectedDate())) {
                TextView title = new TextView(this);
                //eventInfoList.add(a.getEventInfo());
                title.setText(a.getEventInfo());
                layout.addView(title);
            }
            else {
                Log.d("Event date", a.getDate());
                Log.d("Selected day", MainActivity.getSelectedDate());
            }
        }

     /*  TextView date = new TextView(this);
        title.setText("date");
        layout.addView(date);

        TextView time = new TextView(this);
        title.setText("time");
        layout.addView(time);*/

    }
}
