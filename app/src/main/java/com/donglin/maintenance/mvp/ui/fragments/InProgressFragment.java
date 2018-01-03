package com.donglin.maintenance.mvp.ui.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.donglin.maintenance.R;
import com.donglin.maintenance.Utils.MLog;
import com.donglin.maintenance.activity.PartListActivity;
import com.donglin.maintenance.adapter.InProgressRecyclerViewAdapter;
import com.donglin.maintenance.di.component.DaggerInProgressComponent;
import com.donglin.maintenance.di.moudle.InProgressModule;
import com.donglin.maintenance.mvp.base.BaseFragment;
import com.donglin.maintenance.mvp.presenter.InProgressPresenterImpl;
import com.donglin.maintenance.mvp.ui.view.InProgressView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/20 0020.
 */

public class InProgressFragment extends BaseFragment<InProgressPresenterImpl> implements InProgressView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.my_fg_inprogress_rv)
    RecyclerView myFgInprogressRv;
    @BindView(R.id.in_swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    private InProgressRecyclerViewAdapter inProgressRecyclerViewAdapter;

    public InProgressFragment() {
    }


    @Override
    public void initView() {
        swipeRefreshLayout.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW);
        swipeRefreshLayout.setOnRefreshListener(this);
        myFgInprogressRv.setLayoutManager(new LinearLayoutManager(getContext()));
        myFgInprogressRv.setItemAnimator(new DefaultItemAnimator());
        inProgressRecyclerViewAdapter = new InProgressRecyclerViewAdapter(getContext());
        myFgInprogressRv.setAdapter(inProgressRecyclerViewAdapter);
        inProgressRecyclerViewAdapter.setOnItemClickListener(new InProgressRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getContext(), PartListActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {
        mPresenter.onCreate();
    }

    @Override
    public int getLayout() {
        return R.layout.dl_in_progress_fragment;
    }

    @Override
    protected void setupFragmentComponent() {
        DaggerInProgressComponent.builder().inProgressModule(new InProgressModule(this)).build().inJect(this);
    }


    @Override
    public void showProgress() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showInProgressList(List list) {
        MLog.e("List" + list.size());
        inProgressRecyclerViewAdapter.setmLists(list);
    }

    @Override
    public void onRefresh() {
        mPresenter.loadInProgressList();
    }
}
