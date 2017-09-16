package com.example.administrator.pandachannels.framework.baseview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author:111
 * Time:2017/9/13
 * Motto: where my heart get peace,where my self get home.
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), null);
        initView(view);
        initData();
        return view;

    }
    //找id
    protected abstract void initView(View view);
//初始化布局
    protected abstract int getLayout();
  //初始化数据
    protected abstract void initData();
}


























