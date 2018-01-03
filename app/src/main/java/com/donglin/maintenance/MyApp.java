package com.donglin.maintenance;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

/**
 * Created by Administrator on 2017/12/15 0015.
 */

public class MyApp extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        //this.mAppModule = new AppModule(this,mAppManager);//提供application
      /*  mAppComponent = DaggerAppComponent
                .builder()
                .appModule(mAppModule)
                .build();*/
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
