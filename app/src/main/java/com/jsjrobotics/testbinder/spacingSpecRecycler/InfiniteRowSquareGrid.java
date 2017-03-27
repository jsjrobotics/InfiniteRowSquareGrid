package com.jsjrobotics.testbinder.spacingSpecRecycler;


import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.jsjrobotics.testbinder.spacingSpecRecycler.SpacingSpec;
import com.jsjrobotics.testbinder.spacingSpecRecycler.SpacingSpecAdapter;
import com.jsjrobotics.testbinder.spacingSpecRecycler.SpacingSpecData;

import java.util.List;

public class InfiniteRowSquareGrid extends RecyclerView {
    private List<SpacingSpecData<?>> mData;
    private SpacingSpec mSpacingSpec;

    public InfiniteRowSquareGrid(Context context) {
        super(context);
        setLayoutManager(context);
    }

    public InfiniteRowSquareGrid(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setLayoutManager(context);
    }

    public InfiniteRowSquareGrid(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setLayoutManager(context);
    }

    private void setLayoutManager(Context context) {
        super.setLayoutManager(new LinearLayoutManager(context));
    }

    public void setData(SpacingSpec spacingSpec, List<SpacingSpecData<?>> data) {
        mData = data;
        mSpacingSpec = spacingSpec;
        setAdapter(new SpacingSpecAdapter(mSpacingSpec, mData));
    }
}
