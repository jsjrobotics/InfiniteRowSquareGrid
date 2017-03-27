package com.jsjrobotics.testbinder.spacingSpecRecycler;


import android.view.ViewGroup;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;

import java.util.List;

public class SpacingSpecData<T> {
    public final boolean isVertical;
    public final List<T> content;
    public final BiFunction<SpacingSpecViewHolder<T>, ViewGroup, SpacingSpec> viewHolderCreator;
    public final Optional<Integer> overrideColumns;
    public SpacingSpecData(
            final boolean isVertical,
            final List<T> data,
            final BiFunction<SpacingSpecViewHolder<T>, ViewGroup, SpacingSpec> viewholderCreator) {
        this.isVertical = isVertical;
        this.content = data;
        this.viewHolderCreator = viewholderCreator;
        overrideColumns = Optional.empty();
    }

    public SpacingSpecData(
            final boolean isVertical,
            final List<T> data,
            final BiFunction<SpacingSpecViewHolder<T>, ViewGroup, SpacingSpec> viewholderCreator,
            final int columns) {
        this.isVertical = isVertical;
        this.content = data;
        this.viewHolderCreator = viewholderCreator;
        overrideColumns = Optional.of(columns);
    }
}
