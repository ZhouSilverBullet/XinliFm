package com.xinli.xinlifm.http.server;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zz on 16-10-12.
 */

public class BaseServer {
    private final static String baseUrl="http://yiapi.xinli001.com/";
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    public static <T> T getApi(Class<T> type){
        return retrofit.create(type);
    }
}
