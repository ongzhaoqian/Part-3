package com.example.communitycollaborationmodule.Connection;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitycollaborationmodule.R;

import java.util.ArrayList;
import java.util.List;


public class Connection extends Fragment implements ConnectionFilter.FilterListener {
    private SearchView searchView;
    private RecyclerView recyclerView;
    private ImageButton btnFilter;
    private List<ConnectionList> connectionList;
    private List<ConnectionList> filteredList;
    private ConnectionAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_connection, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        searchView = view.findViewById(R.id.searchView);
        btnFilter = view.findViewById(R.id.filterBtn);
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                ConnectionFilter filterDialog = new ConnectionFilter();
                filterDialog.setFilterListener(Connection.this); // Set the listener
                filterDialog.show(fragmentManager, "FilterDialog");
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Perform search dynamically as the user types
                searchFilter(newText);
                return true;
            }
        });

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DatabaseHelper databaseHelper = new DatabaseHelper(getContext());

        // Fetch data from database
        connectionList = databaseHelper.getAllItems();

        // Set up the adapter with the fetched data
        adapter = new ConnectionAdapter(connectionList);
        recyclerView.setAdapter(adapter);
    }

    private void showDialog() {
        if (getContext() != null) {
            Dialog dialog = new Dialog(getContext());
            dialog.setContentView(R.layout.fragment_connection_filter);
            dialog.show();
        }
    }

    private void searchFilter(String text) {
        if (filteredList == null) {
            filteredList = new ArrayList<>();
        }

        filteredList.clear();
        if (text.isEmpty()) {
            adapter = new ConnectionAdapter(connectionList);
            recyclerView.setAdapter(adapter);
        } else {
            for (ConnectionList item : connectionList) {
                if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                    // Add item to filtered list
                    filteredList.add(new ConnectionList(
                            item.getImageName1(),
                            item.getName(),
                            item.getRating(),
                            item.getDistance(),
                            item.getProducts(),
                            item.getProduct_prices(),
                            item.getImageName2()
                    ));
                }
            }

            adapter = new ConnectionAdapter(filteredList);
            recyclerView.setAdapter(adapter);

            // Show the RecyclerView if there are results
            if (filteredList.isEmpty()) {
                recyclerView.setVisibility(View.GONE); // Hide if no results
            } else {
                recyclerView.setVisibility(View.VISIBLE); // Show if there are results
            }
        }
        adapter.notifyDataSetChanged(); // Notify adapter of the data change
    }

    @Override
    public void onFilterApplied(String selectedProduct, Float selectedDistance, Float selectedRating, String selectedPrice) {
        filteredList = new ArrayList<>();
        // hi

        for (ConnectionList item : connectionList) {
            Log.d("Distance", selectedProduct + " " + selectedDistance + " " + selectedRating + " " + selectedPrice);
            boolean matches = true;

            // Apply filters if the values are not null
//            if (selectedProduct != null && !selectedProduct.equals(item.getProducts())) {
//                matches = false;
//            }
            if (selectedDistance != 0.0 && item.getDistance() != selectedDistance) {
                Log.d("Distance", "Selected: " + selectedDistance + ", Item: " + item.getDistance());
                matches = false;
            }
            if (selectedRating != 0.0 && item.getRating() != selectedRating) {
                matches = false;
            }
            if(selectedPrice != null){
                String [] split = item.getProduct_prices().split("/");
                float productPrice = Float.parseFloat(split[0].substring(2));

                if(productPrice > Float.parseFloat(selectedPrice.substring(2))){
                    matches = false;
                }
            }

            if (matches) {
                filteredList.add(item);
            }
        }

        // Update RecyclerView based on the filtered list
        if (filteredList.isEmpty()) {
            Toast.makeText(getContext(), "No results found", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Results found", Toast.LENGTH_SHORT).show();
            adapter = new ConnectionAdapter(filteredList);
            recyclerView.setAdapter(adapter);
        }
    }
}


