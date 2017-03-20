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

public class SpacingSpecViewHolder extends RecyclerView.ViewHolder {
    private final ViewGroup mRoot;
    private final SpacingSpecViewType mType;
    private final SpacingSpec mSpacingSpec;
    private SpacingSpecData mData;

    public SpacingSpecViewHolder(ViewGroup parent, SpacingSpec spacingSpec, SpacingSpecViewType type) {
        super(createView(parent));
        mRoot = (ViewGroup) itemView;
        mType = type;
        mSpacingSpec = spacingSpec;

    }

    private static View createView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.linear_layout, parent, false);
    }

    public void bind(SpacingSpecData data) {
        mData = data;
        if (mData.isVertical) {
            bindVerticalList();
        } else {
            bindHorizontalList();
        }
    }

    private void bindVerticalList() {
        // Set parent size
        Context context = mRoot.getContext();
        int contentSizePx = mSpacingSpec.getContentSizePx(context);
        mRoot.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        // Divide list into span sizes
        List<List<Integer>> chunks = new ArrayList<>();
        List<Integer> toAdd = new ArrayList<>();

        for (int index = 0; index < mData.data.size(); index++) {
            if (index > 0 && index % mSpacingSpec.span == 0) {
                chunks.add(toAdd);
                toAdd = new ArrayList<>();
            }
            toAdd.add(mData.data.get(index));
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
            horizontalList.setAdapter(new HorizontalSquareViewAdapter(new SpacingSpecData(false, content), contentSizePx, mSpacingSpec.getPaddingPx(context)));
            mRoot.addView(horizontalList);
        }

    }

    private void bindHorizontalList() {
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
        horizontalList.setAdapter(new HorizontalSquareViewAdapter(mData, contentSizePx, mSpacingSpec.getPaddingPx(context)));
        mRoot.addView(horizontalList);
    }
}
