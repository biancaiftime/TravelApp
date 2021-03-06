package com.example.proiecttandroid.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;

import com.example.proiecttandroid.Fragments.AddTripFragment;
import com.example.proiecttandroid.Fragments.TripsFragment;
import com.example.proiecttandroid.Models.Trip;
import com.example.proiecttandroid.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class TripsActivity extends AppCompatActivity {

    private AddTripFragment addTripFragment = new AddTripFragment();
    private TripsFragment tripsFragment = new TripsFragment();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips);
        addFragment(tripsFragment);
        addFragment(addTripFragment);
    }

    public  void addFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.FragmentManager,fragment);
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.FragmentManager, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public void addItem(Trip trip)
    {
        tripsFragment.addItem(trip);
    }
}
