package com.example.communitycollaborationmodule;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.communitycollaborationmodule.Connection.Connection;
import com.example.communitycollaborationmodule.Reservation.Reservation;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity){
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position){
        Log.d("position",Integer.toString(position));
        switch (position){
            case 0:
                return new Connection();
            case 1:
                return new Reservation();
            default:
                return new Connection();
        }
    }

    @Override
    public int getItemCount(){
        return 2;
    }
}
