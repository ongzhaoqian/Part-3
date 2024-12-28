package com.example.communitycollaborationmodule;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class SubscriptionProcess extends Fragment {


        private SubscriptionProcess currentProcess;
        private int quantity;

        public SubscriptionProcess() {
            // Required empty public constructor
        }

        /**
         * Create a new instance of SubscriptionPlanFragment with dynamic data
         */
        public SubscriptionProcess newInstance(SubscriptionProcessList plan) {
            SubscriptionProcess fragment = new SubscriptionProcess();
            Bundle args = new Bundle();
            args.putString("productName", plan.getProductName());
            args.putString("source", plan.getSource());
            args.putDouble("price", plan.getPricePerUnit();
            args.putString("deliverySchedule", plan.getDeliverySchedule());
            args.putString("planType", plan.getPlanType());
            args.putInt("quantity", plan.getQuantity());
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_subscription_process, container, false);
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            // Initialize UI elements
            TextView productName = view.findViewById(R.id.productName);
            TextView productSource = view.findViewById(R.id.productSource);
            TextView deliveryDetails = view.findViewById(R.id.deliveryDetailsTitle);
            TextView totalPrice = view.findViewById(R.id.totalPrice);
            TextView quantityText = view.findViewById(R.id.quantity);
            Button increaseQuantity = view.findViewById(R.id.increaseQuantity);
            Button decreaseQuantity = view.findViewById(R.id.decreaseQuantity);
            Button nextStep = view.findViewById(R.id.nextStepBtn);

            // Retrieve data from arguments
            if (getArguments() != null) {
                String name = getArguments().getString("productName");
                String source = getArguments().getString("source");
                double price = getArguments().getDouble("price");
                String deliverySchedule = getArguments().getString("deliverySchedule");
                String planType = getArguments().getString("planType");
                quantity = getArguments().getInt("quantity");

                // Create the SubscriptionPlan object
                currentProcess = new SubscriptionProcess(name, source, price, quantity, deliverySchedule, planType);

                // Set UI values
                productName.setText(currentProcess.getProductName());
                productSource.setText("Source: " + currentProcess.getSource());
                deliveryDetails.setText(currentProcess.getDeliverySchedule());
                updateTotalPrice(totalPrice);

                quantityText.setText(String.valueOf(quantity));
            }

            // Handle quantity changes
            increaseQuantity.setOnClickListener(v -> {
                quantity++;
                currentPlan.setQuantity(quantity);
                quantityText.setText(String.valueOf(quantity));
                updateTotalPrice(totalPrice);
            });

            decreaseQuantity.setOnClickListener(v -> {
                if (quantity > 1) {
                    quantity--;
                    currentPlan.setQuantity(quantity);
                    quantityText.setText(String.valueOf(quantity));
                    updateTotalPrice(totalPrice);
                } else {
                    Toast.makeText(getContext(), "Quantity cannot be less than 1", Toast.LENGTH_SHORT).show();
                }
            });

            // Handle Next Step button
            nextStep.setOnClickListener(v -> {
                // Pass data to Check Out dialog
                showCheckoutDialog();
            });
        }

        private void updateTotalPrice(TextView totalPrice) {
            double total = currentPlan.calculateTotalPrice();
            totalPrice.setText("Total Price: RM " + String.format("%.2f", total));
        }

        private void showCheckoutDialog() {
            // Create a dialog using the Check Out fragment
            CheckOutFragment checkOutFragment = CheckOutFragment.newInstance(currentPlan);
            checkOutFragment.show(getParentFragmentManager(), "CheckOutDialog");
        }
    }