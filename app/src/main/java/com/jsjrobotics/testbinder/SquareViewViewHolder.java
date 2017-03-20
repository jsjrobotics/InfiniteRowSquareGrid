package com.jsjrobotics.testbinder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SquareViewViewHolder extends RecyclerView.ViewHolder {
    private final TextView mTextView;
    private final View mRoot;

    public SquareViewViewHolder(ViewGroup parent, int contentSize) {
        super(createView(parent, contentSize));
        mRoot = itemView;
        mTextView = (TextView) itemView.findViewById(R.id.content);
    }

    private static View createView(ViewGroup parent, int contentSize) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.square_text_view, parent, false);
        view.setLayoutParams(new LinearLayout.LayoutParams(contentSize, contentSize));
        return view;
    }

    public void bind(Integer integer) {
        mTextView.setText("" + integer);
    }

    public void setPadding(int paddingLeft, int paddingRight) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        int top = 0;
        int bottom = 0;
        params.setMargins(paddingLeft, top, paddingRight, bottom);
        mTextView.setLayoutParams(params);
    }
}
