package com.example.juan.Trendy.mvp;

/**
 * @author by Juan on 5/16/16.
 * Interface representing a Presenter in a model view presenter (MVP) pattern.
 */
public interface MVPPresenter<T extends MVPView>{

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onResume() method.
     */
    void resume();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onPause() method.
     */
    void pause();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onDestroy() method.
     */
    void destroy();

    void bindView(T view);
}
