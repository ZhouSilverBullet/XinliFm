package com.xinli.xinlifm.view.fragment.forum;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.xinli.xinlifm.http.bean.ForumBean;
import com.xinli.xinlifm.mvp.iview.MvpView;
import com.xinli.xinlifm.mvp.model.SuperModel;
import com.xinli.xinlifm.view.fragment.BaseFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 *   社交
 * Created by zz on 16-10-12.
 */

public class ForumFragment extends BaseFragment<SuperModel> implements MvpView<ForumBean>{
    @Override
    public SuperModel getModel() {
        return new SuperModel();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().register(this);
        getModel().getForumData(0, 10 ,0 ,1);
    }

    @Subscribe
    @Override
    public void showView(ForumBean data) {
        Log.e("自定义标签", "类名==ForumFragment" + "方法名==showView=====:" + data);
        EventBus.getDefault().unregister(this);
    }
}
