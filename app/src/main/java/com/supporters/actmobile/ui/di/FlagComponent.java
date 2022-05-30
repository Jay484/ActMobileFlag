package com.supporters.actmobile.ui.di;
/*
    com.supporters.actmobile.ui.di
    Created by:  Dhananjay Jhinkwan
    Date: 30-05-2022
*/

import com.supporters.actmobile.di.AppComponent;
import com.supporters.actmobile.ui.flaglist.FlagListFragment;
import com.supporters.actmobile.ui.MainActivity;

import dagger.Component;

@FlagScope
@Component(
        dependencies = {AppComponent.class},
        modules = {FlagModule.class}
    )
public interface FlagComponent {
    void injectActivity(MainActivity mainActivity);
    void injectFragment(FlagListFragment flagListFragment);

}
