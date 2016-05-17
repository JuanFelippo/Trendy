package com.example.juan.Trendy;

import android.app.Application;

import com.example.juan.Trendy.di.component.AppComponent;
import com.example.juan.Trendy.di.component.DaggerAppComponent;
import com.example.juan.Trendy.di.module.AppModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Juan on 5/16/16.
 */
public class TrendyApp extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initialize3rdPartyLibraries();
        this.initializeInjector();
    }

//    @Override
//    protected void attachBaseContext(Context base) {
//        super.attachBaseContext(base);
//        MultiDex.install(this);
//    }

    private void initializeInjector() {
        this.mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    private void initialize3rdPartyLibraries(){
        LeakCanary.install(this);
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
