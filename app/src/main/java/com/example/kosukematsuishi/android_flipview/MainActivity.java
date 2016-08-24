package com.example.kosukematsuishi.android_flipview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import se.emilsjolander.flipview.FlipView;

public class MainActivity extends AppCompatActivity {
    FlipView flipView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipView = (FlipView) findViewById(R.id.flip_view);
        flipView.setAdapter(new MyAdapter());
        flipView.requestLayout();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
