package com.example.kosukematsuishi.android_flipview;

import android.util.Log;

/**
 * Created by kosuke.matsuishi on 2016/08/24.
 */
public class DoubleSpreadPageModel {
    public static int NO_IMAGE = 0;

    private int leftImageId;
    private int rightImageId;

    public DoubleSpreadPageModel(int leftImageId, int rightImageId) {
        setImages(leftImageId, rightImageId);
    }

    public void setImages(int leftImageId, int rightImageId) {
        Log.d("penta", "" + leftImageId + " " + rightImageId);
        this.leftImageId = leftImageId;
        this.rightImageId = rightImageId;
        Log.d("penta", "" + leftImageId + " " + rightImageId);
    }

    public int getLeftImageId() {
        return leftImageId;
    }

    public int getRightImageId() {
        return rightImageId;
    }
}
