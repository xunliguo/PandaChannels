package com.example.administrator.pandachannels.fragmentculture;

import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.google.gson.Gson;

/**
 * Created by lenovo on 2017/9/15.
 */

public class LiPresenter implements MainContract.SubPresenter {
    private MainContract.LiView liView;

    public LiPresenter(MainContract.LiView liView) {
        this.liView = liView;
    }

    @Override
    public void requsetData() {
        liView.showLoading();
        OkHttpUtils.getInstance().getNetData("http://www.ipanda.com/kehuduan/video/index.json", new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                Gson gson=new Gson();
                LiBean liBean = gson.fromJson(ss, LiBean.class);
                liView.showData(liBean);
                liView.dissmissLoading();
            }
        });

    }
}
