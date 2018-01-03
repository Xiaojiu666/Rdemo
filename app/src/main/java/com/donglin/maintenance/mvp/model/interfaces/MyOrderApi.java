package com.donglin.maintenance.mvp.model.interfaces;

import com.donglin.maintenance.mvp.base.interfaces.BaseApi;
import com.donglin.maintenance.common.CallBackListener;

import java.util.List;

/**
 * Created by Administrator on 2017/12/15 0015.
 */

public interface MyOrderApi extends BaseApi {

    void loadMyOrdeApiForNet(CallBackListener<List<String>> callBackListener);

}
