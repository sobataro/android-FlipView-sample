package com.example.kosukematsuishi.android_flipview;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by kosuke.matsuishi on 2016/08/24.
 */
public class DetailFragment extends Fragment {
    private boolean swapped;
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
                swapped = !swapped;
                Toast.makeText(getContext(), "画像タップで左右ページ入れ替え: " + (swapped ? "逆!" : "元通り"), Toast.LENGTH_SHORT).show();
                page.setImages(page.getRightImageId(), page.getLeftImageId()); // 左右いれかえ
                BookViewModel.getInstance().notifyObservers();
            }
        });
        return layout;
    }
}
