package com.jsjrobotics.testbinder.viewHolders;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jsjrobotics.testbinder.spacingSpecRecycler.BiFunction;
import com.jsjrobotics.testbinder.spacingSpecRecycler.HorizontalSquareViewAdapter;
import com.jsjrobotics.testbinder.spacingSpecRecycler.SpacingSpec;
import com.jsjrobotics.testbinder.spacingSpecRecycler.SpacingSpecData;
import com.jsjrobotics.testbinder.spacingSpecRecycler.SpacingSpecViewHolder;

import java.util.ArrayList;
import java.util.List;

public class IntegerSpacingSpecViewHolder extends SpacingSpecViewHolder<Integer> {
    private ViewGroup mRoot;
    private final SpacingSpec mSpacingSpec;

    public IntegerSpacingSpecViewHolder(ViewGroup parent, SpacingSpec spacingSpec) {
        super(parent, spacingSpec);
        mRoot = (ViewGroup) itemView;
        mSpacingSpec = spacingSpec;

    }

    @Override
    public void bindVerticalList(BiFunction<SpacingSpecViewHolder<Integer>, ViewGroup, SpacingSpec> viewHolderCreator, SpacingSpecData<Integer> data) {
        // Set parent size
        Context context = mRoot.getContext();
        int contentSizePx = mSpacingSpec.getContentSizePx(context);
        mRoot.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        // Divide list into span sizes
        List<List<Integer>> chunks = new ArrayList<>();
        List<Integer> toAdd = new ArrayList<>();

        for (int index = 0; index < data.content.size(); index++) {
            if (index > 0 && index % mSpacingSpec.span == 0) {
                chunks.add(toAdd);
                toAdd = new ArrayList<>();
            }
            toAdd.add(data.content.get(index));
        }
        if (!toAdd.isEmpty()) {
            chunks.add(toAdd);
        }

        // Build linear layouts of content height size and parent width
        for (List<Integer> content : chunks) {
            RecyclerView horizontalList = new RecyclerView(context);
            LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, contentSizePx);
            params.setMargins(0, mSpacingSpec.getPaddingPx(context), 0, mSpacingSpec.getPaddingPx(context));

            horizontalList.setLayoutParams(params);
            horizontalList.setPadding(mSpacingSpec.getMarginPx(context), 0, mSpacingSpec.getMarginPx(context), 0);
            horizontalList.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            horizontalList.setAdapter(new HorizontalSquareViewAdapter(new SpacingSpecData<>(false, content, viewHolderCreator), contentSizePx, mSpacingSpec.getPaddingPx(context)));
            mRoot.addView(horizontalList);
        }

    }

    @Override
    public void bindHorizontalList(SpacingSpecData<Integer> data) {
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
        horizontalList.setAdapter(new HorizontalSquareViewAdapter(data, contentSizePx, mSpacingSpec.getPaddingPx(context)));
        mRoot.addView(horizontalList);
    }

    @Override
    public void onViewRecycled() {
        mRoot.removeAllViews();
    }
}
