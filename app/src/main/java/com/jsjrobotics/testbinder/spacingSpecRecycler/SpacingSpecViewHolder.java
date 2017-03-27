package com.jsjrobotics.testbinder.spacingSpecRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jsjrobotics.testbinder.R;

public abstract class SpacingSpecViewHolder<T> extends RecyclerView.ViewHolder {
    private final ViewGroup mRoot;
    private final SpacingSpec mSpacingSpec;

    public SpacingSpecViewHolder(ViewGroup parent, SpacingSpec spacingSpec) {
        super(createView(parent));
        mRoot = (ViewGroup) itemView;
        mSpacingSpec = spacingSpec;

    }

    private static View createView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.linear_layout, parent, false);
    }

    final void bind(SpacingSpecData<T> data) {
        if (data.isVertical) {
            bindVerticalList(data.viewHolderCreator, data);
        } else {
            bindHorizontalList(data);
        }
    }

    public abstract void bindVerticalList(BiFunction<SpacingSpecViewHolder<T>, ViewGroup, SpacingSpec> viewHolderCreator, SpacingSpecData<T> data);

    public abstract void bindHorizontalList(SpacingSpecData<T> data);

    public abstract void onViewRecycled();
}
