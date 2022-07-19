package com.example.retrofitassignment.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofitassignment.network.MarsProperty;
import com.example.retrofitassignment.network.RetrofitAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MarsViewModel extends ViewModel {
    private static final String TAG = "MarsViewModel";
    private MutableLiveData<ArrayList<MarsProperty>> listMutableLiveData;
    private ArrayList<MarsProperty> marsPropertyList;

    public MarsViewModel(){
        listMutableLiveData = new MutableLiveData<>();
        marsPropertyList = new ArrayList<>();
        getData("");

    }

    public void getData(String filter) {

//        listMutableLiveData.setValue(marsPropertyList);
        marsPropertyList.removeAll(marsPropertyList);
        new Thread(new Runnable() {
            @Override
            public void run() {
                RetrofitAPI retrofitAPI = RetrofitAPI.getInstance();
                retrofitAPI.retrofitAPIService.getPropertiesFilter(filter).enqueue(new Callback<List<MarsProperty>>() {
                    @Override
                    public void onResponse(Call<List<MarsProperty>> call, Response<List<MarsProperty>> response) {
                        Log.i(TAG, "onResponse: "+response.body().size());
                        marsPropertyList.addAll(response.body());
                        listMutableLiveData.setValue((ArrayList<MarsProperty>) marsPropertyList);
                    }

                    @Override
                    public void onFailure(Call<List<MarsProperty>> call, Throwable t) {
                        Log.e(TAG, "onFailure: "+t.getLocalizedMessage());
                    }
                });
            }
        }).start();
    }

    public MutableLiveData<ArrayList<MarsProperty>> getListMutableLiveData() {
        return listMutableLiveData;
    }

    public void setListMutableLiveData(MutableLiveData<ArrayList<MarsProperty>> listMutableLiveData) {
        this.listMutableLiveData = listMutableLiveData;
    }
}
