package com.example.proiecttandroid.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.proiecttandroid.Models.Trip;
import com.example.proiecttandroid.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TripsAdapter extends RecyclerView.Adapter<TripsAdapter.ViewHolder> {

    private List<Trip> mDataset;

    public TripsAdapter(List<Trip> trips) {
        mDataset = trips;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.trip_view, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.location.setText(mDataset.get(i).location);
        viewHolder.date.setText(mDataset.get(i).date.toString());
        viewHolder.duration.setText(mDataset.get(i).duration+"");
        viewHolder.reminder.setChecked(mDataset.get(i).reminder);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView location;
        public TextView date;
        public TextView duration;
        public CheckBox reminder;

        public ViewHolder(View vCard) {
            super(vCard);
            location = vCard.findViewById(R.id.locationList);
            date = vCard.findViewById(R.id.date_viewList);
            duration = vCard.findViewById(R.id.durationList);
            reminder = vCard.findViewById(R.id.reminderList);
        }
    }

    public void addItem(Trip trip) {
        mDataset.add(trip);
        notifyDataSetChanged();
    }

    //
    public void clearList() {
        mDataset.clear();
        notifyDataSetChanged();
    }

    public Trip find(int position) {
        return mDataset.get(position);
    }
}

