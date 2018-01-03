package com.donglin.maintenance.mvp.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.donglin.maintenance.R;
import com.donglin.maintenance.activity.PartListActivity;
import com.donglin.maintenance.adapter.InProgressRecyclerViewAdapter;
import com.donglin.maintenance.mvp.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/20 0020.
 */

public class Wait4ConfirmFragment extends BaseFragment {

    @BindView(R.id.my_fg_inprogress_rv)
    RecyclerView myFgInprogressRv;
    private List mList = new ArrayList<String>();
    private InProgressRecyclerViewAdapter inProgressRecyclerViewAdapter;

    public Wait4ConfirmFragment() {
    }

    public Wait4ConfirmFragment(Context mContext) {
        for (int i = 0; i < 3; i++) {
            mList.add("天津国贸购物中心" + i);
        }
    }

    @Override
    public void initView() {
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

    }

    @Override
    public int getLayout() {
        return R.layout.dl_in_progress_fragment;
    }

    @Override
    protected void setupFragmentComponent() {

    }


}
