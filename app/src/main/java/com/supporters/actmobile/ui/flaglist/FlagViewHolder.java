package com.supporters.actmobile.ui.flaglist;
/*
    com.supporters.actmobile.ui.FlagList
    Created by:  Dhananjay Jhinkwan
    Date: 30-05-2022
*/

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.supporters.actmobile.databinding.FlagItemBinding;

public class FlagViewHolder extends RecyclerView.ViewHolder{
    private final FlagItemBinding binding;
    private final FlagItemListener flagItemListener;

    public FlagViewHolder(FlagItemBinding binding, FlagItemListener flagItemListener) {
        super(binding.getRoot());
        this.binding = binding;
        this.flagItemListener = flagItemListener;
    }

    void bind(FlagItem flagItem){
        binding.setFlagItem(flagItem);
        binding.getRoot().setOnClickListener(view -> flagItemListener.onClickFlagItem(getAdapterPosition()));
        binding.rbFlag.setOnClickListener(view -> flagItemListener.onClickFlagItem(getAdapterPosition()));
        binding.executePendingBindings();
    }

    public static FlagViewHolder from(ViewGroup parent, FlagItemListener flagItemListener){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        FlagItemBinding binding = FlagItemBinding.inflate(layoutInflater,parent,false);
        return new FlagViewHolder(binding,flagItemListener);
    }

}
