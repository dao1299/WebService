package com.example.retrofitassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.retrofitassignment.adapter.ListImageAdapter;
import com.example.retrofitassignment.network.MarsProperty;
import com.example.retrofitassignment.viewmodel.MarsViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListImageAdapter.onClickItemMars {

    private static final String TAG = "MainActivity";
    private static final String KEY_INTENT_MARS = "key_intent_mars";
    RecyclerView rcvForBuy,rcvForRent;
    ListImageAdapter listImageAdapter;
    MarsViewModel marsViewModel;
    MainActivity mainActivity = (MainActivity) this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rcvForBuy = findViewById(R.id.rcvMarsForBuy);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        rcvForBuy.setLayoutManager(gridLayoutManager);
        marsViewModel = new ViewModelProvider(this).get(MarsViewModel.class);
        marsViewModel.getListMutableLiveData().observe(this, new Observer<ArrayList<MarsProperty>>() {
            @Override
            public void onChanged(ArrayList<MarsProperty> marsProperties) {
                listImageAdapter = new ListImageAdapter(marsProperties,mainActivity);
                rcvForBuy.setAdapter(listImageAdapter);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mars,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuAll:
                marsViewModel.getData("");
                break;
            case R.id.mnuBuy:
                marsViewModel.getData("buy");
                break;
            case R.id.mnuRent:
                marsViewModel.getData("rent");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(MarsProperty marsProperty) {
        Log.i(TAG, "onClick: "+marsProperty);
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra(KEY_INTENT_MARS,marsProperty);
        startActivity(intent);
    }
}