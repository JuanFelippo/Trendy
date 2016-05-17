package com.example.juan.Trendy.data.factory;

import com.example.juan.Trendy.data.Repository;
import com.example.juan.Trendy.data.cache.CacheDataSource;
import com.example.juan.Trendy.data.cloud.CloudDataSource;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * @author by Juan on 5/16/16.
 */
public class DataSourceFactory implements Repository {

    private CloudDataSource cloudDataSource;
    private CacheDataSource cacheDataSource;

    @Inject
    public DataSourceFactory(CloudDataSource cloudDataSource) {
        this.cloudDataSource = cloudDataSource;
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
