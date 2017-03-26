package com.jsjrobotics.testbinder.viewHolders;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.WeakReferenceSupplier;
import com.jsjrobotics.testbinder.spacingSpecRecycler.BiFunction;
import com.jsjrobotics.testbinder.spacingSpecRecycler.HorizontalImageSquareViewAdapter;
import com.jsjrobotics.testbinder.spacingSpecRecycler.HorizontalSquareViewAdapter;
import com.jsjrobotics.testbinder.spacingSpecRecycler.SpacingSpec;
import com.jsjrobotics.testbinder.spacingSpecRecycler.SpacingSpecData;
import com.jsjrobotics.testbinder.spacingSpecRecycler.SpacingSpecViewHolder;

public class SquareImageSpacingSpecViewHolder extends SpacingSpecViewHolder<String> {
    private final ViewGroup mRoot;
    private final SpacingSpec mSpacingSpec;
    private WeakReferenceSupplier<Fragment> mContext;

    public SquareImageSpacingSpecViewHolder(WeakReferenceSupplier<Fragment> context, ViewGroup data, SpacingSpec spacingSpec) {
        super(data, spacingSpec);
        mRoot = (ViewGroup) itemView;
        mSpacingSpec = spacingSpec;
        mContext = context;
    }

    @Override
    public void bindVerticalList(BiFunction<SpacingSpecViewHolder<String>, ViewGroup, SpacingSpec> viewHolderCreator, SpacingSpecData<String> data) {

    }

    @Override
    public void bindHorizontalList(SpacingSpecData<String> data) {
        // Build a Horizontal Scroll View with height w
        // Add padding equal to the margin to left size
        Context context = mRoot.getContext();
        int contentSizePx = mSpacingSpec.getContentSizePx(context);
        LinearLayout.LayoutParams rootParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, contentSizePx);
        rootParams.setMargins(0, mSpacingSpec.getPaddingPx(context), 0, mSpacingSpec.getPaddingPx(context));
        mRoot.setLayoutParams(rootParams);
        RecyclerView horizontalList = new RecyclerView(context);
        horizontalList.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, contentSizePx));
        horizontalList.setClipToPadding(false);
        horizontalList.setPadding(mSpacingSpec.getMarginPx(context), 0, mSpacingSpec.getMarginPx(context), 0);
        horizontalList.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        horizontalList.setAdapter(new HorizontalImageSquareViewAdapter(mContext, data, contentSizePx, mSpacingSpec.getPaddingPx(context)));
        mRoot.addView(horizontalList);
    }
}
