package com.jsjrobotics.testbinder.squareIntegerView;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jsjrobotics.testbinder.spacingSpecRecycler.SpacingSpecData;

import java.util.List;

class HorizontalSquareViewAdapter extends RecyclerView.Adapter<SquareViewViewHolder> {
    private final List<Integer> mData;
    private final int mContentSizePx;
    private final Integer mInternalPaddingPx;

    HorizontalSquareViewAdapter(SpacingSpecData data, int contentSizePx, Integer internalPaddingPx) {
        mData = data.content;
        mContentSizePx = contentSizePx;
        mInternalPaddingPx = internalPaddingPx;
    }

    @Override
    public SquareViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SquareViewViewHolder(parent, mContentSizePx);
    }

    @Override
    public void onBindViewHolder(SquareViewViewHolder holder, int position) {
        holder.bind(mData.get(position));
        if (mInternalPaddingPx != null) {
            int paddingRight = mInternalPaddingPx;
            int paddingLeft = mInternalPaddingPx;

            holder.setPadding(paddingLeft, paddingRight);
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
