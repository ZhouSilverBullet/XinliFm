package com.xinli.xinlifm.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xinli.xinlifm.R;
import com.xinli.xinlifm.mvp.model.MvpModel;

/**
 *  这个是带个swipeRefreshLayout的fragment
 *      就用这个刷新把，一般二级界面有下拉刷新的，
 *      主页的那些没有，所以，为了方便和冲突，所以我就
 *      放了一个这个类，当然，也可以自己写
 *
 * A simple {@link Fragment} subclass.
 */
public abstract class RefreshFragment<M extends MvpModel> extends Fragment {

    private RecyclerView recycler;
    private M model;
    private SwipeRefreshLayout refreshLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = getModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reresh, container, false);
        recycler = ((RecyclerView) view.findViewById(R.id.refresh_recycler));
        refreshLayout = ((SwipeRefreshLayout) view.findViewById(R.id.refresh_swipe_layout));
        return view;
    }

    /**
     * 得到父类的recycler对象
     *
     * @return
     */
    public RecyclerView getRecycler() {
        return recycler;
    }
    /**
     * 得到父类的refreshLayout对象
     *
     * @return
     */
    public SwipeRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }

    public abstract M getModel();
}
