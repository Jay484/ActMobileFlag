package com.supporters.actmobile.ui;
/*
    com.supporters.actmobile.ui
    Created by:  Dhananjay Jhinkwan
    Date: 30-05-2022
*/

import android.content.SharedPreferences;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.supporters.actmobile.models.Country;
import com.supporters.actmobile.models.CountryResponse;
import com.supporters.actmobile.network.ApiService;
import java.util.ArrayList;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {
    private final ApiService apiService;
    private final SharedPreferences sharedPreferences;
    @Inject
    public MainActivityViewModel(ApiService apiService, SharedPreferences sharedPreferences){
        this.apiService = apiService;
        apiService.getCountries();
        this.sharedPreferences = sharedPreferences;
        renderStoredData();
    }

    public MutableLiveData<Country> country = new MutableLiveData<>(new Country("India","IN"));
    public MutableLiveData<ArrayList<Country>> countries = new MutableLiveData<>(new ArrayList<>());
    public MutableLiveData<Boolean> show_bottom_sheet = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> showError = new MutableLiveData<>(false);
    public int storedIndex;
    public int selectedIndex;
    public MutableLiveData<Boolean> networkCallRunning = new MutableLiveData<>(false);

    public void onClickFlag(){
        if(countries.getValue().size() == 0 && !networkCallRunning.getValue()) {
            networkCallRunning.setValue(true);
            apiService.getCountries().enqueue(new Callback<CountryResponse>() {
                @Override
                public void onResponse(Call<CountryResponse> call, Response<CountryResponse> response) {
                    networkCallRunning.setValue(false);
                    if (response.body() != null) {
                        countries.postValue(response.body().getResult());
                        show_bottom_sheet.setValue(true);
                    }
                }

                @Override
                public void onFailure(Call<CountryResponse> call, Throwable t) {
                    networkCallRunning.setValue(false);
                    showError.setValue(true);
                }
            });
        }
        else{
            show_bottom_sheet.setValue(true);
        }
    }

    private void renderStoredData(){
        country.setValue(new Country(sharedPreferences.getString("name","India"), sharedPreferences.getString("code","IN")));
    }
}
