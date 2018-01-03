package com.donglin.maintenance.mvp.ui.view;

import com.donglin.maintenance.mvp.base.interfaces.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/12/20 0020.
 */

public interface InProgressView extends BaseView {
    void showInProgressList(List list);
}
