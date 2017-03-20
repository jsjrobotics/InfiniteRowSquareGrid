package com.jsjrobotics.testbinder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

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
        for (int index = 0; index < mData.data.size(); index+= mSpacingSpec.span) {
            List<Integer> current = new ArrayList<>();
            current.add(mData.data.get(index));
            if (index +1 < mData.data.size()) {
                current.add(mData.data.get(index+1));
            }
            chunks.add(current);
        }

        // Build linear layouts of content height size and parent width
        for (List<Integer> content : chunks) {
            RecyclerView horizontalList = new RecyclerView(context);
            horizontalList.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, contentSizePx));
            horizontalList.setPadding(mSpacingSpec.getMarginPx(context), 0, mSpacingSpec.getMarginPx(context), 0);
            horizontalList.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            horizontalList.setAdapter(new HorizontalSquareViewAdapter(new SpacingSpecData(false, content, null), contentSizePx));
            mRoot.addView(horizontalList);
        }

    }

    private void bindHorizontalList() {
        // Build a Horizontal Scroll View with height w
        // Add padding equal to the margin to left size
        Context context = mRoot.getContext();
        int contentSizePx = mSpacingSpec.getContentSizePx(context);
        mRoot.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, contentSizePx));
        RecyclerView horizontalList = new RecyclerView(context);
        horizontalList.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, contentSizePx));
        horizontalList.setClipToPadding(false);
        horizontalList.setPadding(mSpacingSpec.getMarginPx(context), 0, 0, 0);
        horizontalList.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        horizontalList.setAdapter(new HorizontalSquareViewAdapter(mData, contentSizePx));
        mRoot.addView(horizontalList);

    }
}
