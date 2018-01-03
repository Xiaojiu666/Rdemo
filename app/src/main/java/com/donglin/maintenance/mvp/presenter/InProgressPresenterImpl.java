package com.donglin.maintenance.mvp.presenter;

import com.donglin.maintenance.mvp.base.BasePresenterImpl;
import com.donglin.maintenance.mvp.model.interfaces.InProgressApi;
import com.donglin.maintenance.mvp.presenter.interfaces.InProgressPresenter;
import com.donglin.maintenance.mvp.ui.view.InProgressView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/12/20 0020.
 */

public class InProgressPresenterImpl extends BasePresenterImpl<InProgressView, InProgressApi, List<String>> implements InProgressPresenter {

    @Inject
    public InProgressPresenterImpl(InProgressView rootView, InProgressApi model) {
        super(rootView, model);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        loadListForNet();
    }

    @Override
    public void loadInProgressList() {
        loadListForNet();
    }

    @Override
    public void loadInprogressDetalis() {

    }

    @Override
    public void onSucessfull(List<String> result) {
        super.onSucessfull(result);
        mView.showInProgressList(result);
    }

    public void loadListForNet() {
        mApi.loadInProgressApi(this);
    }
}
