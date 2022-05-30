package com.supporters.actmobile.ui.di;
/*
    com.supporters.actmobile.ui.di
    Created by:  Dhananjay Jhinkwan
    Date: 30-05-2022
*/

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.supporters.actmobile.di.ViewModelFactory;
import com.supporters.actmobile.di.ViewModelKey;
import com.supporters.actmobile.ui.flaglist.FlagListViewModel;
import com.supporters.actmobile.ui.MainActivityViewModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Scope
@Retention(RetentionPolicy.RUNTIME)
@interface FlagScope {
}

@Module
abstract class FlagModule {

    @Binds
    abstract ViewModelProvider.Factory bindFactory(ViewModelFactory viewModelFactory);

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel.class)
    abstract ViewModel bindMainActivityViewModel(MainActivityViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(FlagListViewModel.class)
    abstract ViewModel bindFlagListViewModel(FlagListViewModel flagListViewModel);
}
