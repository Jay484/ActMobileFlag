package com.supporters.actmobile.di;
/*
    com.supporters.actmobile.di
    Created by:  Dhananjay Jhinkwan
    Date: 30-05-2022
*/

import android.content.Context;
import android.content.SharedPreferences;

import com.supporters.actmobile.network.ApiService;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(
        modules = {
                NetworkModule.class,
                AppModule.class,
                ViewModelModule.class
        }
    )
public interface AppComponent {

    @Component.Factory
    interface AppComponentFactory{
        AppComponent create(@BindsInstance Context context);
    }

    ApiService provideApiService();
    SharedPreferences getSharedPreferences();

}
