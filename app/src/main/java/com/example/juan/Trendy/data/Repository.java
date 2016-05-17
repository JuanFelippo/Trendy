package com.example.juan.Trendy.data;

import java.util.List;

import rx.Observable;

/**
 * @author by Juan on 5/16/16.
 */
public interface Repository {

    Observable<List<Object>> popularShots(Integer page,
                                          Integer pageSize);

    Observable<List<Object>> recentShots(Integer page,
                                         Integer pageSize);

    Observable<List<Object>> debutShots(Integer page,
                                        Integer pageSize);

    Observable<List<Object>> animatedShots(Integer page,
                                           Integer pageSize);
}
