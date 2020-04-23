package com.example.proiecttandroid.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.proiecttandroid.Adapters.CityAdapter;
import com.example.proiecttandroid.Models.Categories;
import com.example.proiecttandroid.Models.City;
import com.example.proiecttandroid.R;
import com.example.proiecttandroid.VolleyHelpers.HttpRequestQueue;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class CitiesFragment extends Fragment {


    private RecyclerView[] ListOfCities;
    private RecyclerView.Adapter[] adapter;
    private RecyclerView.LayoutManager[] layoutManager;
    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout =  inflater.inflate(R.layout.fragment_cities, container, false);

        ListOfCities = new RecyclerView[5];
        adapter = new RecyclerView.Adapter[5];
        layoutManager = new RecyclerView.LayoutManager[5];

        ListOfCities[0]= layout.findViewById(R.id.ListOfBeaches);  ListOfCities[1]= layout.findViewById(R.id.ListOfPopular);
        ListOfCities[2]= layout.findViewById(R.id.ListOfRomantic);  ListOfCities[3]= layout.findViewById(R.id.ListOfHistory);
        ListOfCities[4]= layout.findViewById(R.id.ListOfMusic);

        int position = 0;
        for(Categories category : Categories.values())
        {
            getCities(category, position);
            ListOfCities[position].setHasFixedSize(true);
            layoutManager[position]= new LinearLayoutManager(this.getContext());
            adapter[position]= new CityAdapter(new ArrayList<City>(), getActivity());
            ListOfCities[position].setLayoutManager(layoutManager[position]);
            ListOfCities[position].setAdapter(adapter[position]);
            position ++;
        }

        return layout;
    }

    private void getCities(Categories category, final int position)
    {
        String url = "https://my-json-server.typicode.com/biancaiftime/cities/" + category.name();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                ((CityAdapter)adapter[position]).clearList();

                for(int index = 0; index < response.length(); index++){
                    try {
                        City city = new City().fromJSON(response.getJSONObject(index));
                        ((CityAdapter)adapter[position]).addItem(city);

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
