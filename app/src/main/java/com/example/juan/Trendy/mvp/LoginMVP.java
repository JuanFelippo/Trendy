package com.example.juan.Trendy.mvp;

/**
 * @author by Juan on 5/16/16.
 */
public interface LoginMVP {

    interface View extends MVPView {

    }

    interface Presenter extends MVPPresenter<LoginMVP.View>{

    }
}
