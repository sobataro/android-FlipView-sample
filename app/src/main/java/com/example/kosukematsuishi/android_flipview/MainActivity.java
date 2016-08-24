package com.example.kosukematsuishi.android_flipview;

import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import se.emilsjolander.flipview.FlipView;

public class MainActivity extends AppCompatActivity {
    FlipView flipView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MyAdapter(new DoubleSpreadPageView.Handler() {
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

        flipView = (FlipView) findViewById(R.id.flip_view);
        flipView.setAdapter(adapter);
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
        private DoubleSpreadPageModel page;
        private boolean isLeft;

        public void setPagePosition(int position, boolean isLeft) {
            page = BookViewModel.getInstance().getItem(position);
            this.isLeft = isLeft;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.fragment_detail, container, false);
            ImageView imageView = (ImageView) layout.findViewById(R.id.detail_image_view);
            int id;
            if (isLeft) {
                id = page.getLeftImageId();
            } else {
                id = page.getRightImageId();
            }
            Drawable drawable = id != DoubleSpreadPageModel.NO_IMAGE ? getContext().getDrawable(id) : null;
            imageView.setImageDrawable(drawable);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    page.setImages(page.getRightImageId(), page.getLeftImageId()); // 左右いれかえ
                    BookViewModel.getInstance().notifyObservers();
                    getFragmentManager().popBackStack();
                }
            });
            return layout;
        }
    }
}
