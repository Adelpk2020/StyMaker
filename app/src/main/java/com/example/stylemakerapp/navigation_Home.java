package com.example.stylemakerapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

//import android.widget.RelativeLayout;

public class navigation_Home extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    ArrayList productsNames = new ArrayList<>(Arrays.asList("T-Shirts", "Visiting_Cards","Banner","Mugs" ,"Bags", "KeyChains","Stationary","Calenders"));
    ArrayList productsImages = new ArrayList<>(Arrays.asList(R.drawable.tshirt, R.drawable.visiting_card,R.drawable.banner2, R.drawable.mug, R.drawable.bag, R.drawable.keychain,R.drawable.stationary,R.drawable.calender));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_home);
        drawerLayout = findViewById(R.id.drawer);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toggle = new ActionBarDrawerToggle
                (
                        this,
                        drawerLayout,
                        R.string.open,
                        R.string.close
                )
        {
        };
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        // get the reference of RecyclerView
        RecyclerView recyclerView = findViewById(R.id.products_rv);
        // set a GridLayoutManager with default vertical orientation and 2 number of columns
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapter customAdapter = new CustomAdapter(navigation_Home.this, productsNames,productsImages);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.home_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        DrawerLayout drawerLayout;
        drawerLayout= findViewById(R.id.drawer);
        switch (item.getItemId())
        {
            case R.id.notification_id :
                //drawerLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
                Toast.makeText(this,item.getTitle().toString(), Toast.LENGTH_LONG).show();
                break;
            case R.id.profile_id :
               // drawerLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                Toast.makeText(this,item.getTitle().toString(), Toast.LENGTH_LONG).show();
                break;
            case R.id.cart_id :
               // drawerLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
                Toast.makeText(this,item.getTitle().toString(), Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}
