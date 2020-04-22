package com.example.proiecttandroid.Controllers;

import android.app.Application;

import com.example.proiecttandroid.DataBase.AppDatabase;

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

        mInstance = this;

        mAppDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "trip").build();
    }

    public static AppDatabase getAppDatabase()
    {
        return mAppDatabase;
    }

}