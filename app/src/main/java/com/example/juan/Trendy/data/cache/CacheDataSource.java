package com.example.juan.Trendy.data.cache;

import com.example.juan.Trendy.data.Repository;

import java.util.HashMap;
import java.util.List;

import rx.Observable;

/**
 * @author by Juan on 5/16/16.
 */
public class CacheDataSource implements Repository {

    HashMap<String,List<Object>> tempCached = new HashMap<>();

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

    public List<Object> getShots(String key){
        return tempCached.get(key);
    }
}
