package com.example.proiecttandroid.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.proiecttandroid.Adapters.CityAdapter;
import com.example.proiecttandroid.Models.Article;
import com.example.proiecttandroid.Models.Categories;
import com.example.proiecttandroid.Models.City;
import com.example.proiecttandroid.R;
import com.example.proiecttandroid.VolleyHelpers.HttpRequestQueue;

import org.json.JSONArray;
import org.json.JSONException;
import org.w3c.dom.Text;

public class ArticlesFragment extends Fragment {

    private String cityName;
    private TextView articleTitle;
    private TextView articleContent;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout =  inflater.inflate(R.layout.fragment_articles, container, false);

        articleTitle = layout.findViewById(R.id.ArticleTitle);
        articleContent = layout.findViewById(R.id.ArticleContent);

        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        cityName = sharedPref.getString("cityName", "");

        articleTitle.setText(cityName);
        getArticle();

        return layout;
    }

    private void getArticle()
    {
        String url = "https://my-json-server.typicode.com/biancaiftime/articles/Details?title=" + cityName;

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int index = 0; index < response.length(); index++){
                    try {
                        Article city = new Article().fromJSON(response.getJSONObject(index));
                        articleContent.setText(city.Content);

                    } catch (JSONException ex){

                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Volley error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        HttpRequestQueue.getInstance(getContext()).addToRequestQueue(jsonArrayRequest);
    }
}
