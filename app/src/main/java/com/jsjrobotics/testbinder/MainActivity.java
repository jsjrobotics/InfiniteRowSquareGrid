package com.jsjrobotics.testbinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

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

public class MainActivity extends AppCompatActivity {

    private static final int SPAN = 3;
    private static final int MARGIN_DP = 16;
    private static final int PADDING_DP = MARGIN_DP / 4;

    private RecyclerView mRecyclerView;
    private final List<SpacingSpecData<?>> mData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mData.addAll(Arrays.asList(
                buildHorizontalList1(),
                buildHorizontalList2(),
                buildVerticalList(),
                buildHorizontalList3(),
                buildVerticalList2(),
                buildHorizontalList4()//buildHorizontalList5()
        ));
        mRecyclerView = (RecyclerView) findViewById(R.id.content_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        SpacingSpec mSpacingSpec = new SpacingSpec(SPAN, MARGIN_DP, PADDING_DP);
        mRecyclerView.setAdapter(new SpacingSpecAdapter(mSpacingSpec, mData));
    }

    private SpacingSpecData<Integer> buildHorizontalList2() {
        return new SpacingSpecData<>(false, buildIntegerList(5,9), buildSpacingSpecCreator() );
    }

    private SpacingSpecData<Integer> buildHorizontalList1() {
        return new SpacingSpecData<>(false, buildIntegerList(1,5), buildSpacingSpecCreator());
    }

    private SpacingSpecData<Integer> buildVerticalList() {
        return new SpacingSpecData<>(true, buildIntegerList(9, 16), buildSpacingSpecCreator());
    }

    private SpacingSpecData<Integer> buildHorizontalList3() {
        return new SpacingSpecData<>(false, buildIntegerList(16,28), buildSpacingSpecCreator());
    }

    private SpacingSpecData<Integer> buildVerticalList2() {
        return new SpacingSpecData<>(true, buildIntegerList(28, 42), buildSpacingSpecCreator());
    }

    private SpacingSpecData<Integer> buildHorizontalList4() {
        return new SpacingSpecData<>(false, buildIntegerList(42,56), buildSpacingSpecCreator());
    }

    private SpacingSpecData<String> buildHorizontalList5() {
        return new SpacingSpecData<>(false, buildUrlList(), buildUrlSpacingSpecCreator());
    }

    private List<String> buildUrlList() {
        return Arrays.asList(
                // image 1
                // image 2
                // image 3
        );
    }

    private BiFunction<SpacingSpecViewHolder<String>, ViewGroup, SpacingSpec> buildUrlSpacingSpecCreator() {
        return new BiFunction<SpacingSpecViewHolder<String>, ViewGroup, SpacingSpec>() {
            @Override
            public SpacingSpecViewHolder<String> accept(ViewGroup data, SpacingSpec spacingSpec) {
                return new SquareImageSpacingSpecViewHolder(data, spacingSpec);
            }
        };
    }


    private BiFunction<SpacingSpecViewHolder<Integer>, ViewGroup, SpacingSpec> buildSpacingSpecCreator() {
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
}
