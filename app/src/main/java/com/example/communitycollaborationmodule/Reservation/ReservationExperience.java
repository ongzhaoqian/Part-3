package com.example.communitycollaborationmodule.Reservation;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitycollaborationmodule.R;

import java.util.List;


public class ReservationExperience extends Fragment {
    private RecyclerView recyclerView;
    private ImageButton btnFilter;
    private List<ReservationList> reservationList;
    private ReservationAdapter adapter;
    private Reservation reservation;
    public ReservationExperience (Reservation reservation) {
        this.reservation=reservation;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reservation_experience, container, false);

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
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        DatabaseHelper2 databaseHelper = new DatabaseHelper2(getContext());

        // Fetch data from database
        reservationList = databaseHelper.getAllItems();

        // Set up the adapter with the fetched data
        adapter = new ReservationAdapter(reservationList,reservation);
        recyclerView.setAdapter(adapter);
    }

    private void showDialog() {

        Dialog dialog = new Dialog(this.getContext());
        dialog.setContentView(R.layout.fragment_reservation_filter);
        dialog.show();
    }
}