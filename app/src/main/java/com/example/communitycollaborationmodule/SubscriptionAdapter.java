package com.example.communitycollaborationmodule;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SubscriptionAdapter extends RecyclerView.Adapter<SubscriptionAdapter.SubscriptionViewHolder> {
    private List<SubscriptionList> plans;

    public SubscriptionAdapter(List<SubscriptionList> plans) {
        this.plans = plans;
    }

    @NonNull
    @Override
    public SubscriptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subscription_card_layout, parent, false);
        return new SubscriptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubscriptionViewHolder holder, int position) {
        SubscriptionList plan = plans.get(position);
        holder.title.setText(plan.getTitle());
        holder.weeklyPrice.setText(plan.getWeeklyPrice());
        holder.monthlyPrice.setText(plan.getMonthlyPrice());
        holder.image.setImageResource(plan.getImageResId());

    }

    @Override
    public int getItemCount() {
        return plans.size();
    }

    public static class SubscriptionViewHolder extends RecyclerView.ViewHolder {
        TextView title, weeklyPrice, monthlyPrice;
        ImageView image;
        Button selectButton;

        public SubscriptionViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            weeklyPrice = itemView.findViewById(R.id.item_weekly_price);
            monthlyPrice = itemView.findViewById(R.id.item_monthly_price);
            image = itemView.findViewById(R.id.item_image);
            selectButton = itemView.findViewById(R.id.item_select_button);
        }
    }
}
