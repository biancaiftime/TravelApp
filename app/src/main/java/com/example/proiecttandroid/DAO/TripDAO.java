package com.example.proiecttandroid.DAO;

import com.example.proiecttandroid.Models.Trip;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface TripDAO {
    @Query("SELECT * FROM trip")
    List<Trip> getAll();

    @Query("SELECT * FROM trip WHERE uid IN (:tripIds)")
    List<Trip> loadAllByIds(int[] tripIds);

    @Query("SELECT * FROM trip WHERE location LIKE :location LIMIT 1")
    Trip findByLocation(String location);

    @Insert
    void insertAll(Trip... trips);

    @Delete
    void delete(Trip trip);

}
