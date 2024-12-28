package com.example.communitycollaborationmodule;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class BookingConfirmationDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_booking_confirmation, null);

        // Set data dynamically (this can be passed from the activity/fragment)
        TextView experienceName = view.findViewById(R.id.experience_name);
        TextView date = view.findViewById(R.id.date);
        TextView time = view.findViewById(R.id.time);
        TextView participants = view.findViewById(R.id.participants);
        TextView price = view.findViewById(R.id.price);
        Spinner paymentMethod = view.findViewById(R.id.payment_method);

        Button confirmButton = view.findViewById(R.id.confirm_booking_button);

        // Example of setting data
        experienceName.setText("Strawberry Picking");
        date.setText("11/11/2024");
        time.setText("09:00am - 12:00pm");
        participants.setText("2");
        price.setText("RM40.00");

        confirmButton.setOnClickListener(v -> {
            // Add confirm action logic here
            dismiss();
        });

        builder.setView(view);
        return builder.create();
    }
}
