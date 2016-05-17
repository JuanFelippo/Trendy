package com.example.juan.Trendy.di.component;
import com.example.juan.Trendy.TrendyApp;
import com.example.juan.Trendy.di.module.AppModule;
import com.example.juan.Trendy.di.module.CloudModule;
import com.example.juan.Trendy.ui.Activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton @Component(modules = {AppModule.class, CloudModule.class})
public interface AppComponent {
    TrendyApp app();
    void inject(BaseActivity baseActivity);
}
