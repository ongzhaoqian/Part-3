package com.example.communitycollaborationmodule;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class SubscriptionPlanAdapter extends RecyclerView.Adapter<SubscriptionAdapter.ViewHolder> {

    private final List<SubscriptionPlan> subscriptionPlans;
    private final boolean isActive;

    public SubscriptionPlanAdapter(List<SubscriptionPlan> subscriptionPlans, boolean isActive) {
        this.subscriptionPlans = subscriptionPlans;
        this.isActive = isActive;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout = isActive ? R.layout.active_subscription_card : R.layout.past_subscription_card;
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SubscriptionPlan plan = subscriptionPlans.get(position);

        // Bind data to views
        holder.productName.setText(plan.getProductName());
        holder.details.setText(isActive ? plan.getDeliverySchedule() : plan.getDeliverySchedule());

        // Set up actions
        if (isActive) {
            holder.editButton.setOnClickListener(v -> {
                // Handle Edit Plan action
            });

            holder.pauseButton.setOnClickListener(v -> {
                // Handle Pause Plan action
            });

            holder.cancelButton.setOnClickListener(v -> {
                // Handle Cancel Plan action
            });
        } else {
            holder.continueButton.setOnClickListener(v -> {
                // Handle Continue Subscription action
            });
        }
    }

    @Override
    public int getItemCount() {
        return subscriptionPlans.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView productName, details;
        Button editButton, pauseButton, cancelButton, continueButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            details = itemView.findViewById(R.id.details);

            // Buttons for Active Subscriptions
            editButton = itemView.findViewById(R.id.editButton);
            pauseButton = itemView.findViewById(R.id.pauseButton);
            cancelButton = itemView.findViewById(R.id.cancelButton);

            // Button for Past Subscriptions
            continueButton = itemView.findViewById(R.id.continueButton);
        }
    }
}