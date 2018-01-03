package com.donglin.maintenance.common;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.donglin.maintenance.Utils.MLog;

/**
 * Created by Administrator on 2017/12/20 0020.
 */

public class MyOnScrollListener extends RecyclerView.OnScrollListener {


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
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
    }
}
