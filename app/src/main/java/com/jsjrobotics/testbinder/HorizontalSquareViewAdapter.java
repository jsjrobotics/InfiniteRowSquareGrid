package com.jsjrobotics.testbinder;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

public class HorizontalSquareViewAdapter extends RecyclerView.Adapter<SquareViewViewHolder> {
    private final List<Integer> mData;
    private final int mContentSizePx;

    public HorizontalSquareViewAdapter(SpacingSpecData data, int contentSizePx) {
        mData = data.data;
        mContentSizePx = contentSizePx;
    }

    @Override
    public SquareViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SquareViewViewHolder(parent, mContentSizePx);
    }

    @Override
    public void onBindViewHolder(SquareViewViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
