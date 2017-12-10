package com.example.saimon22.drivingapp2_1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import Exceptions.indexOutOfBoundExcepetion;
import IndexedList.IndexedList;

public class signinPage extends AppCompatActivity implements View.OnClickListener {

    TextView resister, errmassage,chengePasswords;
    EditText loginUserId,LogeinPassword;
    Button loginButton;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void authenticate() throws indexOutOfBoundExcepetion {
        Driver driver = null;
        try {
            DriverDB.setUsersArrayList((MyArrayList<Driver>) DriverIO.readUsers());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (loginUserId.getText().toString().isEmpty() || LogeinPassword.getText().toString().isEmpty()) {
            loginUserId.setBackground(getResources().getDrawable(R.drawable.wrongusernamebackground));
            LogeinPassword.setBackground(getResources().getDrawable(R.drawable.wrongpasswordbackground));
            errmassage.setText("put your User name and password");
        } else {

            String s="";
            for (int i = 0; i < DriverDB.getUsersArrayList().size(); i++) {
                s=" u "+ DriverDB.getUsersArrayList().get(i).getUserName()+" p "+DriverDB.getUsersArrayList().get(i).getPassword()+"Size "+DriverDB.getUsersArrayList().size()+"\n";

                if (loginUserId.getText().toString().equals(DriverDB.getUsersArrayList().get(i).getUserName())) {
                    driver = DriverDB.getUsersArrayList().get(i);

                }
            }errmassage.setText(s);



            if (driver==null) {
                loginUserId.setBackground(getResources().getDrawable(R.drawable.wrongusernamebackground));
                LogeinPassword.setBackground(getResources().getDrawable(R.drawable.wrongpasswordbackground));



                //errmassage.setText("driver is null");


            } else if (LogeinPassword.getText().toString().equals(driver.getPassword())) {
                startActivity(new Intent(this,WelcomePage.class));
                startActivity(new Intent(this,BottomNevAct.class));

                CurrentDriver.setCurrentDriver(driver);

            } else {
                loginUserId.setBackground(getResources().getDrawable(R.drawable.wrongusernamebackground));
                LogeinPassword.setBackground(getResources().getDrawable(R.drawable.wrongpasswordbackground));
            }
        }
    }
    public void resetPassword(){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            DriverDB.setUsersArrayList((MyArrayList<Driver>) DriverIO.readUsers());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        setContentView(R.layout.activity_signin_page);
        resister=(TextView)findViewById(R.id.register);
        errmassage=(TextView)findViewById(R.id.errorMass);
        resister.setOnClickListener(this);
        chengePasswords=(TextView)findViewById(R.id.ChangePasswordlink);
        chengePasswords.setOnClickListener(this);
        loginUserId=(EditText)findViewById(R.id.loginUsername);
        LogeinPassword=(EditText)findViewById(R.id.logInPassword);
        loginButton=(Button)findViewById(R.id.LogInButton);
        loginButton.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ChangePasswordlink:
                startActivity(new Intent(this, ChangePasswordPage.class));
                break;
            case R.id.register:
                startActivity(new Intent(this, SignUp.class));
                break;
            case R.id.LogInButton:

                try {
                    authenticate();
                } catch (Exceptions.indexOutOfBoundExcepetion indexOutOfBoundExcepetion) {
                    errmassage.setText("we got a indexOutOfBoundExcepetion");
                    errmassage.setTextColor(Color.RED);

                    indexOutOfBoundExcepetion.printStackTrace();
                }
                break;
        }
    }
}
