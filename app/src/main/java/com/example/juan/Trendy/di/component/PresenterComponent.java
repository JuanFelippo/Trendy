package com.example.juan.Trendy.di.component;

import com.example.juan.Trendy.di.PerActivity;
import com.example.juan.Trendy.di.module.ActivityModule;
import com.example.juan.Trendy.di.module.PresenterModule;
import com.example.juan.Trendy.ui.Activity.LoginActivity;
import com.example.juan.Trendy.ui.Activity.MainActivity;

import dagger.Component;

/**
 * @author by Juan on 5/15/16.
 */

/**
 * A scope {@link com.example.juan.Trendy.di.PerActivity} component.
 * Injects user specific Fragments.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, PresenterModule.class})
public interface PresenterComponent{
    void inject(LoginActivity loginActivity);
    void inject(MainActivity loginAActivity);
}
