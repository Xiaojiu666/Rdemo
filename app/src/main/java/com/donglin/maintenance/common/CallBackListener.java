package com.donglin.maintenance.common;

/**
 * Created by Administrator on 2017/12/15 0015.
 */

public interface CallBackListener<T> {

    void onBeforeRequest();

    void onSucessfull(T result);

    void onFial();
}
