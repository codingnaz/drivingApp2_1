package com.example.saimon22.drivingapp2_1;

/**
 * Created by SAimon22 on 9/20/2017.
 */

public class CurrentDriver {
    private static String currentfirstName, currentmiddleName, currentlastName,currentDOB, currentaddress, currentpassword, currentuserName;
    private static int currentSSN,currentstoreID;

    private static Driver currentDriver;

    public static String getCurrentfirstName() {
        return currentfirstName;
    }

    public static void setCurrentfirstName(String currentfirstName) {
        CurrentDriver.currentfirstName = currentfirstName;
    }

    public static String getCurrentmiddleName() {
        return currentmiddleName;
    }

    public static void setCurrentmiddleName(String currentmiddleName) {
        CurrentDriver.currentmiddleName = currentmiddleName;
    }

    public static String getCurrentlastName() {
        return currentlastName;
    }

    public static void setCurrentlastName(String currentlastName) {
        CurrentDriver.currentlastName = currentlastName;
    }

    public static String getCurrentaddress() {
        return currentaddress;
    }

    public static void setCurrentaddress(String currentaddress) {
        CurrentDriver.currentaddress = currentaddress;
    }

    public static String getCurrentpassword() {
        return currentpassword;
    }

    public static void setCurrentpassword(String currentpassword) {
        CurrentDriver.currentpassword = currentpassword;
    }

    public static String getCurrentuserName() {
        return currentuserName;
    }

    public static void setCurrentuserName(String currentuserName) {
        CurrentDriver.currentuserName = currentuserName;
    }

    public static int getCurrentSSN() {
        return currentSSN;
    }

    public static void setCurrentSSN(int currentSSN) {
        CurrentDriver.currentSSN = currentSSN;
    }

    public static String getCurrentDOB() {
        return currentDOB;
    }

    public static void setCurrentDOB(String currentDOB) {
        CurrentDriver.currentDOB = currentDOB;
    }

    public static int getCurrentstoreID() {
        return currentstoreID;
    }

    public static void setCurrentstoreID(int currentstoreID) {
        CurrentDriver.currentstoreID = currentstoreID;
    }

    public static Driver getCurrentDriver() {
        return currentDriver;
    }

    public CurrentDriver() {

    }

    public static void setCurrentDriver(Driver driver){
        CurrentDriver.currentDriver= driver;
        CurrentDriver.currentfirstName= currentDriver.getFirstName();
        CurrentDriver.currentlastName= currentDriver.getLastName();
        CurrentDriver.currentmiddleName= currentDriver.getMiddleName();
        CurrentDriver.currentuserName=currentDriver.getUserName();
        CurrentDriver.currentpassword= currentDriver.getPassword();
        CurrentDriver.currentaddress= currentDriver.getAddress();
        CurrentDriver.currentDOB= currentDriver.getDOB();
        CurrentDriver.currentSSN= currentDriver.getSSN();
        CurrentDriver.currentstoreID= currentDriver.getStoreID();

    }
}
