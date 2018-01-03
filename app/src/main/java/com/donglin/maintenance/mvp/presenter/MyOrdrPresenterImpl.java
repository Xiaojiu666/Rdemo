package com.donglin.maintenance.mvp.presenter;

import com.donglin.maintenance.di.scope.FragmentScope;
import com.donglin.maintenance.mvp.base.BasePresenterImpl;
import com.donglin.maintenance.mvp.model.interfaces.MyOrderApi;
import com.donglin.maintenance.mvp.presenter.interfaces.MyOrderPresenter;
import com.donglin.maintenance.mvp.ui.view.MyOrderView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/12/15 0015.
 */
@FragmentScope
public class MyOrdrPresenterImpl extends BasePresenterImpl<MyOrderView, MyOrderApi, List<String>> implements MyOrderPresenter {

    @Inject
    public MyOrdrPresenterImpl(MyOrderView myOrderView, MyOrderApi myOrderApi) {
        super(myOrderView, myOrderApi);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        loadMyOrderListForNet();
    }

    private void loadMyOrderListForNet() {
        mApi.loadMyOrdeApiForNet(this);
    }

    @Override
    public void loadMyOrderList() {
        loadMyOrderListForNet();
    }

    @Override
    public void onSucessfull(List<String> result) {
        super.onSucessfull(result);
        mView.showMyOrderList(result);
    }
}
