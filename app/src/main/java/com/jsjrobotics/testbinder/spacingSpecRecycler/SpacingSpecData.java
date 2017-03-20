package com.jsjrobotics.testbinder.spacingSpecRecycler;


import java.util.List;

public class SpacingSpecData {
    public final boolean isVertical;
    public final List<Integer> data;

    public SpacingSpecData(boolean isVertical, List<Integer> data) {
        this.isVertical = isVertical;
        this.data = data;
    }
}
