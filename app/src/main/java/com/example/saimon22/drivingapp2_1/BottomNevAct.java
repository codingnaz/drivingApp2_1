package com.example.saimon22.drivingapp2_1;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class BottomNevAct extends AppCompatActivity {


    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle("Home");
                    Home fragemntHome= new Home();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content, fragemntHome,"FragemntHome");
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_call:
                    dialContactPhone("7033685647");

                    return true;
                case R.id.navigation_earning:
                    setTitle("Home");
                    EarningPage fragmentEarnig= new EarningPage();
                    android.support.v4.app.FragmentTransaction fragmentTransactionEarning = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionEarning.replace(R.id.content, fragmentEarnig,"FragemntHome");
                    fragmentTransactionEarning.commit();
                    return true;
                case R.id.navigation_old_order:
                    setTitle("Old Order");
                    Old_order_page fragemntOldOrder= new Old_order_page();
                    android.support.v4.app.FragmentTransaction fragmentTransactionoldOrder = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionoldOrder.replace(R.id.content, fragemntOldOrder,"FragemntOldOrderPage");
                    fragmentTransactionoldOrder.commit();

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nev);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setTitle("Home");
        Home fragemntHome= new Home();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragemntHome,"FragemntHome");
        fragmentTransaction.commit();
    }

}
