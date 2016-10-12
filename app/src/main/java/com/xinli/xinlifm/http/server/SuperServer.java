package com.xinli.xinlifm.http.server;

import com.xinli.xinlifm.http.bean.ForumBean;
import com.xinli.xinlifm.http.bean.HomeBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 *  这个类用来加载所有的视图
 *   我把bean全部建立好，然后写在这里
 *
 * Created by zz on 16-10-12.
 */

public interface SuperServer {
    //主页的
    @GET("/fm/home-list.json?key=046b6a2a43dc6ff6e770255f57328f89")
    Call<HomeBean> getHomeBean();


    @GET("/fm/forum-thread-list.json")
    Call<ForumBean> getForumBean(@Query("flag") int flag,@Query("offset") int offset,@Query("limit") int limit,
                         @Query("type") int type);


}
