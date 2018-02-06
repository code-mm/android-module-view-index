package com.example.maohuawei.addressbookindex.app;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    private static App INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;


    }


    public static Context getContex() {
        return INSTANCE.getApplicationContext();
    }

}
