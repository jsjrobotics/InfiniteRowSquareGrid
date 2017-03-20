package com.jsjrobotics.testbinder;


import java.util.List;

public class SpacingSpecData {
    public final boolean isVertical;
    public final List<Integer> data;
    public final Integer verticalDisplayHeight;

    public SpacingSpecData(boolean isVertical, List<Integer> data, Integer verticalDisplayHeight) {
        this.isVertical = isVertical;
        this.data = data;
        if (isVertical && verticalDisplayHeight == null) {
            throw new IllegalArgumentException("display height can't be null for vertical content");
        }
        this.verticalDisplayHeight = verticalDisplayHeight;
    }
}
