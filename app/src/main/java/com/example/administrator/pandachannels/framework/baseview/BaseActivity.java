package com.example.administrator.pandachannels.framework.baseview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.pandachannels.fragmentlive.App;

/**
 * Author:111
 * Time:2017/9/13
 * Motto: where my heart get peace,where my self get home.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.context=this;
        setContentView(getlayoutID());
        initView();
        initClick();
        initData();
    }
//初始化数据
    protected abstract void initData();
//初始化点击事件
    protected abstract void initClick();

    //初始化 id
    protected  abstract void initView();
    //绑定 layout布局
    protected  abstract int getlayoutID();
}





















