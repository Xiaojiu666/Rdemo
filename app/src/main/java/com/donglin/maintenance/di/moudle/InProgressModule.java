package com.donglin.maintenance.di.moudle;

import com.donglin.maintenance.di.scope.FragmentScope;
import com.donglin.maintenance.mvp.model.InProgressApiImpl;
import com.donglin.maintenance.mvp.model.interfaces.InProgressApi;
import com.donglin.maintenance.mvp.ui.view.InProgressView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/12/20 0020.
 */

@Module
public class InProgressModule {

    private InProgressView mView;

    public InProgressModule(InProgressView mView) {
        this.mView = mView;
    }

    @FragmentScope
    @Provides
    InProgressView provideInProgressView() {
        return mView;
    }

    @FragmentScope
    @Provides
    InProgressApi provideMyOrderApi() {
        return new InProgressApiImpl();
    }

}
