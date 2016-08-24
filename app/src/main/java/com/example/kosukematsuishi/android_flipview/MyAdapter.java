package com.example.kosukematsuishi.android_flipview;

import android.database.DataSetObserver;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;

/**
 * Created by kosuke.matsuishi on 2016/08/24.
 */
public class MyAdapter implements ListAdapter {
    private int[] imageResources = {
            R.drawable.obama, R.drawable.road_rage, R.drawable.taipei_101, R.drawable.world, R.drawable.yudetaro_logo
    };

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return imageResources.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_page, null);
        }
        convertView.setBackgroundColor(Color.WHITE);
        imageView = (ImageView) convertView.findViewById(R.id.image_view);
        imageView.setImageDrawable(parent.getContext().getDrawable(imageResources[position]));
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
