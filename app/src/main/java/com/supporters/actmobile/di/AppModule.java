package com.supporters.actmobile.di;
/*
    com.supporters.actmobile.di
    Created by:  Dhananjay Jhinkwan
    Date: 30-05-2022
*/

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class AppModule {

    @Singleton
    @Provides
    SharedPreferences getSharedPreference(Context context){
        return context.getSharedPreferences("ActMobileSharedPreferences",Context.MODE_PRIVATE);
    }
}
