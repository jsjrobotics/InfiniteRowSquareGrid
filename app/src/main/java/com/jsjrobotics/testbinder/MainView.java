package com.jsjrobotics.testbinder;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.WeakReferenceSupplier;
import com.jsjrobotics.testbinder.spacingSpecRecycler.BiFunction;
import com.jsjrobotics.testbinder.spacingSpecRecycler.SpacingSpec;
import com.jsjrobotics.testbinder.spacingSpecRecycler.SpacingSpecAdapter;
import com.jsjrobotics.testbinder.spacingSpecRecycler.SpacingSpecData;
import com.jsjrobotics.testbinder.spacingSpecRecycler.SpacingSpecViewHolder;
import com.jsjrobotics.testbinder.viewHolders.IntegerSpacingSpecViewHolder;
import com.jsjrobotics.testbinder.viewHolders.SquareImageSpacingSpecViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainView {
    private final View mRoot;
    private final WeakReferenceSupplier<Fragment> mContext;
    private RecyclerView mRecyclerView;
    private final List<SpacingSpecData<?>> mData = new ArrayList<>();

    private static final int SPAN = 3;
    private static final int MARGIN_DP = 16;
    private static final int PADDING_DP = MARGIN_DP / 4;

    public MainView(
            WeakReferenceSupplier<Fragment> context,
            LayoutInflater inflater,
            ViewGroup parent,
            Bundle savedInstanceState) {
        mContext = context;
        mRoot = inflater.inflate(R.layout.main_fragment, parent, false);
        mData.addAll(Arrays.asList(
                buildHorizontalList1(),
                buildHorizontalList2(),
                buildVerticalList(),
                buildHorizontalList3(),
                buildVerticalList2(),
                buildHorizontalList4(),
                buildHorizontalList5()
        ));
        mRecyclerView = (RecyclerView) mRoot.findViewById(R.id.content_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRoot.getContext()));
        SpacingSpec mSpacingSpec = new SpacingSpec(SPAN, MARGIN_DP, PADDING_DP);
        mRecyclerView.setAdapter(new SpacingSpecAdapter(mSpacingSpec, mData));
    }

    private SpacingSpecData<Integer> buildHorizontalList2() {
        return new SpacingSpecData<>(false, buildIntegerList(5,9), buildImageViewHolder() );
    }

    private SpacingSpecData<Integer> buildHorizontalList1() {
        return new SpacingSpecData<>(false, buildIntegerList(1,5), buildImageViewHolder());
    }

    private SpacingSpecData<Integer> buildVerticalList() {
        return new SpacingSpecData<>(true, buildIntegerList(9, 16), buildImageViewHolder());
    }

    private SpacingSpecData<Integer> buildHorizontalList3() {
        return new SpacingSpecData<>(false, buildIntegerList(16,28), buildImageViewHolder());
    }

    private SpacingSpecData<Integer> buildVerticalList2() {
        return new SpacingSpecData<>(true, buildIntegerList(28, 42), buildImageViewHolder());
    }

    private SpacingSpecData<Integer> buildHorizontalList4() {
        return new SpacingSpecData<>(false, buildIntegerList(42,56), buildImageViewHolder());
    }

    private SpacingSpecData<String> buildHorizontalList5() {
        return new SpacingSpecData<>(false, buildUrlList(), buildUrlViewHolder());
    }

    private List<String> buildUrlList() {
        return Arrays.asList(
                "http://jsjrobotics.nyc/classroom/photos/letter_A.jpg",
                "http://jsjrobotics.nyc/classroom/photos/letter_B.jpg",
                "http://jsjrobotics.nyc/classroom/photos/letter_C.jpg",
                "http://jsjrobotics.nyc/classroom/photos/letter_D.jpg",
                "http://jsjrobotics.nyc/classroom/photos/letter_E.jpg"
        );
    }

    private BiFunction<SpacingSpecViewHolder<String>, ViewGroup, SpacingSpec> buildUrlViewHolder() {
        return new BiFunction<SpacingSpecViewHolder<String>, ViewGroup, SpacingSpec>() {
            @Override
            public SpacingSpecViewHolder<String> accept(ViewGroup data, SpacingSpec spacingSpec) {
                return new SquareImageSpacingSpecViewHolder(mContext, data, spacingSpec);
            }
        };
    }


    private BiFunction<SpacingSpecViewHolder<Integer>, ViewGroup, SpacingSpec> buildImageViewHolder() {
        return new BiFunction<SpacingSpecViewHolder<Integer>, ViewGroup, SpacingSpec>() {
            @Override
            public SpacingSpecViewHolder<Integer> accept(ViewGroup parent, SpacingSpec spacingSpec) {
                return new IntegerSpacingSpecViewHolder(parent, spacingSpec);
            }
        };
    }

    private List<Integer> buildIntegerList(int startInclusive, int endExclusive) {
        List<Integer> result = new ArrayList<>();
        for (int index = startInclusive; index < endExclusive; index++) {
            result.add(index);
        }
        return result;
    }

    public View getLayout() {
        return mRoot;
    }
}
