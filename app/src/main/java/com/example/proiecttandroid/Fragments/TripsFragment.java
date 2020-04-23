package com.example.proiecttandroid.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proiecttandroid.Adapters.TripsAdapter;
import com.example.proiecttandroid.Models.Trip;
import com.example.proiecttandroid.R;
import com.example.proiecttandroid.Repositories.TripRepository;
import com.example.proiecttandroid.Repositories.TripRepositoryActionListener;

import java.util.ArrayList;
import java.util.List;

public class TripsFragment extends Fragment {

    private RecyclerView ListOfTrips;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Trip> trips = new ArrayList<Trip>();
    private TripRepository tripRepository;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout =  inflater.inflate(R.layout.fragment_trips, container, false);

        tripRepository = new TripRepository(getActivity().getApplicationContext());
        trips = tripRepository.getAll(new TripRepositoryActionListener());

        ListOfTrips = layout.findViewById(R.id.ListOfTrips);
        ListOfTrips.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        ListOfTrips.setLayoutManager(layoutManager);
        adapter = new TripsAdapter(trips);
        ListOfTrips.setAdapter(adapter);

        return layout;
    }

    public void addItem(Trip trip)
    {
        ((TripsAdapter)adapter).addItem(trip);
    }
}
