package com.example.communitycollaborationmodule;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.Arrays;
import java.util.List;


public class SubscriptionPlan extends Fragment {
    private RecyclerView recyclerView;
    private SubsriptionAdapter adapter;
    private List<SubscriptionList> plans;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subscription, container, false);
    }

        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            recyclerView = view.findViewById(R.id.recyclerView);
             recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Sample Data for Subscription Plans
        plans = Arrays.asList(
                new SubscriptionPlan("Cabbage", "Weekly --- RM6.00", "Monthly --- RM22.00", R.drawable.cabbage),
                new SubscriptionPlan("Carrot", "Weekly --- RM6.00", "Monthly --- RM22.00", R.drawable.carrot),
                new SubscriptionPlan("Banana", "Weekly --- RM7.50", "Monthly --- RM30.00", R.drawable.sellbanana),
                new SubscriptionPlan("Fresh Milk (1L)", "Weekly --- RM20.00", "Monthly --- RM80.00", R.drawable.milk)
        );

        adapter = new SubscriptionAdapter(plans);
        recyclerView.setAdapter(adapter);

        // Filter Button
        ImageButton filterButton = view.findViewById(R.id.filter_button_subscription);
        filterButton.setOnClickListener(v -> showFilterDialog());

        return view;
    }
}