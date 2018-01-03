package com.donglin.maintenance.mvp.model.interfaces;

import com.donglin.maintenance.common.CallBackListener;
import com.donglin.maintenance.mvp.base.interfaces.BaseApi;

import java.util.List;

/**
 * Created by Administrator on 2017/12/20 0020.
 */

public interface InProgressApi extends BaseApi {
    void loadInProgressApi(CallBackListener<List<String>> listener);
}
