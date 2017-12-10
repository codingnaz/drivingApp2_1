package com.example.saimon22.drivingapp2_1;

/**
 * Created by SAimon22 on 12/8/2017.
 */

public class orderItem {
    String itemName;
    double itemPrice;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemDiscription() {
        return ItemDiscription;
    }

    public void setItemDiscription(String itemDiscription) {
        ItemDiscription = itemDiscription;
    }

    public String getSpecialRequest() {
        return SpecialRequest;
    }

    public void setSpecialRequest(String specialRequest) {
        SpecialRequest = specialRequest;
    }

    String ItemDiscription;
    String SpecialRequest;

    public orderItem(String itemName, double itemPrice, String itemDiscription, String specialRequest) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        ItemDiscription = itemDiscription;
        SpecialRequest = specialRequest;
    }
}
