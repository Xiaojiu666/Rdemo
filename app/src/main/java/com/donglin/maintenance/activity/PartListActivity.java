package com.donglin.maintenance.activity;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.donglin.maintenance.R;
import com.donglin.maintenance.adapter.OrederDetailsAdapter;
import com.donglin.maintenance.mvp.base.BaseAppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/31 0031.
 */

public class PartListActivity extends BaseAppCompatActivity {
    @BindView(R.id.part_list_rv)
    RecyclerView partListRv;
    @BindView(R.id.tb_tv_center)
    TextView mTbTvCenter;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private List<String> list;

    @Override
    protected void initOnclickView() {

    }

    @Override
    public int getView() {
        return R.layout.dl_part_list_activity;
    }

    @Override
    public void initView() {
        final OrederDetailsAdapter orederDetailsAdapter = new OrederDetailsAdapter(this, list);
        mTbTvCenter.setText("部件列表");
        partListRv.setLayoutManager(new LinearLayoutManager(this));
        partListRv.setItemAnimator(new DefaultItemAnimator());
        partListRv.setAdapter(orederDetailsAdapter);
        orederDetailsAdapter.setOnItemClickListener(new OrederDetailsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(PartListActivity.this, PartDetailsActivity.class);
                startActivity(intent);
            }
        });
        initToobar(toolbar);
    }

    @Override
    public void initData() {
        list = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            list.add("点型烟感探测器" + i);
        }
    }

}
