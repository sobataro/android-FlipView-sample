package com.example.kosukematsuishi.android_flipview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import se.emilsjolander.flipview.FlipView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FlipView flipView = (FlipView) findViewById(R.id.flip_view);
        flipView.setAdapter(new MyAdapter());
    }
}
