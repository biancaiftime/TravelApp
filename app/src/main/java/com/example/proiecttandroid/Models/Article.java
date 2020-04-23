package com.example.proiecttandroid.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class Article {

    public int Id;
    public String Title;
    public String Content;

    public Article(int id, String title, String content) {
        Id = id;
        Title = title;
        Content = content;
    }

    public Article() {}

    public Article fromJSON(JSONObject jsonObject) throws JSONException {
        return new Article(jsonObject.getInt("id"),
                jsonObject.getString("title"),
                jsonObject.getString("content"));
    }
}
