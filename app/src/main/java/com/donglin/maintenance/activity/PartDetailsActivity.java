package com.donglin.maintenance.activity;

import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.donglin.maintenance.R;
import com.donglin.maintenance.mvp.base.BaseAppCompatActivity;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/8/1 0001.
 */

public class PartDetailsActivity extends BaseAppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tb_tv_center)
    TextView mTbTvCenter;

    @Override
    protected void initOnclickView() {

    }

    @Override
    public int getView() {
        return R.layout.dl_in_progress_part_details_activity;
    }

    @Override
    public void initView() {
        mTbTvCenter.setText("部件详情");
        initToobar(toolbar);
    }

    @Override
    public void initData() {

    }

}
