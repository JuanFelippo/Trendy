package com.example.juan.Trendy.mvp;

/**
 * @author by Juan on 5/15/16.
 */
public interface HomeMVP {

    interface View extends MVPView {

    }

    interface Presenter extends MVPPresenter<HomeMVP.View>{

    }
}
