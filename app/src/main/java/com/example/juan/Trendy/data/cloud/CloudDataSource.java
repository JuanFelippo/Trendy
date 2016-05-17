package com.example.juan.Trendy.data.cloud;

import com.example.juan.Trendy.data.Repository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * @author by Juan on 5/16/16.
 */
public class CloudDataSource implements Repository {

    private DribbleApi mDribbleApi;

    @Inject
    public CloudDataSource(DribbleApi mDribbleApi) {
        this.mDribbleApi = mDribbleApi;
    }

    @Override
    public Observable<List<Object>> popularShots(Integer page, Integer pageSize) {
        return null;
    }

    @Override
    public Observable<List<Object>> recentShots(Integer page, Integer pageSize) {
        return null;
    }

    @Override
    public Observable<List<Object>> debutShots(Integer page, Integer pageSize) {
        return null;
    }

    @Override
    public Observable<List<Object>> animatedShots(Integer page, Integer pageSize) {
        return null;
    }
}
