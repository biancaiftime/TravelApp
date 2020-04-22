package com.example.proiecttandroid.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.example.proiecttandroid.R;

public class GalleryImageAdapter extends BaseAdapter {
    private Context mContext;



    public GalleryImageAdapter(Context context)
    {
        mContext = context;
    }

    public int getCount() {
        return mImageIds.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }


    // Override this method according to your need
    public View getView(int index, View view, ViewGroup viewGroup)
    {
        // TODO Auto-generated method stub
        ImageView i = new ImageView(mContext);

        i.setImageResource(mImageIds[index]);
        i.setLayoutParams(new Gallery.LayoutParams(300, 300));

        i.setScaleType(ImageView.ScaleType.FIT_XY);


        return i;
    }

    public Integer[] mImageIds = {
            R.drawable.carcassonne,
            R.drawable.cartagena,
            R.drawable.dubai,
            R.drawable.dublin,
            R.drawable.dubrovnik,
            R.drawable.jerusalem,
            R.drawable.lasvegas,
            R.drawable.london,
            R.drawable.nashville,
            R.drawable.neworleans,
            R.drawable.paris,
            R.drawable.puntacana,
            R.drawable.rome,
            R.drawable.vallarta,
            R.drawable.varadero,
            R.drawable.venice,
            R.drawable.eaglebeach,
            R.drawable.playadelcarmen,
            R.drawable.cancun
    };
}
