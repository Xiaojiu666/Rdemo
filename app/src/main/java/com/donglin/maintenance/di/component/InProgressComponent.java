package com.donglin.maintenance.di.component;

import com.donglin.maintenance.di.moudle.InProgressModule;
import com.donglin.maintenance.di.scope.FragmentScope;
import com.donglin.maintenance.mvp.ui.fragments.InProgressFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/12/20 0020.
 */

@FragmentScope
@Component(modules = InProgressModule.class)
public interface InProgressComponent {
    void inJect(InProgressFragment inProgressFragment);
}
