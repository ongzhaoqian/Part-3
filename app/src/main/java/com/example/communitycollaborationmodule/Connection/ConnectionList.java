package com.example.communitycollaborationmodule.Connection;



public class ConnectionList {
    private String imageName1;
    private int imageResourceId;
    private String connection_name;
    private float rating;
    private float distance;
    private String product_name;

    private String product_prices;

    private String imageName2;

    public ConnectionList(String imageName1,String connection_name, float rating,float distance, String product_name, String product_prices,String imageName2) {
        this.imageName1=imageName1;
        this.connection_name = connection_name;
        this.rating=rating;
        this.distance = distance;
        this.product_name = product_name;
        this.product_prices = product_prices;
        this.imageName2=imageName2;
    }



    public String getName() {
        return connection_name;
    }

    public float getRating(){
        return rating;
    }

    public float getDistance() {
        return distance;
    }

    public String getProducts() {
        return product_name;
    }

    public String getProduct_prices(){
        return product_prices;
    }

    public String getImageName1() {
        return imageName1;
    }

    public String getImageName2() {
        return imageName2;
    }

    public int getImageResourceId(String imageResourceName,android.content.Context context) {
        int id=context.getResources().getIdentifier(imageResourceName,"drawable",context.getPackageName());
        return id;
    }



}
