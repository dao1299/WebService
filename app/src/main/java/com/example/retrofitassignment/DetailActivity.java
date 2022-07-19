package com.example.retrofitassignment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.retrofitassignment.databinding.ActivityDetailBinding;
import com.example.retrofitassignment.network.MarsProperty;
import com.example.retrofitassignment.viewmodel.DetailViewModel;

public class DetailActivity extends AppCompatActivity {
    private static final String KEY_INTENT_MARS = "key_intent_mars";
    DetailViewModel detailViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding activityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        activityDetailBinding.setModel((MarsProperty) getIntent().getSerializableExtra(KEY_INTENT_MARS));
        detailViewModel = new ViewModelProvider(this).get(DetailViewModel.class);
        activityDetailBinding.setLifecycleOwner(this);
        activityDetailBinding.setViewModel(detailViewModel);
    }
}