package com.example.communitycollaborationmodule.Connection;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitycollaborationmodule.R;

import java.util.List;


public class Connection extends Fragment {

        private RecyclerView recyclerView;
        private ImageButton btnFilter;
        private List<ConnectionList> connectionList;
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

            btnFilter = view.findViewById(R.id.filterBtn);
            btnFilter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog();
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
    }


