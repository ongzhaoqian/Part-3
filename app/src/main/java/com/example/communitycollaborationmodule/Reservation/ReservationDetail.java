package com.example.communitycollaborationmodule.Reservation;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.fragment.app.Fragment;

import com.example.communitycollaborationmodule.R;

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

        timeButton = view.findViewById(R.id.timeButton);

        Log.d("ReservationDetail", "Received data: " + getArguments().getString("name"));

        int imageResId = getArguments().getInt("image");
        String name = getArguments().getString("name");
        String description = getArguments().getString("description");
        String location = getArguments().getString("location");
        float rating = getArguments().getFloat("rating");

        ImageView reservationImage = view.findViewById(R.id.reservation_image);
        TextView reservationTitle = view.findViewById(R.id.reservation_title);
        TextView reservationDescription = view.findViewById(R.id.reservation_description);
        RatingBar reservationRatingBar = view.findViewById(R.id.reservation_ratingBar);
        TextView reservationLocation = view.findViewById(R.id.location);

        reservationImage.setImageResource(imageResId);
        reservationTitle.setText(name);
        reservationDescription.setText(description);
        reservationRatingBar.setRating(rating);
        reservationLocation.setText(location);
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