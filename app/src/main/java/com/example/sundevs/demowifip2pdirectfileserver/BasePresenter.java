package com.example.sundevs.demowifip2pdirectfileserver;

/**
 * Created by SunDevs on 8/01/2018.
 */

public interface BasePresenter {
    void attachView(ServerContract.MainView view);
    void detachView();
}
