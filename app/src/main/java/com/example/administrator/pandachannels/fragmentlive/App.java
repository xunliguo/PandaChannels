package com.example.administrator.pandachannels.fragmentlive;

import android.app.Application;

import com.example.administrator.pandachannels.framework.baseview.BaseActivity;

/**
 * Created by ASUS-PC on 2017/9/14.
 */

public class App extends Application {

    public static BaseActivity context = null;
    public  static int  PAGE=1;


    @Override
    public void onCreate() {
        super.onCreate();


    }
}
