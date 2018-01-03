package com.donglin.maintenance.mvp.ui.fragments;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.donglin.maintenance.R;
import com.donglin.maintenance.Utils.MLog;
import com.donglin.maintenance.activity.OrderDetailsActivity;
import com.donglin.maintenance.adapter.MyOrderRecyclerViewAdapter;
import com.donglin.maintenance.adapter.interfaces.OnItemClickListener;
import com.donglin.maintenance.di.component.DaggerMyOrderComponent;
import com.donglin.maintenance.di.moudle.MyOrderModule;
import com.donglin.maintenance.mvp.base.BaseFragment;
import com.donglin.maintenance.mvp.presenter.MyOrdrPresenterImpl;
import com.donglin.maintenance.mvp.ui.view.MyOrderView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/20 0020.
 */

public class MyOrderFragment extends BaseFragment<MyOrdrPresenterImpl> implements MyOrderView, SwipeRefreshLayout.OnRefreshListener {


    private static final int RESCULT_CODE = 1;
    @BindView(R.id.my_fg_works_rv)
    RecyclerView myFgWorksRv;
    @BindView(R.id.my_swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private int posi;
    private MyOrderRecyclerViewAdapter myOrderRecyclerViewAdapter;
    private Boolean isLoading = false;

    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager
                .getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }

    @Override
    public void initView() {
        swipeRefreshLayout.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW);
        swipeRefreshLayout.setOnRefreshListener(this);
        myFgWorksRv.setLayoutManager(new LinearLayoutManager(getContext()));
        myFgWorksRv.setItemAnimator(new DefaultItemAnimator());
        myOrderRecyclerViewAdapter = new MyOrderRecyclerViewAdapter(getContext());
        myFgWorksRv.setAdapter(myOrderRecyclerViewAdapter);
        myFgWorksRv.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                int lastVisibleItemPosition = ((LinearLayoutManager) layoutManager)
                        .findLastVisibleItemPosition();
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                MLog.e("lastVisibleItemPosition:" + lastVisibleItemPosition);
                MLog.e("visibleItemCount:" + visibleItemCount);
                MLog.e("totalItemCount:" + totalItemCount);
                //总个数 - 最后一个可见的
                if (!isLoading && totalItemCount - lastVisibleItemPosition == 1) {
                    isLoading = true;
                    MLog.e("加载更多... ");
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                MLog.e("dx:" + dx);
                MLog.e("dy:" + dy);
            }
        });
        myOrderRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                posi = position;
                Intent intent = new Intent(getContext(), OrderDetailsActivity.class);
                startActivityForResult(intent, RESCULT_CODE);
            }
        });

    }

    @Override
    public void initData() {
        mPresenter.onCreate();
    }

    @Override
    public int getLayout() {
        return R.layout.dl_my_oreder_fragment;
    }

    @Override
    protected void setupFragmentComponent() {
        DaggerMyOrderComponent.builder().myOrderModule(new MyOrderModule(this, mContext)).build().inject(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == OrderDetailsActivity.RESULT_SUCCESS) {
            try {
                String name = data.getStringExtra("result");
                if (name.equals("true")) {
                    myOrderRecyclerViewAdapter.removeData(posi);
                }
            } catch (Exception e) {

            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
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
    public void showMyOrderList(List list) {

        myOrderRecyclerViewAdapter.setmLists(list);
    }

    @Override
    public void onRefresh() {
        mPresenter.loadMyOrderList();
    }
}
