package com.supporters.actmobile.ui.flaglist;
/*
    com.supporters.actmobile.ui.FlagList
    Created by:  Dhananjay Jhinkwan
    Date: 30-05-2022
*/

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FlagRecyclerViewAdapter extends RecyclerView.Adapter<FlagViewHolder> {

    private final List<FlagItem> flagItems;
    FlagItemListener flagItemListener;

    public FlagRecyclerViewAdapter(List<FlagItem> flagItems, FlagItemListener flagItemListener){
        this.flagItems = flagItems;
        this.flagItemListener = flagItemListener;
    }

    @NonNull
    @Override
    public FlagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return FlagViewHolder.from(parent,flagItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull FlagViewHolder holder, int position) {
        FlagItem flagItem = flagItems.get(position);
        holder.bind(flagItem);
    }

    @Override
    public int getItemCount() {
        return flagItems.size();
    }
}
