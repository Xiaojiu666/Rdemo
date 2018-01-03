package com.donglin.maintenance.mvp.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/26 0026.
 */

public abstract class BaseAppCompatActivity extends AppCompatActivity {

    public Context mContext;
    private ProgressDialog progDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());
        ButterKnife.bind(this);
        mContext = getBaseContext();
        initData();
        initView();
        initOnclickView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    protected abstract void initOnclickView();

    public void initToobar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }


    public abstract int getView();

    public abstract void initView();

    public abstract void initData();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * 显示进度框
     */
    public void showProgressDialog() {
        if (progDialog == null) {
            progDialog = new ProgressDialog(this);
            progDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progDialog.setIndeterminate(false);
            progDialog.setCancelable(true);
            progDialog.show();
        }
    }


    /**
     * 隐藏进度框
     */
    public void dissmissProgressDialog() {
        if (progDialog != null) {
            progDialog.dismiss();
        }
    }


}
