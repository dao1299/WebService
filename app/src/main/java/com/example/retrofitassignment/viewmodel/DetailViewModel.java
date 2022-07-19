package com.example.retrofitassignment.viewmodel;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.ViewModel;

import com.example.retrofitassignment.R;
import com.example.retrofitassignment.network.MarsProperty;
import com.squareup.picasso.Picasso;

public class DetailViewModel extends ViewModel {
    private static final String KEY_INTENT_MARS = "key_intent_mars";
    private static final String TAG = "DetailViewModel";

    public DetailViewModel() {
//        initData(null);
    }
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Uri uri = Uri.parse(imageUrl).buildUpon().scheme("https").build();
        Picasso.with(view.getContext())
                .load(uri)
                .placeholder(R.drawable.loading_img)
                .error(R.drawable.ic_broken_image)
                .into(view);
    }

}
