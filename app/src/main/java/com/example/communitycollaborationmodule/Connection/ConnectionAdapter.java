package com.example.communitycollaborationmodule.Connection;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitycollaborationmodule.R;

import java.util.List;

public class ConnectionAdapter extends RecyclerView.Adapter<ConnectionAdapter.FarmViewHolder> {

    private List<ConnectionList> connectionListList;

    public ConnectionAdapter(List<ConnectionList> connectionListList) {
        this.connectionListList = connectionListList;
    }

    @NonNull
    @Override
    public FarmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.connection_card_layout, parent, false);
        return new FarmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FarmViewHolder holder, int position) {
        ConnectionList connectionList = connectionListList.get(position);
        String imageName1= connectionList.getImageName1();
        String imageName2= connectionList.getImageName2();
        holder.connectionName.setText(connectionList.getName());
        holder.ratingBar.setRating(connectionList.getRating());
        holder.distance.setText(connectionList.getDistance()+" km away from you");
        holder.products.setText("Products:");
        holder.productName.setText(connectionList.getProducts());
        holder.productPrice.setText(connectionList.getProduct_prices());
        int imageResId1=connectionList.getImageResourceId(connectionList.getImageName1(),holder.itemView.getContext());
        int imageResId2=connectionList.getImageResourceId(connectionList.getImageName2(),holder.itemView.getContext());
        holder.connectionImage.setImageResource(imageResId1);
        holder.productImage.setImageResource(imageResId2);
    }

    @Override
    public int getItemCount() {
        return connectionListList.size();
    }

    static class FarmViewHolder extends RecyclerView.ViewHolder {
        TextView connectionName, distance, products,productName,productPrice;
        RatingBar ratingBar;
        ImageView connectionImage,productImage;

        public FarmViewHolder(@NonNull View itemView) {
            super(itemView);
            connectionImage = itemView.findViewById(R.id.connection_image);
            connectionName = itemView.findViewById(R.id.connection_title);
            ratingBar= itemView.findViewById(R.id.ratingBar);
            distance = itemView.findViewById(R.id.distance);
            products=itemView.findViewById(R.id.product);
            productImage=itemView.findViewById(R.id.product_image);
            productName = itemView.findViewById(R.id.product_name);
            productPrice=itemView.findViewById(R.id.product_price);
        }
    }
}
