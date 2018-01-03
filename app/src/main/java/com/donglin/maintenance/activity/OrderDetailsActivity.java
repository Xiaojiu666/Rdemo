package com.donglin.maintenance.activity;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.donglin.maintenance.R;
import com.donglin.maintenance.adapter.OrederDetailsAdapter;
import com.donglin.maintenance.mvp.base.BaseAppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/26 0026.
 */

public class OrderDetailsActivity extends BaseAppCompatActivity {

    public static final int RESULT_SUCCESS = 1;
    public static final int RESULT_FAILED = 0;
    @BindView(R.id.tb_tv_center)
    TextView mTbTvCenter;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.my_order_rv)
    RecyclerView myOrderRv;
    @BindView(R.id.my_order_button_go)
    Button myOrderButtonGo;
    private List<String> list;

    @Override
    public int getView() {
        return R.layout.dl_my_order_details_activity;
    }

    @Override
    public void initToobar(Toolbar toolbar) {
        super.initToobar(toolbar);
    }

    @Override
    public void initView() {
        final OrederDetailsAdapter orederDetailsAdapter = new OrederDetailsAdapter(this, list);
        mTbTvCenter.setText("工单详情");
        myOrderRv.setLayoutManager(new LinearLayoutManager(this));
        myOrderRv.setItemAnimator(new DefaultItemAnimator());
        myOrderRv.setAdapter(orederDetailsAdapter);
        initToobar(toolbar);
    }

    @Override
    public void initData() {
        list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            list.add("点型烟感探测器" + i);
        }
    }


    @Override
    protected void initOnclickView() {
        myOrderButtonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("result", "true");
                setResult(RESULT_SUCCESS, intent);
                finish();
            }
        });
    }


}
