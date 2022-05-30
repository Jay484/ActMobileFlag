package com.supporters.actmobile.di;
/*
    com.supporters.actmobile.di
    Created by:  Dhananjay Jhinkwan
    Date: 30-05-2022
*/

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

public class ViewModelFactory implements ViewModelProvider.Factory {
    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelMap;
    @Inject
    ViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelMap){
        this.viewModelMap = viewModelMap;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) viewModelMap.get(modelClass).get();
    }
}
