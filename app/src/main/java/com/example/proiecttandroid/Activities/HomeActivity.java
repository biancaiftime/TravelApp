package com.example.proiecttandroid.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.proiecttandroid.R;

public class HomeActivity extends AppCompatActivity {

    private TextView title;
    private Button btnCategories;
    private Button btnGallery;
    private Button btnTrips;
    private  TextView explore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        title = findViewById(R.id.Title);
        Shader textShader=new LinearGradient(0, 0, 0, title.getTextSize(),
                new int[]{
                        Color.parseColor("#F97C3C"),
                        Color.parseColor("#FDB54E"),
                        Color.parseColor("#64B678"),
                        Color.parseColor("#478AEA"),
                        Color.parseColor("#8446CC"),
                }, null, Shader.TileMode.CLAMP);
        title.setTextColor(Color.parseColor("#F97C3C"));
        title.getPaint().setShader(textShader);

        explore = findViewById(R.id.explore);
        explore.setText("Explore the world via Google Maps as we can't travel right now.");

        btnCategories = findViewById(R.id.btnCategory);
        btnGallery = findViewById(R.id.btnGallery);
        btnTrips = findViewById(R.id.btnTrips);

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeActivity.this, GalleryActivity.class);
                HomeActivity.this.startActivity(myIntent);
            }
        });
        btnTrips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeActivity.this, TripsActivity.class);
                HomeActivity.this.startActivity(myIntent);
            }
        });
        btnCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeActivity.this, CategoriesActivity.class);
                HomeActivity.this.startActivity(myIntent);
            }
        });

        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeActivity.this, MapsActivity.class);
                HomeActivity.this.startActivity(myIntent);
            }
        });
    }
}
