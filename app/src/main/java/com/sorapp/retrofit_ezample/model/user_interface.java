package com.sorapp.retrofit_ezample.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface user_interface
{
    @GET("user_example.json")
    Call<user_model> GetUser();
}
