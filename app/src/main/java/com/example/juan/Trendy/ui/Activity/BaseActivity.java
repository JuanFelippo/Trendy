package com.example.juan.Trendy.ui.Activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.juan.Trendy.TrendyApp;
import com.example.juan.Trendy.di.component.AppComponent;
import com.example.juan.Trendy.di.component.DaggerPresenterComponent;
import com.example.juan.Trendy.di.component.PresenterComponent;
import com.example.juan.Trendy.di.module.ActivityModule;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    private PresenterComponent presenterComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(getContentLayout());
        this.initButterKnife();

        this.getApplicationComponent().inject(this);
        this.presenterComponent = DaggerPresenterComponent.builder()
                .appComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    private void initButterKnife(){
        ButterKnife.bind(this);
    }

    /**
     * Adds a {@link Fragment} to this activity's layout.
     *
     * @param containerViewId The container view to where add the fragment.
     * @param fragment The fragment to be added.
     */
    protected void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    /**
     * Every activity has to inflate a layout in the onCreate method. We have added this method to
     * avoid duplicate all the inflate code in every fragment. You only have to return the layout to
     * inflate in this method when extends BaseActivity.
     */
    protected abstract int getContentLayout();

    /**
     * Get the Main Application component for dependency injection.
     *
     * @return {@link com.example.juan.Trendy.di.component.AppComponent}
     */
    public AppComponent getApplicationComponent() {
        return ((TrendyApp)getApplication()).getAppComponent();
    }

    /**
     * Get an Activity module for dependency injection.
     *
     * @return {@link com.example.juan.Trendy.di.module.ActivityModule}
     */
    public ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    /**
     * Get an Presenter module for dependency injection.
     *
     * @return {@link com.example.juan.Trendy.di.module.PresenterModule}
     */
    public PresenterComponent getPresenterComponent() {
        return presenterComponent;
    }
}
