package com.jsjrobotics.testbinder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class SquareViewViewHolder extends RecyclerView.ViewHolder {
    private final TextView mTextView;

    public SquareViewViewHolder(ViewGroup parent, int contentSize) {
        super(createView(parent, contentSize));
        mTextView = (TextView) itemView;
    }

    private static View createView(ViewGroup parent, int contentSize) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        TextView textView = (TextView) inflater.inflate(R.layout.square_text_view, parent, false);
        textView.setWidth(contentSize);
        textView.setHeight(contentSize);
        return textView;
    }

    public void bind(Integer integer) {
        mTextView.setText("" + integer);
        mTextView.setBackgroundColor(0xFF113344);
    }
}
