package com.example.communitycollaborationmodule.Reservation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitycollaborationmodule.R;

import java.util.List;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationAdapter.ReservationViewHolder> {

    private List<ReservationList> reservationList;
    private Reservation reservation;

    public ReservationAdapter(List<ReservationList> reservationList, Reservation reservation) {
        this.reservationList = reservationList;
        this.reservation=reservation;
    }

    @NonNull
    @Override
    public ReservationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reservation_card_layout, parent, false);
        return new ReservationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReservationViewHolder holder, int position) {
        ReservationList reservationListList = reservationList.get(position);

        Log.d("position",Float.toString(reservationListList.getRating()));
        String reservationName = reservationListList.getName();
        String description = reservationListList.getDescription();
        String location = reservationListList.getLocation();
        float rating = reservationListList.getRating();
        String imageName= reservationListList.getImageName();
        holder.reservationName.setText(reservationListList.getName());
        holder.description.setText(reservationListList.getDescription());
        holder.ratingBar.setRating(rating);
        holder.price.setText(reservationListList.getPrices());
        int imageResId=reservationListList.getImageResourceId(reservationListList.getImageName(),holder.itemView.getContext());
        holder.reservationImage.setImageResource(imageResId);

        holder.viewDetails.setOnClickListener(v -> {
            Log.d("ReservationAdapter", "View Details clicked for: " + reservationListList.getName());
            reservation.onItemClicked(reservationListList);
//            // When an item is clicked, pass the data to a new Fragment
//            Fragment fragment = new ReservationDetail();
//            Bundle bundle = new Bundle();
//            bundle.putSerializable("image", imageResId);
//            bundle.putSerializable("name", reservationName);
//            bundle.putSerializable("description", description);
//            bundle.putSerializable("location", location);
//            bundle.putSerializable("rating", rating);
//
//            fragment.setArguments(bundle);

        });
    }

    @Override
    public int getItemCount() {
        return reservationList.size();
    }

    static class ReservationViewHolder extends RecyclerView.ViewHolder {
        TextView reservationName, description, price;
        RatingBar ratingBar;
        ImageView reservationImage;
        Button viewDetails;

        public ReservationViewHolder(@NonNull View itemView) {
            super(itemView);
            reservationImage = itemView.findViewById(R.id.reservation_image);
            reservationName = itemView.findViewById(R.id.reservation_title);
            ratingBar= itemView.findViewById(R.id.reservation_ratingBar);
            description=itemView.findViewById(R.id.reservation_description);
            price=itemView.findViewById(R.id.reservation_price);
            viewDetails=itemView.findViewById(R.id.viewReservationDetailsBtn);
        }
    }
}