package com.jsjrobotics.testbinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int SPAN = 2;
    private static final int MARGIN_DP = 16;
    private static final int VERTICAL_DISPLAY_DP = 280;

    private RecyclerView mRecyclerView;
    private final List<SpacingSpecData> mData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mData.add(buildHorizontalList1());
        mData.add(buildHorizontalList2());
        mData.add(buildVerticalList());
        mRecyclerView = (RecyclerView) findViewById(R.id.content_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        SpacingSpec mSpacingSpec = new SpacingSpec(SPAN, MARGIN_DP);
        mRecyclerView.setAdapter(new SpacingSpecAdapter(mSpacingSpec, mData));
    }

    private SpacingSpecData buildHorizontalList2() {
        return new SpacingSpecData(false, Arrays.asList(5,6,7,8), null);
    }

    private SpacingSpecData buildHorizontalList1() {
        return new SpacingSpecData(false, Arrays.asList(1,2,3,4), null);
    }

    private SpacingSpecData buildVerticalList() {
        return new SpacingSpecData(true, Arrays.asList(9, 10, 11, 12, 13, 14, 15,16,17,18,19,20), VERTICAL_DISPLAY_DP);
    }
}
