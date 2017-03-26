package com.jsjrobotics.testbinder;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.WeakReferenceSupplier;

public class MainFragment extends Fragment {

    private MainView mView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        mView = new MainView(new WeakReferenceSupplier<>(this), inflater, parent, savedInstanceState);
        return mView.getLayout();
    }
}
