package com.example.communitycollaborationmodule;



public class SubscriptionProcessList {
    private String productName;
    private String source;
    private double pricePerUnit;
    private int quantity;
    private String deliverySchedule;
    private String planType; // Weekly or Monthly

    public SubscriptionPlan(String productName, String source, double pricePerUnit, int quantity, String deliverySchedule, String planType) {
        this.productName = productName;
        this.source = source;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
        this.deliverySchedule = deliverySchedule;
        this.planType = planType;
    }

    // Getters and Setters
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public double getPricePerUnit() { return pricePerUnit; }
    public void setPricePerUnit(double pricePerUnit) { this.pricePerUnit = pricePerUnit; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getDeliverySchedule() { return deliverySchedule; }
    public void setDeliverySchedule(String deliverySchedule) { this.deliverySchedule = deliverySchedule; }

    public String getPlanType() { return planType; }
    public void setPlanType(String planType) { this.planType = planType; }

    public double calculateTotalPrice() {
        return pricePerUnit * quantity;
    }
}
