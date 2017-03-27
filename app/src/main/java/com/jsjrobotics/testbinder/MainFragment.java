package com.jsjrobotics.testbinder;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.WeakReferenceSupplier;
import com.jsjrobotics.defaultTemplate.prioritydownloader.PriorityDownloader;

public class MainFragment extends Fragment {

    private MainView mView;
    private PriorityDownloader<String> mDownloader;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDownloader = PriorityDownloader.from(getContext().getApplicationContext(), String.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        mView = new MainView(new WeakReferenceSupplier<>(this), inflater, parent, savedInstanceState, mDownloader);
        return mView.getLayout();
    }
}
