package com.example.retrofitassignment.extension;

import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.IdRes;
import androidx.databinding.BindingAdapter;

import com.example.retrofitassignment.R;
import com.squareup.picasso.Picasso;

public class BindingExtension{
    private static final String TAG = "BindingExtension";

    @BindingAdapter("load_image")
    public static void loadImage(ImageView view, String imageUrl) {
        Log.i(TAG, "loadImage: "+imageUrl);
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)
                .into(view);
    }
}
