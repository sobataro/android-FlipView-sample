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
public class BookAdapter implements ListAdapter {
    private BookViewModel bookViewModel = BookViewModel.getInstance();

    private DoubleSpreadPageView.Handler handler;

    public BookAdapter() {
        super();
    }

    public BookAdapter(DoubleSpreadPageView.Handler handler) {
        this();
        this.handler = handler;
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
        bookViewModel.registerDataSetObserver(observer);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        bookViewModel.unregisterDataSetObserver(observer);
    }

    @Override
    public int getCount() {
        return bookViewModel.getCount();
    }

    @Override
    public Object getItem(int position) {
        return bookViewModel.getItem(position);
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
        DoubleSpreadPageModel page = bookViewModel.getItem(position);
        int leftId = page.getLeftImageId();
        int rightId = page.getRightImageId();
        Drawable leftImage = DoubleSpreadPageModel.NO_IMAGE != leftId ? context.getDrawable(leftId) : null;
        Drawable rightImage = DoubleSpreadPageModel.NO_IMAGE != rightId ? context.getDrawable(rightId) : null;
        pageView.setup(leftImage, rightImage, position, handler);
        return pageView;
    }

    public void notifyObservers() {
        bookViewModel.notifyObservers();
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
