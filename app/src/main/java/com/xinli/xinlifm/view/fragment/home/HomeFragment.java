package com.xinli.xinlifm.view.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.xinli.xinlifm.http.bean.HomeBean;
import com.xinli.xinlifm.mvp.iview.MvpView;
import com.xinli.xinlifm.mvp.model.SuperModel;
import com.xinli.xinlifm.view.fragment.BaseFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 *   首页
 * Created by zz on 16-10-12.
 */

public class HomeFragment extends BaseFragment<SuperModel> implements MvpView<HomeBean>{


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().register(this);
        getModel().getModelData();

    }
    @Subscribe
    @Override
    public void showView(HomeBean data) {
        Log.e("自定义标签", "类名==HomePresenter" + "方法名==getHomeData=====:" + data);
        //请求回来的时候取消注册不然会出现，已经注册的错误
        EventBus.getDefault().unregister(this);
    }

    @Override
    public SuperModel getModel() {
        return new SuperModel();
    }
}
