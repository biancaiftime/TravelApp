package com.example.proiecttandroid.Controllers;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.proiecttandroid.DataBase.AppDatabase;

import java.io.File;

import androidx.room.Room;

public class ApplicationController extends Application {
    private static ApplicationController mInstance;

    private static AppDatabase mAppDatabase;

    public static ApplicationController getInstance()
    {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        fixGoogleMapBug();
        mInstance = this;

        mAppDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "trip").build();
    }

    public static AppDatabase getAppDatabase()
    {
        return mAppDatabase;
    }

    private void fixGoogleMapBug() {
        SharedPreferences googleBug = getSharedPreferences("google_bug", Context.MODE_PRIVATE);
        if (!googleBug.contains("fixed")) {
            File corruptedZoomTables = new File(getFilesDir(), "ZoomTables.data");
            corruptedZoomTables.delete();
            googleBug.edit().putBoolean("fixed", true).apply();
        }
    }
}