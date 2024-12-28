package com.example.communitycollaborationmodule;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.communitycollaborationmodule.Connection;
import com.example.communitycollaborationmodule.Reservation;
import com.example.communitycollaborationmodule.Subscription;

public class SubscriptionPagerAdapter extends FragmentStateAdapter {
    public SubscriptionPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new SubscriptionPlan();
            case 1:
                return new SubscriptionMySubscription();
            default:
                return new SubscriptionPlan();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}