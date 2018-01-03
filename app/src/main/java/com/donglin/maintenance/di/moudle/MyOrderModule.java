package com.donglin.maintenance.di.moudle;

import android.content.Context;

import com.donglin.maintenance.di.scope.FragmentScope;
import com.donglin.maintenance.mvp.model.MyOrderApiImpl;
import com.donglin.maintenance.mvp.model.interfaces.MyOrderApi;
import com.donglin.maintenance.mvp.ui.view.MyOrderView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/12/18 0018.
 */
@Module
public class MyOrderModule {
    public MyOrderView myOrederView;
    public Context mContext;

    public MyOrderModule(MyOrderView myOrderView, Context mContext) {
        this.myOrederView = myOrderView;
        this.mContext = mContext;
    }

    @FragmentScope
    @Provides
    MyOrderView provideMyOrderView() {
        return myOrederView;
    }

    @FragmentScope
    @Provides
    MyOrderApi provideMyOrderApi() {
        return new MyOrderApiImpl(mContext);
    }
}
