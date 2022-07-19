package com.example.retrofitassignment.network;

import static com.example.retrofitassignment.network.RetrofitAPIService.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitAPI {
    public RetrofitAPIService retrofitAPIService;
    private static RetrofitAPI instance;

    private RetrofitAPI() {
        Retrofit retrofitAPI = new Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        retrofitAPIService = retrofitAPI.create(RetrofitAPIService.class);
    }

    public static RetrofitAPI getInstance() {
        synchronized (RetrofitAPI.class) {
            if (instance == null) {
                instance = new RetrofitAPI();
            }
            return instance;
        }

    }
}
