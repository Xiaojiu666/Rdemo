package com.donglin.maintenance.di.component;

import com.donglin.maintenance.di.moudle.MyOrderModule;
import com.donglin.maintenance.di.scope.FragmentScope;
import com.donglin.maintenance.mvp.ui.fragments.MyOrderFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/12/18 0018.
 */
@FragmentScope
@Component(modules = MyOrderModule.class)
public interface MyOrderComponent {

    void inject(MyOrderFragment fragment);
}
