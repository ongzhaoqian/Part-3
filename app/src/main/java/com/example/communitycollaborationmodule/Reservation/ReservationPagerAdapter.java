package com.example.communitycollaborationmodule.Reservation;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.io.Serializable;

public class ReservationPagerAdapter extends FragmentStateAdapter {
    public boolean isDetailView = false;
    public ReservationList reservationList;
    private Reservation reservation;

    public ReservationPagerAdapter(@NonNull FragmentActivity fragmentActivity, Reservation reservation) {
        super(fragmentActivity);
        this.reservation = reservation;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                if (isDetailView) {
                    Log.d("ReservationPagerAdapter", "Creating ReservationDetail fragment");
                    Fragment fragment = new ReservationDetail();
                    Bundle bundle = new Bundle();
                    bundle.putInt("image", reservationList.imageResourceId);
                    bundle.putString("name", reservationList.getName());
                    bundle.putString("description", reservationList.getDescription());
                    bundle.putString("location", reservationList.getLocation());
                    bundle.putFloat("rating", reservationList.getRating());

                    fragment.setArguments(bundle);

                    isDetailView = false;
                    return fragment;
                } else {
                    Log.d("ReservationPagerAdapter", "Creating ReservationExperience fragment");
                    return new ReservationExperience(reservation);
                }
            case 1:
                return new ReservationMyBooking();
            default:
                return new ReservationExperience(reservation);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}