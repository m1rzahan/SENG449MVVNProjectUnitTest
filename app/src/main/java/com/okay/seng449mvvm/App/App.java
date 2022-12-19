package com.okay.seng449mvvm.App;

import android.app.Application;
import android.content.Context;

public class App extends Application {


    private static App mInstance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static App getInstance() {
        return mInstance;
    }

    public Context getAppContext()
    {
        return getApplicationContext();
    }
}
