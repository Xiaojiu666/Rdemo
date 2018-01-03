package com.donglin.maintenance.mvp.presenter.interfaces;

import com.donglin.maintenance.mvp.base.interfaces.BasePresenter;

/**
 * Created by Administrator on 2017/12/20 0020.
 */

public interface InProgressPresenter extends BasePresenter {
    void loadInProgressList();

    void loadInprogressDetalis();
}
