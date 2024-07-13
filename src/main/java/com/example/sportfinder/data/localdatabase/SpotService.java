package com.example.sportfinder.data.localdatabase;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface SpotService {

    @GET("spots")
    Call<List<SpotItem>> getSpots();

    @DELETE("spots")
    Call<List<SpotItem>> deleteSpots();

    @POST("spots")
    Call<List<SpotItem>> addSpots();
    @PUT("spots")
    Call<List<SpotItem>> updateSpots();

}