package com.example.communitycollaborationmodule.Reservation;

public class ReservationList {
    private String imageName;
    public int imageResourceId;
    private String reservation_name;

    private String description;
    private float rating;

    private String location;
    private String price;


    public ReservationList(String imageName,String reservation_name, String description,float rating, String location, String price) {
        this.imageName=imageName;
        this.reservation_name = reservation_name;
        this.description=description;
        this.rating=rating;
        this.location=location;
        this.price=price;
    }



    public String getName() {
        return reservation_name;
    }

    public float getRating(){
        return rating;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getPrices(){
        return price;
    }

    public String getImageName() {
        return imageName;
    }


    public int getImageResourceId(String imageResourceName, android.content.Context context) {
        int id=context.getResources().getIdentifier(imageResourceName,"drawable",context.getPackageName());
        return id;
    }



}

