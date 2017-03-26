package com.jsjrobotics.testbinder.spacingSpecRecycler;


public interface BiFunction<T, R, S> {
    T accept(R data, S data2);
}
