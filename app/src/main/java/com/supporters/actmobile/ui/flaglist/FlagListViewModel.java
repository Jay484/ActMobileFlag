package com.supporters.actmobile.ui.flaglist;

import android.content.SharedPreferences;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class FlagListViewModel extends ViewModel {
    private final SharedPreferences sharedPreferences;
    @Inject
    public FlagListViewModel(SharedPreferences sharedPreferences){
        this.sharedPreferences = sharedPreferences;
    }

    void saveSelectedCountry(FlagItem flagItem){
        sharedPreferences.edit().putString("name", flagItem.getName()).apply();
        sharedPreferences.edit().putString("code", flagItem.getCode()).apply();
    }

}