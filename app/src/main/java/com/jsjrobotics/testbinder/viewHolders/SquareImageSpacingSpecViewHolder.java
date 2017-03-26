package com.jsjrobotics.testbinder.viewHolders;


import android.view.ViewGroup;

import com.jsjrobotics.testbinder.spacingSpecRecycler.BiFunction;
import com.jsjrobotics.testbinder.spacingSpecRecycler.SpacingSpec;
import com.jsjrobotics.testbinder.spacingSpecRecycler.SpacingSpecData;
import com.jsjrobotics.testbinder.spacingSpecRecycler.SpacingSpecViewHolder;

public class SquareImageSpacingSpecViewHolder extends SpacingSpecViewHolder<String> {
    public SquareImageSpacingSpecViewHolder(ViewGroup data, SpacingSpec spacingSpec) {
        super(data, spacingSpec);
    }

    @Override
    public void bindVerticalList(BiFunction<SpacingSpecViewHolder<String>, ViewGroup, SpacingSpec> viewHolderCreator, SpacingSpecData<String> data) {

    }

    @Override
    public void bindHorizontalList(SpacingSpecData<String> data) {

    }
}
