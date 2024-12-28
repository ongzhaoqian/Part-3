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

public class SubscriptionMySubscription extends Fragment {

    private RecyclerView activeRecyclerView, pastRecyclerView;

    public SubscriptionMySubscription() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_subscription_my_subscription, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize RecyclerViews
        activeRecyclerView = view.findViewById(R.id.activeRecyclerView);
        pastRecyclerView = view.findViewById(R.id.pastRecyclerView);

        // Setup RecyclerViews
        setupRecyclerViews();
    }

    private void setupRecyclerViews() {
        // Sample data for Active Subscriptions
        List<SubscriptionPlan> activeSubscriptions = new ArrayList<>();
        activeSubscriptions.add(new SubscriptionPlan("Cabbage (1kg)", "Happy Farm", 12.00, 2, "Next delivery: 14/11/2024", "Weekly"));

        // Sample data for Past Subscriptions
        List<SubscriptionProcessList> pastSubscriptions = new ArrayList<>();
        pastSubscriptions.add(new SubscriptionProcess("Milk (1L)", "Dairy Farm", 10.00, 1, "Last delivered: 7/11/2024", "Weekly"));

        // Set up adapters for Active and Past Subscriptions
        SubscriptionAdapter activeAdapter = new SubscriptionAdapter(activeSubscriptions, true);
        SubscriptionAdapter pastAdapter = new SubscriptionAdapter(pastSubscriptions, false);

        activeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        activeRecyclerView.setAdapter(activeAdapter);

        pastRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        pastRecyclerView.setAdapter(pastAdapter);
    }
}