package com.example.juan.Trendy.di.module;

import android.app.Activity;

import com.example.juan.Trendy.di.PerActivity;
import com.example.juan.Trendy.mvp.HomeMVP;
import com.example.juan.Trendy.mvp.Presenter.HomePresenter;
import com.example.juan.Trendy.mvp.LoginMVP;
import com.example.juan.Trendy.mvp.Presenter.LoginPresenter;

import dagger.Module;
import dagger.Provides;


/**
 * @author by Juan on 5/16/16.
 */
@Module
public class PresenterModule{

    @Provides @PerActivity
    LoginMVP.Presenter provideLoginPresenterImpl(Activity activity){
        return new LoginPresenter();
    }

    @Provides @PerActivity
    HomeMVP.Presenter provideHomePresenter(Activity activity){
        return new HomePresenter();
    }
}
