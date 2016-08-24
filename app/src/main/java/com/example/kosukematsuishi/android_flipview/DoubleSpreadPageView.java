package com.example.kosukematsuishi.android_flipview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by kosuke.matsuishi on 2016/08/24.
 */
public class DoubleSpreadPageView extends LinearLayout {
    public ImageView leftImageView;
    public ImageView rightImageView;

    public DoubleSpreadPageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.layout_double_spread_page, this);
        leftImageView = (ImageView) findViewById(R.id.left_image_view);
        rightImageView = (ImageView) findViewById(R.id.right_image_view);
    }
}
