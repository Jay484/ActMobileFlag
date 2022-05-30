package com.supporters.actmobile.network;
/*
    com.supporters.actmobile.network
    Created by:  Dhananjay Jhinkwan
    Date: 30-05-2022
*/

import com.supporters.actmobile.models.CountryResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/countries")
    Call<CountryResponse> getCountries();
}
