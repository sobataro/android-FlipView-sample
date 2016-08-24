package com.example.kosukematsuishi.android_flipview;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by kosuke.matsuishi on 2016/08/24.
 */
public class MyAdapter implements ListAdapter {
    private DoubleSpreadPageView.Handler handler;

    private List<DoubleSpreadPageModel> pages;

    private List<DataSetObserver> observers;

    private MyAdapter() {
        super();
    }

    public static MyAdapter sharedInstance = new MyAdapter();

    public void setHandler(DoubleSpreadPageView.Handler handler) {
        this.handler = handler;

        int[] imageResources = {
                R.drawable.obama,
                R.drawable.road_rage,
                R.drawable.taipei_101,
                R.drawable.world,
                R.drawable.yudetaro_logo,
                R.drawable.ss1,
        };

        pages = new LinkedList<>();
        pages.add(new DoubleSpreadPageModel(0, R.drawable.obama));
        pages.add(new DoubleSpreadPageModel(R.drawable.road_rage, R.drawable.taipei_101));
        pages.add(new DoubleSpreadPageModel(R.drawable.world, R.drawable.yudetaro_logo));
        pages.add(new DoubleSpreadPageModel(R.drawable.ss1, 0));

        observers = new LinkedList<>();
    }

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
        Log.d("penta", "registerDataSetObserver()");
        observers.add(observer);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        observers.remove(observer);
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    @Override
    public Object getItem(int position) {
        return pages.get(position);
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
        DoubleSpreadPageModel page = pages.get(position);
        int leftId = page.getLeftImageId();
        int rightId = page.getRightImageId();
        Drawable leftImage = DoubleSpreadPageModel.NO_IMAGE != leftId ? context.getDrawable(leftId) : null;
        Drawable rightImage = DoubleSpreadPageModel.NO_IMAGE != rightId ? context.getDrawable(rightId) : null;
        pageView.setup(leftImage, rightImage, position, handler);
        return pageView;
    }

    public void notifyObservers() {
        for (DataSetObserver observer : observers) {
            observer.onChanged();
        }
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
