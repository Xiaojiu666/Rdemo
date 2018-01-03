package com.donglin.maintenance.mvp.model;

import com.donglin.maintenance.common.CallBackListener;
import com.donglin.maintenance.mvp.model.interfaces.InProgressApi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/20 0020.
 */

public class InProgressApiImpl implements InProgressApi {
    public List<String> mList = new ArrayList<String>();

    public InProgressApiImpl() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void loadInProgressApi(CallBackListener<List<String>> listener) {
        for (int i = 0; i < 3; i++) {
            mList.add("天津国贸购物中心" + i);
        }
        listener.onSucessfull(mList);
    }
}
