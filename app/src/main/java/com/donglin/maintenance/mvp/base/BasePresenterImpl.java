package com.donglin.maintenance.mvp.base;

import com.donglin.maintenance.common.CallBackListener;
import com.donglin.maintenance.mvp.base.interfaces.BaseApi;
import com.donglin.maintenance.mvp.base.interfaces.BasePresenter;
import com.donglin.maintenance.mvp.base.interfaces.BaseView;

/**
 * @author Administrator
 * @date 2017/12/15 0015
 */

public class BasePresenterImpl<V extends BaseView, M extends BaseApi, T> implements BasePresenter, CallBackListener<T> {

    public V mView;
    public M mApi;

    public BasePresenterImpl(V rootView, M model) {
        mView = rootView;
        mApi = model;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {
        if (mApi != null) {
            mApi.onDestroy();
            this.mApi = null;
        }
        this.mView = null;
    }


    @Override
    public void onBeforeRequest() {
        if (mView != null) {
            mView.showProgress();
        }
    }

    @Override
    public void onSucessfull(T result) {
        if (mView != null) {
            mView.hideProgress();
        }
    }

    @Override
    public void onFial() {
        if (mView != null) {
            mView.hideProgress();
        }
    }
}
