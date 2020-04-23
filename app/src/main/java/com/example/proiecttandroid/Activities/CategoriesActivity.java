package com.example.proiecttandroid.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.proiecttandroid.Fragments.ArticlesFragment;
import com.example.proiecttandroid.Fragments.CitiesFragment;
import com.example.proiecttandroid.R;

public class CategoriesActivity extends AppCompatActivity {

    private CitiesFragment citiesFragment = new CitiesFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        addFragment(citiesFragment);
    }

    public  void addFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.FragmentManagerCity,fragment);
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.FragmentManagerCity, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
