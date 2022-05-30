package com.supporters.actmobile.ui.flaglist;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.supporters.actmobile.databinding.FlagListFragmentBinding;
import com.supporters.actmobile.models.Country;
import com.supporters.actmobile.ui.MainActivity;

import java.util.ArrayList;

import javax.inject.Inject;

public class FlagListFragment extends BottomSheetDialogFragment {
    private FlagRecyclerViewAdapter adapter;
    private FlagListViewModel mViewModel;
    private FlagListFragmentBinding binding;
    @Inject
    ViewModelProvider.Factory factory;
    ArrayList<FlagItem> flagItemList ;

    public static FlagListFragment newInstance() {
        return new FlagListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FlagListFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity) requireActivity()).flagComponent.injectFragment(this);
        initProperties();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialogInterface;
                setupFullHeight(bottomSheetDialog);
            }
        });

        return dialog;
    }

    private void initProperties(){
        flagItemList = new ArrayList<>();
        mViewModel = new ViewModelProvider(this,factory).get(FlagListViewModel.class);

        ArrayList<Country> countries = ((MainActivity) requireActivity()).viewModel.countries.getValue();
        for(int i=0; i< countries.size(); i++){
            if(countries.get(i).getCode().equals(((MainActivity)requireActivity()).viewModel.country.getValue().getCode()) ){
                ((MainActivity)requireActivity()).viewModel.storedIndex = ((MainActivity)requireActivity()).viewModel.selectedIndex = i;
                flagItemList.add(new FlagItem(countries.get(i),true));
            }
            else{
                flagItemList.add(new FlagItem(countries.get(i)));
            }
        }


        adapter = new FlagRecyclerViewAdapter(flagItemList, index -> {
            int storedIndex = ((MainActivity)requireActivity()).viewModel.storedIndex;
            if(storedIndex != index){
                changeFlagItemListData(storedIndex,index);
                changeUI(storedIndex,index);
            }
        });
        binding.rvCountries.setAdapter(adapter);
    }
    private void changeFlagItemListData(int oldIndex, int newIndex){
        flagItemList.set(oldIndex, new FlagItem(new Country(flagItemList.get(oldIndex).getName(), flagItemList.get(oldIndex).getCode())));
        flagItemList.set(newIndex, new FlagItem(new Country(flagItemList.get(newIndex).getName(), flagItemList.get(newIndex).getCode()),true));
        ((MainActivity)requireActivity()).viewModel.storedIndex = newIndex;
        ((MainActivity)requireActivity()).viewModel.country.setValue(new Country(flagItemList.get(newIndex)));
        mViewModel.saveSelectedCountry(flagItemList.get(newIndex));
    }

    private void changeUI(int oldIndex, int newIndex){
        adapter.notifyItemChanged(oldIndex);
        adapter.notifyItemChanged(newIndex);
        ((MainActivity)requireActivity()).viewModel.show_bottom_sheet.setValue(false);
    }

    private void setupFullHeight(BottomSheetDialog bottomSheetDialog) {
        FrameLayout bottomSheet = (FrameLayout) bottomSheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
        BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        ViewGroup.LayoutParams layoutParams = bottomSheet.getLayoutParams();

        int windowHeight = getWindowHeight();
        if (layoutParams != null) {
            layoutParams.height = windowHeight;
        }
        bottomSheet.setLayoutParams(layoutParams);
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    private int getWindowHeight() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        (requireActivity()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }
}