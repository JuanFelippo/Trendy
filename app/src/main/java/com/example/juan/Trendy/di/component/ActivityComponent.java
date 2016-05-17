package com.example.juan.Trendy.di.component;

import android.app.Activity;

import com.example.juan.Trendy.di.PerActivity;
import com.example.juan.Trendy.di.module.ActivityModule;

import dagger.Component;

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 *
 * Subtypes of ActivityComponent should be decorated with annotation:
 * {@link com.example.juan.Trendy.di.PerActivity}
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
  //Exposed to sub-graphs.
  Activity activity();
}
