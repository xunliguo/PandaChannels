package com.example.administrator.pandachannels.fragmenthome.presen;

import com.example.administrator.pandachannels.fragmenthome.bean.PandaLiveBean;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;

import com.example.administrator.pandachannels.framework.utils.Urls;
import com.google.gson.Gson;

/**
 * Created by lenovo on 2017/9/14.
 */
//奥术大师sad
public class PresentImp implements MainContract.SubPresenter {
    MainContract.SubHome subView;

    public PresentImp(MainContract.SubHome subView) {
        this.subView = subView;
    }

    @Override
    public void requsetData() {
        subView.showLoading();
        OkHttpUtils.getInstance().getNetData(Urls.PANDAHOME, new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                PandaLiveBean pandaLiveBean = new Gson().fromJson(ss, PandaLiveBean.class);
                subView.showDate(pandaLiveBean);
                subView.dissmissLoading();
            }
        });

    }
}
