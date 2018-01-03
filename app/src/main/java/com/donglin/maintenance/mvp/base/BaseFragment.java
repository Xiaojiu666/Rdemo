package com.donglin.maintenance.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.donglin.maintenance.MyApp;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/25 0025.
 */

public abstract class BaseFragment<T extends BasePresenterImpl> extends Fragment {

    public Context mContext;
    @Inject
    protected T mPresenter;
    Unbinder unbinder;
    private MyApp mApplication;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), null);
        unbinder = ButterKnife.bind(this, view);
        mContext = getActivity();
        initView();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupFragmentComponent();
        initData();
    }

    public abstract void initView();

    public abstract void initData();

    public abstract int getLayout();

    //提供AppComponent(提供所有的单例对象)给子类，进行Component依赖
    protected abstract void setupFragmentComponent();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
