package com.donglin.maintenance.mvp.model;

import android.content.Context;
import android.util.Log;

import com.donglin.maintenance.mvp.model.interfaces.MyOrderApi;
import com.donglin.maintenance.common.CallBackListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/15 0015.
 */

public class MyOrderApiImpl implements MyOrderApi {

    public List<String> mList = new ArrayList<String>();
    public Context mContext;

    public MyOrderApiImpl(Context mContext) {
        this.mContext = mContext;
    }


    @Override
    public void onDestroy() {

    }

    @Override
    public void loadMyOrdeApiForNet(CallBackListener<List<String>> callBackListener) {
        for (int i = 0; i < 3; i++) {
            mList.add("天津国贸购物中心" + i);
        }
        Log.e("i", mList.size() + "");
        callBackListener.onSucessfull(mList);
    }
}
