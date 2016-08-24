package com.example.kosukematsuishi.android_flipview;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import se.emilsjolander.flipview.FlipView;

public class MainActivity extends AppCompatActivity {
    FlipView flipView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipView = (FlipView) findViewById(R.id.flip_view);
        flipView.setAdapter(new MyAdapter(new DoubleSpreadPageView.Handler() {
            @Override
            public void onClickLeft() {
                Log.d("penta", "handler left");
                getFragmentManager().beginTransaction()
                        .add(R.id.main_layout, new DetailFragment())
                        .addToBackStack(null)
                        .commit();
            }

            @Override
            public void onClickRight() {
                Log.d("penta", "handler right");
                getFragmentManager().beginTransaction()
                        .add(R.id.main_layout, new DetailFragment())
                        .addToBackStack(null)
                        .commit();
            }
        }));
        flipView.requestLayout();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        FragmentManager manager = getFragmentManager();
        if (manager.getBackStackEntryCount() > 0) {
            manager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    public static class DetailFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("penta", "DetailFragment.onCreateView() container=" + container.toString());
            return inflater.inflate(R.layout.fragment_detail, container, false);
        }
    }
}
