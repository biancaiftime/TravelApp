package com.example.proiecttandroid.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class City {

    public int Id;
    public  String Name;

    public City(int id, String name) {
        Id = id;
        Name = name;
    }

    public City() {}

    public City fromJSON(JSONObject jsonObject) throws JSONException {
        return new City(jsonObject.getInt("id"),
                jsonObject.getString("name"));
    }
}
