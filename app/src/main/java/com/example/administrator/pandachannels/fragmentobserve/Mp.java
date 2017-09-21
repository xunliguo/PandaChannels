package com.example.administrator.pandachannels.fragmentobserve;

import com.example.administrator.pandachannels.fragmentobserve.entity.PandaBean;
import com.example.administrator.pandachannels.fragmentobserve.entity.PandaViewBean;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.example.administrator.pandachannels.framework.utils.Urls;
import com.google.gson.Gson;

/**
 * Created by DELL on 2017/9/14.
 */

public class Mp implements MainContract.SubPresenter {
    //在p层实现类 给view提供构造方法
    MainContract.ShiView shiView;
    public Mp(MainContract.ShiView shiView) {
        this.shiView = shiView;
    }

    @Override
    public void requsetData() {
        shiView.showLoading();
        OkHttpUtils.getInstance().getNetData(Urls.PANDAVIEW, new OkHttpUtils.CallBacks() {

            @Override
            public void getString(String ss) {
                Gson gson=new Gson();
                PandaViewBean listBean = gson.fromJson(ss, PandaViewBean.class);
                //解析完通过调用v层接口里的方法吧数据传到UI界面进行展示
                shiView.showData(listBean);
                shiView.diassLoading();
            }
        });

        OkHttpUtils.getInstance().getNetData(Urls.PANDABROADCAST, new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                Gson gson=new Gson();
                PandaBean pandaBean = gson.fromJson(ss, PandaBean.class);
                shiView.showPan(pandaBean);
            }
        });
    }
}
