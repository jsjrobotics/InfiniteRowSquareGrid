package com.jsjrobotics.testbinder.spacingSpecRecycler;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.WeakReferenceSupplier;

import java.util.List;

public class HorizontalImageSquareViewAdapter extends RecyclerView.Adapter<SquareImageViewViewHolder> {
    private final List<String> mData;
    private final int mContentSizePx;
    private final Integer mInternalPaddingPx;
    private WeakReferenceSupplier<Fragment> mContext;

    public HorizontalImageSquareViewAdapter(WeakReferenceSupplier<Fragment> context, SpacingSpecData<String> data, int contentSizePx, Integer internalPaddingPx) {
        mData = data.content;
        mContentSizePx = contentSizePx;
        mInternalPaddingPx = internalPaddingPx;
        mContext = context;
    }

    @Override
    public SquareImageViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SquareImageViewViewHolder(mContext, parent, mContentSizePx);
    }

    @Override
    public void onBindViewHolder(SquareImageViewViewHolder holder, int position) {
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
