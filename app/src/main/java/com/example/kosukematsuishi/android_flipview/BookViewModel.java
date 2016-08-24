package com.example.kosukematsuishi.android_flipview;

import android.database.DataSetObserver;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by kosuke.matsuishi on 2016/08/24.
 */
public class BookViewModel {
    private static BookViewModel sharedInstance = new BookViewModel();

    public static BookViewModel getInstance() {
        return sharedInstance;
    }

    private List<DoubleSpreadPageModel> pages;
    private List<DataSetObserver> observers;

    public BookViewModel() {
        pages = new LinkedList<>();
        pages.add(new DoubleSpreadPageModel(DoubleSpreadPageModel.NO_IMAGE, R.drawable.obama));
        pages.add(new DoubleSpreadPageModel(R.drawable.road_rage, R.drawable.taipei_101));
        pages.add(new DoubleSpreadPageModel(R.drawable.world, R.drawable.yudetaro_logo));
        pages.add(new DoubleSpreadPageModel(R.drawable.ss1, DoubleSpreadPageModel.NO_IMAGE));

        observers = new LinkedList<>();
    }

    public int getCount() {
        return pages.size();
    }

    public DoubleSpreadPageModel getItem(int position) {
        return pages.get(position);
    }

    public void registerDataSetObserver(DataSetObserver observer) {
        observers.add(observer);
    }

    public void unregisterDataSetObserver(DataSetObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (DataSetObserver observer : observers) {
            observer.onChanged();
        }
    }
}
