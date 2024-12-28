package com.example.communitycollaborationmodule;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Locale;


public class ReservationDetail extends Fragment {

    Button timeButton;
    int hour, minute;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reservation_detail, container, false);


    }

    @Override

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        timeButton =view.findViewById(R.id.timeButton);
    }

    public void popTimePicker(View view)
    {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute)
            {
                hour = selectedHour;
                minute = selectedMinute;
                // Format the time to 12-hour format with AM/PM
                String timeFormat = String.format(Locale.getDefault(), "%02d:%02d %s",
                        (hour % 12 == 0) ? 12 : hour % 12, // Convert 24-hour to 12-hour format
                        minute,
                        (hour < 12) ? "AM" : "PM" // AM or PM based on the hour
                );
                timeButton.setText(timeFormat);
            }
        };



        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), onTimeSetListener, hour, minute, true);

        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }
}