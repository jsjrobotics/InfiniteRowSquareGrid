package com.jsjrobotics.testbinder.spacingSpecRecycler;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jsjrobotics.testbinder.R;

import java.util.ArrayList;
import java.util.List;

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
}
