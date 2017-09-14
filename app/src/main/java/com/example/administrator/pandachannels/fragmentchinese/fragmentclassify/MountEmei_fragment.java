package com.example.administrator.pandachannels.fragmentchinese.fragmentclassify;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.pandachannels.R;
import com.example.administrator.pandachannels.framework.baseview.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MountEmei_fragment extends BaseFragment {


    private TextView dhhd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mount_emei_fragment, container, false);
        initView(view);
        return view;
    }

    @Override
    protected void initView(View view) {

        dhhd = (TextView) view.findViewById(R.id.dhhd);

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_mount_emei_fragment;
    }

    @Override
    protected void initData() {

    }

}
