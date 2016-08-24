package com.example.kosukematsuishi.android_flipview;

/**
 * Created by kosuke.matsuishi on 2016/08/24.
 */
public class DoubleSpreadPageModel {
    private int leftImageId;
    private int rightImageId;

    public DoubleSpreadPageModel(int leftImageId, int rightImageId) {
        setImages(leftImageId, rightImageId);
    }

    public void setImages(int leftImageId, int rightImageId) {
        this.leftImageId = leftImageId;
        this.rightImageId = rightImageId;
    }

    public int getLeftImageId() {
        return leftImageId;
    }

    public int getRightImageId() {
        return rightImageId;
    }
}
