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
public class MountHang_fragment extends BaseFragment {


    private TextView hangsj;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mount_hang_fragment, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {

        hangsj = (TextView) view.findViewById(R.id.hangsj);

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_mount_hang_fragment;
    }

    @Override
    protected void initData() {

    }

}
