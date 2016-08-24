package com.example.kosukematsuishi.android_flipview;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import se.emilsjolander.flipview.FlipView;

/**
 * Created by kosuke.matsuishi on 2016/08/24.
 */
public class BookFragment extends Fragment {
    FlipView flipView;
    BookAdapter adapter;

    public BookFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_book, container, false);
        adapter = new BookAdapter(new DoubleSpreadPageView.Handler() {
            @Override
            public void onClickLeft(int position) {
                DetailFragment fragment = new DetailFragment();
                fragment.setPagePosition(position, true);
                getFragmentManager().beginTransaction()
                        .add(R.id.main_layout, fragment)
                        .addToBackStack(null)
                        .commit();
            }

            @Override
            public void onClickRight(int position) {
                DetailFragment fragment = new DetailFragment();
                fragment.setPagePosition(position, false);
                getFragmentManager().beginTransaction()
                        .add(R.id.main_layout, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        flipView = (FlipView) layout.findViewById(R.id.flip_view);
        flipView.setAdapter(adapter);
        flipView.requestLayout();
        return layout;
    }
}
