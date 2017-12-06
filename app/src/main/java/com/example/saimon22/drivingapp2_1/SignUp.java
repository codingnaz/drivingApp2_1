package com.example.saimon22.drivingapp2_1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import Exceptions.dublicatAddException;
import Exceptions.indexOutOfBoundExcepetion;

import static java.lang.Integer.parseInt;

public class SignUp extends AppCompatActivity implements View.OnClickListener,  View.OnTouchListener {
    Button backToSignIn, comfarmButton,test;
    EditText etFirstName, etLastName, etMiddleName,etUserName, etPassword,etconfirmPassword,etSSN,etDOB,etstoreId, etaddress;
    TextView Massage;
    boolean hasError= false;
    String massages="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        backToSignIn=(Button)findViewById(R.id.backToSignIn);
        comfarmButton=(Button)findViewById(R.id.confirmButton);
        test=(Button)findViewById(R.id.testrun);
        etFirstName=(EditText) findViewById(R.id.firstName);
        etDOB=(EditText) findViewById(R.id.BOD);
        etPassword=(EditText) findViewById(R.id.password);
        etSSN=(EditText) findViewById(R.id.SSN);
        etaddress=(EditText) findViewById(R.id.address);
        etconfirmPassword=(EditText) findViewById(R.id.confirmPassword);
        etLastName=(EditText) findViewById(R.id.lastName);
        etMiddleName=(EditText) findViewById(R.id.middleName);
        etstoreId=(EditText) findViewById(R.id.storeId);
        etUserName=(EditText) findViewById(R.id.userName);
        Massage=(TextView)findViewById(R.id.massage);

