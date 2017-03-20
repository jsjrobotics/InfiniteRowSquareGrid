package com.jsjrobotics.testbinder.spacingSpecRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

public class SpacingSpecAdapter extends RecyclerView.Adapter<SpacingSpecViewHolder> {

    private final List<SpacingSpecData> mData;
    private final SpacingSpec mSpacingSpec;

    public SpacingSpecAdapter(SpacingSpec spec, List<SpacingSpecData> data) {
        mData = data;
        mSpacingSpec = spec;
    }

    @Override
    public SpacingSpecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == SpacingSpecViewType.VERTICAL.id) {
            return new SpacingSpecViewHolder(parent, mSpacingSpec, SpacingSpecViewType.VERTICAL);
        }
        return new SpacingSpecViewHolder(parent, mSpacingSpec, SpacingSpecViewType.HORIZONTAL);
    }

    @Override
    public void onBindViewHolder(SpacingSpecViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.get(position).isVertical) {
            return SpacingSpecViewType.VERTICAL.id;
        }
        return SpacingSpecViewType.HORIZONTAL.id;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
