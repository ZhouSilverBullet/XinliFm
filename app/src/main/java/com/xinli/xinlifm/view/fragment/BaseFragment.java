package com.xinli.xinlifm.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xinli.xinlifm.R;
import com.xinli.xinlifm.mvp.model.MvpModel;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment<M extends MvpModel> extends Fragment {
    private M model;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = getModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_base, container, false);
    }

    public abstract M getModel();
}
