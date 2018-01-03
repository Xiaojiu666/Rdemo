package com.donglin.maintenance.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.donglin.maintenance.mvp.ui.fragments.InProgressFragment;
import com.donglin.maintenance.mvp.ui.fragments.MyOrderFragment;
import com.donglin.maintenance.mvp.ui.fragments.Wait4ConfirmFragment;

import java.util.List;

/**
 * Created by Administrator on 2017/7/20 0020.
 */

public class HomeFragmentPagerAdapter<T> extends FragmentPagerAdapter {

    private InProgressFragment inProgressFragment;
    private MyOrderFragment excelFragment;
    private Wait4ConfirmFragment wait4ConfirmFragment;


    public HomeFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public HomeFragmentPagerAdapter(FragmentManager fm, Context mContext) {
        this(fm);
        excelFragment = new MyOrderFragment();
        inProgressFragment = new InProgressFragment();
        wait4ConfirmFragment = new Wait4ConfirmFragment(mContext);
    }


    public void setData(List<T> data) {
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return excelFragment;
            case 1:
                return inProgressFragment;
            case 2:
                return wait4ConfirmFragment;
            default:
                return excelFragment;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "我的工单";
            case 1:
                return "正在维修";
            case 2:
                return "等待确认";
            default:
                return "我的工单";
        }
    }
}
