package com.example.administrator.pandachannels.fragmentchinese.fragmentclassify;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.framework.baseview.BaseFragment;

public class Funghwang_fragment extends BaseFragment {


    private TextView ddf;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_funghwang_fragment, container, false);
        initView(view);
        return view;
    }

    @Override
    protected void initView(View view) {

        ddf = (TextView) view.findViewById(R.id.ddf);

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_funghwang_fragment;
    }

    @Override
    protected void initData() {

    }

}
