package com.example.communitycollaborationmodule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

    public class ReservationMyBooking extends Fragment {

        private RecyclerView upcomingRecyclerView;
        private RecyclerView pastRecyclerView;
        private MyBookingAdapter upcomingAdapter;
        private MyBookingAdapter pastAdapter;
        private List<Booking> upcomingBookings;
        private List<Booking> pastBookings;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_reservation_my_booking, container, false);

            upcomingRecyclerView = view.findViewById(R.id.upcomingRecyclerView);
            pastRecyclerView = view.findViewById(R.id.pastRecyclerView);

            upcomingBookings = new ArrayList<>();
            pastBookings = new ArrayList<>();

            loadBookings();

            upcomingAdapter = new MyBookingAdapter(upcomingBookings, true);
            pastAdapter = new MyBookingAdapter(pastBookings, false);

            upcomingRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            pastRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            upcomingRecyclerView.setAdapter(upcomingAdapter);
            pastRecyclerView.setAdapter(pastAdapter);

            return view;
        }

        private void loadBookings() {
            // Load your bookings here (e.g., from a database or API)
            // Separate them into upcoming and past bookings based on the current date

            // Example data:
            upcomingBookings.add(new Booking("Strawberry Picking", "11/11/2024", "09:00am - 12:00pm", 2));
            pastBookings.add(new Booking("Farm Volunteer", "10/10/2024", "09:00am - 12:00pm", 2));
        }
    }
