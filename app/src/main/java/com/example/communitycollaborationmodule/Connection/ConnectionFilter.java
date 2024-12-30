package com.example.communitycollaborationmodule.Connection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.communitycollaborationmodule.R;

public class ConnectionFilter extends DialogFragment {

    private String selectedProduct;
    private float selectedDistance;
    private float selectedRating;
    private String selectedPrice;
    final private float min = 0.0f;
    final private float max = 100.0f;
    private FilterListener filterListener;

    public void setFilterListener(FilterListener filterListener) {
        this.filterListener = filterListener;
    }

    public interface FilterListener {
        void onFilterApplied(String selectedProduct, Float selectedDistance, Float selectedRating, String selectedPrice);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_connection_filter, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Initialize and configure your UI elements here
        SeekBar distanceSeekBar = view.findViewById(R.id.distanceSeekBar);
        RatingBar ratingBar = view.findViewById(R.id.filterRatingBar);
        SeekBar priceSeekBar = view.findViewById(R.id.priceSeekBar);
        RadioButton fruitRadioButton = view.findViewById(R.id.fruitRadioButton2);
        RadioButton vegetablesRadioButton = view.findViewById(R.id.vegetablesRadioButton2);
        RadioButton meatRadioButton = view.findViewById(R.id.meatRadioButton2);
        RadioButton eggRadioButton = view.findViewById(R.id.eggRadioButton2);
        RadioButton dairyRadioButton = view.findViewById(R.id.dairyRadioButton2);
        RadioButton grainRadioButton = view.findViewById(R.id.grainRadioButton2);
        Button filterButton = view.findViewById(R.id.FilterButton2);
        TextView distance = view.findViewById(R.id.distanceFilter);
        TextView price = view.findViewById(R.id.priceShow);
        TextView ratingText = view.findViewById(R.id.ratingFilter);

        // Add all radio buttons to a list or array for easy handling
        RadioButton[] radioButtons = {fruitRadioButton, vegetablesRadioButton, meatRadioButton, eggRadioButton, dairyRadioButton, grainRadioButton};

        // Set OnClickListener for each RadioButton
        for (RadioButton radioButton : radioButtons) {
            radioButton.setOnClickListener(v -> {
                for (RadioButton rb : radioButtons) {
                    rb.setChecked(rb == v);
                }
                selectedProduct = ((RadioButton) v).getText().toString();
            });
        }

        distanceSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String distanceValue = progress + " km";
                distance.setText(distanceValue);
                selectedDistance = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        priceSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Map progress to a float value
                float floatValue = min + ((max - min) * progress / seekBar.getMax());
                String displayPrice = String.format("RM %.2f", floatValue);
                price.setText(displayPrice);

                selectedPrice = displayPrice;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String displayValue = String.format("%.2f stars", rating);
                ratingText.setText(displayValue);
                selectedRating = rating;
            }
        });

        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (filterListener != null) {
                    filterListener.onFilterApplied(selectedProduct,
                            selectedDistance,
                            selectedRating,
                            selectedPrice);
                }
                dismiss(); // Close the dialog
            }
        });
    }
}