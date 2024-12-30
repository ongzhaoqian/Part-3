package com.example.communitycollaborationmodule.Reservation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitycollaborationmodule.R;

import java.util.List;

public class MyBookingAdapter extends RecyclerView.Adapter<MyBookingAdapter.BookingViewHolder> {

    private List<Booking> bookingList;
    private boolean isUpcoming;

    public MyBookingAdapter(List<Booking> bookingList, boolean isUpcoming) {
        this.bookingList = bookingList;
        this.isUpcoming = isUpcoming;
    }

    @NonNull
    @Override
    public BookingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_booking_card_layout, parent, false);
        return new BookingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingViewHolder holder, int position) {
        Booking booking = bookingList.get(position);
        holder.experienceTitleTextView.setText(booking.getTitle());
        holder.experienceDateTextView.setText("Date: " + booking.getDate());
        holder.experienceTimeTextView.setText("Time: " + booking.getTime());
        holder.experienceParticipantsTextView.setText("Number of Participants: " + booking.getParticipants());

        if (isUpcoming) {
            holder.upcomingActionsLayout.setVisibility(View.VISIBLE);
            holder.pastViewDetailsButton.setVisibility(View.GONE);
            // Set button click listeners if needed
            holder.viewDetailsButton.setOnClickListener(v -> {
                // Handle view details action
            });

            holder.rescheduleButton.setOnClickListener(v -> {
                // Handle reschedule action
            });

            holder.cancelButton.setOnClickListener(v -> {
                // Handle cancel action
            });
        } else {
            holder.upcomingActionsLayout.setVisibility(View.GONE);
            holder.pastViewDetailsButton.setVisibility(View.VISIBLE);
            holder.pastViewDetailsButton.setOnClickListener(v -> {
                // Handle view details action
            });
        }
    }

    @Override
    public int getItemCount() {
        return bookingList.size();
    }

    public static class BookingViewHolder extends RecyclerView.ViewHolder {

        TextView experienceTitleTextView;
        TextView experienceDateTextView;
        TextView experienceTimeTextView;
        TextView experienceParticipantsTextView;
        LinearLayout upcomingActionsLayout;
        Button viewDetailsButton;
        Button rescheduleButton;
        Button cancelButton;
        Button pastViewDetailsButton;

        public BookingViewHolder(@NonNull View itemView) {
            super(itemView);
            experienceTitleTextView = itemView.findViewById(R.id.experienceTitleTextView);
            experienceDateTextView = itemView.findViewById(R.id.experienceDateTextView);
            experienceTimeTextView = itemView.findViewById(R.id.experienceTimeTextView);
            experienceParticipantsTextView = itemView.findViewById(R.id.experienceParticipantsTextView);
            upcomingActionsLayout = itemView.findViewById(R.id.upcomingActionsLayout);
            viewDetailsButton = itemView.findViewById(R.id.editPlanButton);
            rescheduleButton = itemView.findViewById(R.id.pausePlanButton);
            cancelButton = itemView.findViewById(R.id.cancelPlanButton);
            pastViewDetailsButton = itemView.findViewById(R.id.pastViewDetailsButton);
        }
    }

    public void updateList(List<Booking> newList) {
        bookingList = newList;
        notifyDataSetChanged();
    }
}

