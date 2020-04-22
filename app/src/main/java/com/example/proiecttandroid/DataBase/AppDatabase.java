package com.example.proiecttandroid.DataBase;


import com.example.proiecttandroid.DAO.TripDAO;
import com.example.proiecttandroid.Models.Trip;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Trip.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TripDAO tripDAO();
}
