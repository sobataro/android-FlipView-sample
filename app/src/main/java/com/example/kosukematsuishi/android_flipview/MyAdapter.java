package com.example.kosukematsuishi.android_flipview;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

/**
 * Created by kosuke.matsuishi on 2016/08/24.
 */
public class MyAdapter implements ListAdapter {
    private DoubleSpreadPageView.Handler handler;

    public MyAdapter(DoubleSpreadPageView.Handler handler) {
        super();
        this.handler = handler;
    }

    private int[] imageResources = {
            R.drawable.obama,
            R.drawable.road_rage,
            R.drawable.taipei_101,
            R.drawable.world,
            R.drawable.yudetaro_logo,
            R.drawable.ss1,
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
        return imageResources.length / 2 + 1;
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
        Context context = parent.getContext();
        DoubleSpreadPageView pageView;
        if (convertView instanceof DoubleSpreadPageView) {
            pageView = (DoubleSpreadPageView) convertView;
        } else {
            pageView = new DoubleSpreadPageView(context, null);
        }
        int leftPageNo = position * 2 - 1;
        int rightPageNo = leftPageNo + 1;
        Drawable leftImage = 0 < leftPageNo ? context.getDrawable(imageResources[leftPageNo]) : null;
        Drawable rightImage = rightPageNo < imageResources.length ? context.getDrawable(imageResources[rightPageNo]) : null;
        pageView.setup(leftImage, rightImage, handler);
        return pageView;
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
