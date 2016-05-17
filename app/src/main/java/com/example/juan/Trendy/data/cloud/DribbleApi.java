package com.example.juan.Trendy.data.cloud;

import com.example.juan.Trendy.data.cloud.model.Shot;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * @author by Juan on 5/16/16.
 */
public interface DribbleApi {

    @GET("v1/shots")
    Observable<List<Shot>> getPopular(@Query("page") Integer page);

    @GET("v1/shots?sort=recent")
    Observable<List<Shot>> getRecent(@Query("page") Integer page);

    @GET("v1/shots?list=debuts")
    Observable<List<Shot>> getDebuts(@Query("page") Integer page);

    @GET("v1/shots?list=animated")
    Observable<List<Shot>> getAnimated(@Query("page") Integer page);

}
