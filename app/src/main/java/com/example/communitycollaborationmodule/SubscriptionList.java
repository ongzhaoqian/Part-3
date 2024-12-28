package com.example.communitycollaborationmodule;

public class SubscriptionList {
    private String title;
    private String weeklyPrice;
    private String monthlyPrice;
    private int imageResId;

    public SubscriptionList(String title, String weeklyPrice, String monthlyPrice, int imageResId) {
        this.title = title;
        this.weeklyPrice = weeklyPrice;
        this.monthlyPrice = monthlyPrice;
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getWeeklyPrice() {
        return weeklyPrice;
    }

    public String getMonthlyPrice() {
        return monthlyPrice;
    }

    public int getImageResId() {
        return imageResId;
    }
}

