package com.example.proiecttandroid.Models;



import java.util.Date;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

@Entity
@TypeConverters(DateConverter.class)
public class Trip {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name="Location")
    public String location;

    @ColumnInfo(name="Date")
    public Date date;

    @ColumnInfo(name="Duration")
    public int duration;

    @ColumnInfo(name="Reminder")
    public boolean reminder;

    public Trip(String location, Date date, int duration, boolean reminder) {
        this.location = location;
        this.date = date;
        this.duration = duration;
        this.reminder = reminder;
    }
}


