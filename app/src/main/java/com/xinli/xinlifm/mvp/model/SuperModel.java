package com.xinli.xinlifm.mvp.model;

import com.xinli.xinlifm.http.bean.ForumBean;
import com.xinli.xinlifm.http.bean.HomeBean;
import com.xinli.xinlifm.http.server.BaseServer;
import com.xinli.xinlifm.http.server.SuperServer;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *  只要有数据就调用
 *  封装的不太好，见谅！！
 *
 * Created by zz on 16-10-12.
 */

public class SuperModel extends MvpModel{
    public void getModelData(){
        Call<HomeBean> homeBean = BaseServer.getApi(SuperServer.class).getHomeBean();
        homeBean.enqueue(new Callback<HomeBean>() {
            @Override
            public void onResponse(Call<HomeBean> call, Response<HomeBean> response) {
                EventBus.getDefault().post(response.body());
            }

            @Override
            public void onFailure(Call<HomeBean> call, Throwable t) {

            }
        });
    }


    /**
     *      没写注释的都别改，具体看地址，比如这个flag传个0就好了
     *
     * @param flag
     * @param offset
     *              刷新用的
     * @param limit
     * @param type
     *      社区精华 type=1
     *      社区最新 type =0
     */
    public void getForumData( int flag,int offset, int limit,int type){

        Call<ForumBean> forumBean = BaseServer.getApi(SuperServer.class).getForumBean(flag, offset, limit, type);
        forumBean.enqueue(new Callback<ForumBean>() {
            @Override
            public void onResponse(Call<ForumBean> call, Response<ForumBean> response) {
                EventBus.getDefault().post(response.body());
            }

            @Override
            public void onFailure(Call<ForumBean> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
