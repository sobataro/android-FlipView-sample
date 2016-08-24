package com.example.kosukematsuishi.android_flipview;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import java.util.LinkedList;

/**
 * Created by kosuke.matsuishi on 2016/08/24.
 */
public class MyAdapter implements ListAdapter {
    private DoubleSpreadPageView.Handler handler;

    private LinkedList<DoubleSpreadPageModel> pages;

    public MyAdapter(DoubleSpreadPageView.Handler handler) {
        super();
        this.handler = handler;

        int[] imageResources = {
                R.drawable.obama,
                R.drawable.road_rage,
                R.drawable.taipei_101,
                R.drawable.world,
                R.drawable.yudetaro_logo,
                R.drawable.ss1,
        };

        pages = new LinkedList<DoubleSpreadPageModel>();
        pages.add(new DoubleSpreadPageModel(0, R.drawable.obama));
        pages.add(new DoubleSpreadPageModel(R.drawable.road_rage, R.drawable.taipei_101));
        pages.add(new DoubleSpreadPageModel(R.drawable.world, R.drawable.yudetaro_logo));
        pages.add(new DoubleSpreadPageModel(R.drawable.ss1, 0));
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

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

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
        Drawable leftImage = 0 != leftId ? context.getDrawable(leftId) : null;
        Drawable rightImage = 0 != rightId ? context.getDrawable(rightId) : null;
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
