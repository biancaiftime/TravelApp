package com.example.proiecttandroid.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.proiecttandroid.Activities.CategoriesActivity;
import com.example.proiecttandroid.Fragments.ArticlesFragment;
import com.example.proiecttandroid.Models.City;
import com.example.proiecttandroid.Models.Trip;
import com.example.proiecttandroid.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    private List<City> mDataset;
    private Context mContext;

    public CityAdapter(List<City> cityList, Context context) {
        mDataset = cityList;
        mContext = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.city_view, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.name.setText(mDataset.get(i).Name);
        viewHolder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = ((Activity)mContext).getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("cityName", mDataset.get(i).Name);
                editor.apply();
                ((CategoriesActivity)mContext).replaceFragment(new ArticlesFragment());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;

        public ViewHolder(View vCard) {
            super(vCard);
            name = vCard.findViewById(R.id.city_name);
        }
    }

    public void addItem(City city) {
        mDataset.add(city);
        notifyDataSetChanged();
    }

    //
    public void clearList() {
        mDataset.clear();
        notifyDataSetChanged();
    }

    public City find(int position) {
        return mDataset.get(position);
    }
}
