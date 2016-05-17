package com.example.juan.Trendy.di.module;

import com.example.juan.Trendy.BuildConfig;
import com.example.juan.Trendy.TrendyApp;
import com.example.juan.Trendy.data.cloud.CloudDataSource;
import com.example.juan.Trendy.data.cloud.DribbleApi;
import com.example.juan.Trendy.data.cloud.util.AuthInterceptor;
import com.example.juan.Trendy.data.factory.AuthenticationFactory;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * @author by Juan on 5/16/16.
 */
@Module
public class CloudModule {
    @Provides
    @Singleton
    Cache provideOkHttpCache(TrendyApp application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    AuthInterceptor provideAuthInterceptor(AuthenticationFactory authenticationFactory) {
        return  new AuthInterceptor(authenticationFactory);
    }


    @Provides
    @Singleton
    @Named("intercepted")
    OkHttpClient provideOkHttpClient(Cache cache, AuthInterceptor authInterceptor) {
        OkHttpClient client = new OkHttpClient();
        client.setCache(cache);
        client.interceptors().add(authInterceptor);
//        client.networkInterceptors().add(new StethoInterceptor());
        return client;
    }

    @Provides
    @Singleton
    @Named("nonintercepted")
    OkHttpClient provideOkHttpClientNonIntercepted() {
        OkHttpClient client = new OkHttpClient();
        return client;
    }

    @Provides
    @Singleton
    @Named("intercepted")
    DribbleApi provideApiService(@Named("intercepted")OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build()
                .create(DribbleApi.class);
    }

    @Provides
    @Singleton
    @Named("nonintercepted")
    DribbleApi provideApiServiceNonIntercepted(@Named("nonintercepted")OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build()
                .create(DribbleApi.class);
    }

    @Provides
    @Singleton
    CloudDataSource provideCloudDataSource(@Named("intercepted")DribbleApi apiService) {
        return new CloudDataSource(apiService);
    }
}
