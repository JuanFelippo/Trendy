package com.example.juan.Trendy.ui.Activity;
import com.example.juan.Trendy.R;
import com.example.juan.Trendy.mvp.HomeMVP;

public class MainActivity extends BaseActivity implements HomeMVP.View{

    @Override
    protected int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showLoadingIndicator() {

    }

    @Override
    public void hideLoadingIndicator() {

    }
}
