package com.xinli.xinlifm.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xinli.xinlifm.R;

/**
 *      这个fragment只是来展示viewpager中或者判定
 *      fragment是否写对的，后面可以删除
 *
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends Fragment {


    public TestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        TextView textView = (TextView) view.findViewById(R.id.test_text);
        textView.setText(getClass().getSimpleName());
        textView.setTextSize(30);
        return view;
    }

}
