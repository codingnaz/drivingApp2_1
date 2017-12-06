package com.example.saimon22.drivingapp2_1;

import android.support.design.internal.BottomNavigationMenu;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.Menu;

import com.roughike.bottombar.BottomBar;
//import com.roughike.bottombar.OnMenu

public class WelcomePage extends AppCompatActivity {
    BottomBar nbottombar;

    TextView ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        ma=(TextView)findViewById(R.id.mas);
        ma.setText("Welcome "+CurrentDriver.getCurrentfirstName());
        /*nbottombar.setItemsF
        nbottombar = BottomBar.attach(this, savedInstanceState);
*/

    }

}
