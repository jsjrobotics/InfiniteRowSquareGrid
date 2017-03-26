package com.jsjrobotics.testbinder.spacingSpecRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;
import java.util.Map;

public class SpacingSpecAdapter extends RecyclerView.Adapter<SpacingSpecViewHolder<?>> {

    private final List<SpacingSpecData<?>> mData;
    private final SpacingSpec mSpacingSpec;

    public SpacingSpecAdapter(SpacingSpec spec, List<SpacingSpecData<?>> data) {
        mData = data;
        mSpacingSpec = spec;
    }

    @Override
    public SpacingSpecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mData.get(viewType).viewHolderCreator.accept(parent, mSpacingSpec);
    }

    @Override
    public void onBindViewHolder(SpacingSpecViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