        comfarmButton.setOnClickListener(this);
        backToSignIn.setOnClickListener(this);
        etconfirmPassword.setOnTouchListener(this);
        etUserName.setOnTouchListener(this);
        etPassword.setOnTouchListener(this);
        test.setOnClickListener(this);



    }


    public String gPassword(){
        if(!etPassword.getText().toString().isEmpty()){
            Pattern patternPassword = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}");
            if(patternPassword.matcher(etPassword.getText().toString()).matches()){
                if(!etPassword.getText().toString().equals(etconfirmPassword)){
                    massages=massages+"\n Password does not match ";
                    hasError=true;
                    return etPassword.getText().toString();

                }

                return etPassword.getText().toString();
            }

        }
        massages=massages+"\n Please put Password ";
        hasError=true;
        return "";




    }
    public int gSSN(){
        int temp= 0;
        if (!etSSN.getText().toString().isEmpty()) {
            Pattern ssnPattern = Pattern.compile("^(?!000|666)[0-8][0-9]{2}(?!00)[0-9]{2}(?!0000)[0-9]{4}$");
            if (!ssnPattern.matcher(etSSN.getText().toString()).matches()) {
                hasError=true;
                massages= massages+"\n **SSN should be like 222114444";


            } else {
                temp= parseInt(etSSN.getText().toString());

            }
        }
        return temp;
    }
    private String gDOB() {

        SimpleDateFormat dobFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date dt = null;

        try {
            dt = dobFormat.parse(etDOB.getText().toString());

            return etDOB.getText().toString();
            //return dt;

        } catch (ParseException e) {
            massages=massages + "\n" + "+The date must be of format mm/dd/yyyy separated by slashes.";

        }
        return null;
    }
    public String gfirstName(){
        massages="";

        if( etFirstName.getText().toString().isEmpty())
        {
            hasError= true;
            massages=massages+ "\n First Name Error";
        }
        return etFirstName.getText().toString();


    }
    public String glastName(){


        if( etLastName.getText().toString().isEmpty())
        {
            hasError= true;
            massages=massages+ "\n last Name Error";

        }
        return etFirstName.getText().toString();


    }

    public String gmiddleName(){


        if( etMiddleName.getText().toString().isEmpty())
        {

            massages=massages+ " \n middle Name Error";

        }
        return etFirstName.getText().toString();


    }
    public boolean userExit() throws indexOutOfBoundExcepetion {
        boolean temp=false;
        for (int i = 0; i < DriverDB.getUsersArrayList().size(); i++) {
            //check to see if a username user inputs exists
            if (etUserName.getText().toString().equals(DriverDB.getUsersArrayList().get(i).getUserName())) {
                hasError= true;
                massages=massages+ "\n user Name exit";
                temp= true;
            }
        }
        return temp;
    }
    public String guserName() throws indexOutOfBoundExcepetion {


        if( etMiddleName.getText().toString().isEmpty() && userExit())
        {
            hasError= true;
            massages=massages+ "\n **middle Name Error";

        }else {

            return etFirstName.getText().toString();
        }
        return etFirstName.getText().toString();


    }
    public int gStoreId(){
        int id=0;
        try{

            id=Integer.parseInt(etstoreId.getText().toString());
        }catch ( Exception e){
            hasError=true;
            massages=massages+"\n Store Id need to be int";
        }
        return id;
    }






    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.backToSignIn:
                startActivity(new Intent(this,signinPage.class));

            case R.id.confirmButton:
                try {
                    System.out.print(gfirstName()+gmiddleName()+glastName()+guserName()+ etaddress.getText().toString()+ gSSN()+ gStoreId() );
                } catch (Exceptions.indexOutOfBoundExcepetion indexOutOfBoundExcepetion) {
                    indexOutOfBoundExcepetion.printStackTrace();
                }

                if(hasError==false){
                    //Driver registerdata= null;
                    try {
                      Driver  registerdata = new Driver(gfirstName(),gmiddleName(),glastName(),guserName(),gPassword(), etaddress.getText().toString(), gDOB(), gSSN(), gStoreId());
                        DriverDB.getUsersArrayList().add(registerdata);

                        DriverDB.setUsersArrayList(DriverDB.getUsersArrayList());
                        DriverIO.writeUsers(DriverDB.getUsersArrayList());
                    } catch (Exceptions.indexOutOfBoundExcepetion indexOutOfBoundExcepetion) {
                        Massage.setText("error");
                        Massage.setTextColor(Color.RED);

                        indexOutOfBoundExcepetion.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
//                    try {
//
//                        DriverDB.getUsersArrayList().add(registerdata);
//                    } catch (dublicatAddException e) {
//                        e.printStackTrace();
//                    }
                    startActivity(new Intent(this, signinPage.class));
                }
            case R.id.testrun:
               // Driver registerdata= new Driver("Nazmul","m","dow","s","@Logmein22", "1222", "10/10/2010", 222113333, 11);
                try {
                    //DriverDB.getUsersArrayList().add(registerdata);
                    //DriverDB.getUsersArrayList().add(new Driver("Naz","m","dow","ss","@Logmein22", "1222", "10/10/2010", 222113333, 11));
                    DriverDB.getUsersArrayList().add(new Driver("Naz","m","dow","sas","@Logmein22", "1222", "10/10/2010", 222113333, 11));
                    //DriverDB.getUsersArrayList().
                    DriverIO.writeUsers(DriverDB.getUsersArrayList());
                    DriverDB.getUsersArrayList().add(new Driver("Naz","m","dow","as","@Logmein22", "1222", "10/10/2010", 222113333, 11));
                    //DriverDB.getUsersArrayList().
                    DriverIO.writeUsers(DriverDB.getUsersArrayList());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(this, signinPage.class));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()){
            case R.id.password:
                Pattern patternPassword = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}");
                if(!patternPassword.matcher(etPassword.getText().toString()).matches()){

                    etPassword.setTextColor(Color.RED);

                }else{
                    etPassword.setTextColor(Color.GREEN);
                }

            case R.id.confirmPassword:
                if(!etconfirmPassword.getText().equals(etPassword.getText())&& etconfirmPassword.getText().toString().isEmpty()){
                    //etconfirmPassword.setBackgroundColor(Color.RED);
                    etconfirmPassword.setTextColor(Color.RED);

                    etconfirmPassword.setBackground(getResources().getDrawable(R.drawable.wrongtextediterbackground) );

                    break;

                }else if(etconfirmPassword.getText().equals(etPassword.getText())){

                    etconfirmPassword.setTextColor(Color.GREEN);
                    break;
                } else{
                    etconfirmPassword.setBackground(getResources().getDrawable(R.drawable.edittextbackground));
                    etconfirmPassword.setTextColor(Color.WHITE);

                }
            case R.id.userName:
                try {
                    if(userExit()){
                        etUserName.setTextColor(Color.GRAY);

                    }else{
                        etUserName.setTextColor(Color.BLACK);

                    }
                } catch (Exceptions.indexOutOfBoundExcepetion indexOutOfBoundExcepetion) {
                    indexOutOfBoundExcepetion.printStackTrace();
                }


        }


        return false;
    }
}
