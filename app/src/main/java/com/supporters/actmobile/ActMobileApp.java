package com.supporters.actmobile;
/*
    com.supporters.actmobile
    Created by:  Dhananjay Jhinkwan
    Date: 30-05-2022
*/

import android.app.Application;
import com.supporters.actmobile.di.AppComponent;
import com.supporters.actmobile.di.DaggerAppComponent;

public class ActMobileApp extends Application {

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .factory()
                    .create(getApplicationContext());
    }
}
