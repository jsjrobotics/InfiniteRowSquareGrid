package com.jsjrobotics.testbinder;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

public class HorizontalSquareViewAdapter extends RecyclerView.Adapter<SquareViewViewHolder> {
    private final List<Integer> mData;
    private final int mContentSizePx;
    private final Integer mInternalPaddingPx;
    private final boolean mIsVertical;

    public HorizontalSquareViewAdapter(SpacingSpecData data, int contentSizePx, Integer internalPaddingPx, boolean isVertical) {
        mData = data.data;
        mContentSizePx = contentSizePx;
        mInternalPaddingPx = internalPaddingPx;
        mIsVertical = isVertical;
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
            int paddingLeft = 0;

            if (!mIsVertical) {
                if (position + 1 == getItemCount()) {
                    paddingRight = mInternalPaddingPx * 2;
                }
            }
            if (position > 0){
                paddingLeft = mInternalPaddingPx;
            }
            holder.setPadding(paddingLeft, paddingRight);
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
