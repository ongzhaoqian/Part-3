package com.example.communitycollaborationmodule.Reservation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.communitycollaborationmodule.R;
import com.google.android.material.tabs.TabLayout;

public class Reservation extends Fragment {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ReservationPagerAdapter viewPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reservation_main, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager2 = view.findViewById(R.id.view_pager);
        viewPagerAdapter = new ReservationPagerAdapter(requireActivity(), this);
        viewPager2.setAdapter(viewPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });
    }

    public void onItemClicked(ReservationList reservationList){
        Log.d("Reservation", "Item clicked: " + reservationList.getName());
        Log.d("Reservation", "Item clicked: " + reservationList.getRating());
        viewPagerAdapter.isDetailView = true;
        viewPagerAdapter.reservationList = reservationList;
        viewPager2.setAdapter(viewPagerAdapter);
        viewPager2.setCurrentItem(0);
        Log.d("Reservation","Hello");
    }
}