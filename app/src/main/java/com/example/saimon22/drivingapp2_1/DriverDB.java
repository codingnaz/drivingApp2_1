package com.example.saimon22.drivingapp2_1;

import java.util.ArrayList;

import Exceptions.indexOutOfBoundExcepetion;
import IndexedList.IndexedList;
import OrderList.OrderList;

public class DriverDB {
    //private static OrderList<Driver> drivers=new OrderList();


    private static MyArrayList<Driver> drivers = new MyArrayList<>();

    public static MyArrayList<Driver> getUsersArrayList() {
        return drivers;
    }

    public static void setUsersArrayList(MyArrayList<Driver> drivers) {
        DriverDB.drivers = drivers;
    }




//    private static ArrayList<Driver> drivers = new ArrayList<Driver>();
//
//    public static ArrayList<Driver> getUsersArrayList() {
//        return drivers;
//    }
//
//    public static void setUsersArrayList(ArrayList<Driver> users) {
//        DriverDB.drivers = drivers;
//    }

    public static void printArrayList() throws indexOutOfBoundExcepetion {
        for (int i=0; i < drivers.size(); i++) {

            System.out.print(drivers.get(i).getFirstName());
            System.out.print(" " + drivers.get(i).getLastName());
            System.out.print(" " + drivers.get(i).getMiddleName());
            System.out.print(" " + drivers.get(i).getSSN());
            System.out.print(" " + drivers.get(i).getDOB());
            System.out.print(" " + drivers.get(i).getAddress());
            System.out.print(" " + drivers.get(i).getUserName());
            System.out.print(" " + drivers.get(i).getPassword());
            System.out.print(" " + drivers.get(i).getStoreID());


            System.out.println();
        }
    }
}