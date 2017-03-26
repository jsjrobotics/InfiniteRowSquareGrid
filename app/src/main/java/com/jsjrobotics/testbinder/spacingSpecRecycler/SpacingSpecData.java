package com.jsjrobotics.testbinder.spacingSpecRecycler;


import android.view.ViewGroup;

import java.util.List;

public class SpacingSpecData<T> {
    public final boolean isVertical;
    public final List<T> content;
    public final BiFunction<SpacingSpecViewHolder<T>, ViewGroup, SpacingSpec> viewHolderCreator;

    public SpacingSpecData(final boolean isVertical, final List<T> data, final BiFunction<SpacingSpecViewHolder<T>, ViewGroup, SpacingSpec> viewholderCreator) {
        this.isVertical = isVertical;
        this.content = data;
        this.viewHolderCreator = viewholderCreator;
    }
}
