package com.example.retrofitassignment.network;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitAPIService {
    String BASE_URL = "https://mars.udacity.com/";

    @GET("realestate")
    Call<List<MarsProperty>> getPropertiesFilter(@Query("filter") String type);
}
