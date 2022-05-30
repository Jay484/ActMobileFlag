package com.supporters.actmobile.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.supporters.actmobile.ActMobileApp;
import com.supporters.actmobile.R;
import com.supporters.actmobile.databinding.ActivityMainBinding;
import com.supporters.actmobile.models.Country;
import com.supporters.actmobile.ui.flaglist.FlagListFragment;
import com.supporters.actmobile.ui.di.DaggerFlagComponent;
import com.supporters.actmobile.ui.di.FlagComponent;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    public MainActivityViewModel viewModel;
    View root;
    public FlagComponent flagComponent = DaggerFlagComponent
            .builder()
            .appComponent(ActMobileApp.appComponent)
            .build();
    FlagListFragment flagListFragment;
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        root = binding.getRoot();
        flagComponent.injectActivity(this);
        setContentView(root);
        initViewModel();
        initProperties();
    }

    private void initViewModel(){
        viewModel = new ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel.class);
        initObservers();
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
    }

    private void initObservers(){
        viewModel.show_bottom_sheet.observe(this, aBoolean -> {
            if(aBoolean){
                viewModel.show_bottom_sheet.setValue(false);
                if(!flagListFragment.isAdded()) {
                    flagListFragment.show(getSupportFragmentManager(), null);
                }
            }
            else{
                if(flagListFragment.isAdded())
                    flagListFragment.dismiss();
            }
        });

        viewModel.showError.observe(this, aBoolean -> {
            if(aBoolean){
                viewModel.showError.setValue(false);
                Toast toast = Toast.makeText(MainActivity.this, R.string.erro_message,Toast.LENGTH_LONG);
                toast.show();
            }
        });

        viewModel.country.observe(this, new Observer<Country>() {
            @Override
            public void onChanged(Country country) {
                if(country != null)
                    Log.e("testJay",country.getName());
            }
        });

    }

    private void initProperties(){
        flagListFragment  = FlagListFragment.newInstance();
    }

}