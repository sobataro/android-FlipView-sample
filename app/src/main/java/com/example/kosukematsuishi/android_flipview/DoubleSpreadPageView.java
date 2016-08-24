package com.example.kosukematsuishi.android_flipview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by kosuke.matsuishi on 2016/08/24.
 */
public class DoubleSpreadPageView extends LinearLayout {
    public ImageView leftImageView;
    public ImageView rightImageView;

    public static interface Handler {
        public void onClickLeft();
        public void onClickRight();
    }

    public DoubleSpreadPageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.layout_double_spread_page, this);
        leftImageView = (ImageView) findViewById(R.id.left_image_view);
        rightImageView = (ImageView) findViewById(R.id.right_image_view);
    }

    public void setup(Drawable leftImage, Drawable rightImage, final Handler handler) {
        leftImageView.setImageDrawable(leftImage);
        rightImageView.setImageDrawable(rightImage);

        leftImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("penta", "left");
                if (handler != null) {
                    handler.onClickLeft();
                }
            }
        });
        rightImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("penta", "right");
                if (handler != null) {
                    handler.onClickRight();
                }
            }
        });
    }
}
