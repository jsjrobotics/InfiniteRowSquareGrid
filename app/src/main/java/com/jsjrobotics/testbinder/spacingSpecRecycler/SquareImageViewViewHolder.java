package com.jsjrobotics.testbinder.spacingSpecRecycler;

import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.WeakReferenceSupplier;
import com.jsjrobotics.defaultTemplate.prioritydownloader.ImageUtils;
import com.jsjrobotics.defaultTemplate.prioritydownloader.PriorityDownloader;
import com.jsjrobotics.testbinder.R;

public class SquareImageViewViewHolder extends RecyclerView.ViewHolder {
    private final ImageView mImageView;
    private final View mRoot;
    private WeakReferenceSupplier<Fragment> mContext;

    public SquareImageViewViewHolder(WeakReferenceSupplier<Fragment> context, ViewGroup parent, int contentSize) {
        super(createView(parent, contentSize));
        mRoot = itemView;
        mImageView = (ImageView) itemView.findViewById(R.id.content);
        mContext = context;
    }

    private static View createView(ViewGroup parent, int contentSize) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.square_image_view, parent, false);
        view.setLayoutParams(new LinearLayout.LayoutParams(contentSize, contentSize));
        return view;
    }

    public void bind(String url) {
        mImageView.setBackgroundColor(0x88115572);
        final WeakReferenceSupplier<ImageView> imageViewSupplier = new WeakReferenceSupplier<>(mImageView);
        PriorityDownloader<String> downloader = PriorityDownloader.from(mRoot.getContext(), String.class);
        ImageUtils.downloadAndDisplayImage(mContext, downloader, imageViewSupplier, url, R.id.square_image_view_holder);
    }

    public void setPadding(int paddingLeft, int paddingRight) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        int top = 0;
        int bottom = 0;
        params.setMargins(paddingLeft, top, paddingRight, bottom);
        mImageView.setLayoutParams(params);
    }
}
