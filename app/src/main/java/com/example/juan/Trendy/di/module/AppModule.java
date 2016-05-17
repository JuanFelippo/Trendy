package com.example.juan.Trendy.di.module;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.example.juan.Trendy.TrendyApp;
import com.example.juan.Trendy.data.cloud.CloudDataSource;
import com.example.juan.Trendy.data.factory.DataSourceFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final TrendyApp mTrendyApplication;

    public AppModule(TrendyApp gagApplication) {
        this.mTrendyApplication= gagApplication;
    }

    @Provides @Singleton TrendyApp provideGAGApplication () { return mTrendyApplication; }

    @Provides @Singleton
    SharedPreferences provideSharedPreferences(TrendyApp appContext){
        return PreferenceManager.getDefaultSharedPreferences(appContext);
    }

    @Provides @Singleton DataSourceFactory provideDataSourceFactory(CloudDataSource cloudDataSource) {
        return new DataSourceFactory(cloudDataSource);
    }
}
