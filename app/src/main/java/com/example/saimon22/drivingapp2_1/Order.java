package com.example.saimon22.drivingapp2_1;

import android.location.Address;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by SAimon22 on 12/8/2017.
 */

public class Order {
    String  CLName;
    Date orderdate;
    Address address;

    String phoneNumber;

    public double getPrice() {
        double p=0;
        for(int i=0;i<items.size();i++){
            p=p+items.get(i).getItemPrice();
        }
        return p;
    }
    public double getPriceWithTax() {
        double p=0;
        for(int i=0;i<items.size();i++){
            p=p+items.get(i).getItemPrice();
        }
        return (p+(p*.05));
    }

    double price;
    ArrayList<orderItem> items;
    public Order() throws ParseException {
        String phoneNum = "5552223333";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = sdf.parse("21/12/2012");
        ArrayList<orderItem> itemlist= new ArrayList<orderItem>();
        itemlist.add(new orderItem("item1",12.2,"",""));
        itemlist.add(new orderItem("item2",13.2,"",""));

        new Order("CFName", "CLName",d , address, phoneNum, itemlist);
    }
    public Order(String CFName, String CLName, Date orderdate, Address address, String phoneNumber, ArrayList<orderItem> items) {
        this.CFName = CFName;
        this.CLName = CLName;
        this.orderdate = orderdate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.items = items;
    }


    public String getCFName() {
        return CFName;
    }

    public void setCFName(String CFName) {
        this.CFName = CFName;
    }

    public String getCLName() {
        return CLName;
    }

    public void setCLName(String CLName) {
        this.CLName = CLName;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<orderItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<orderItem> items) {
        this.items = items;
    }

    String  CFName;





}
