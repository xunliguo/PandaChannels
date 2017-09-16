package com.example.administrator.pandachannels.fragmentlive.presenter;

import com.example.administrator.pandachannels.fragmentlive.App;
import com.example.administrator.pandachannels.fragmentlive.fragment.Specs_fragment;
import com.example.administrator.pandachannels.fragmentlive.model.entity.WondBean;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by ASUS-PC on 2017/9/15.
 */

public class SpecPresenterImpl implements MainContract.SubPresenter {
    private String url="http://api.cntv.cn/video/videolistById?vsid=VSET100167308855&n=7&serviceId=panda&o=desc&of=time&p=";
    MainContract.XSubView xSubview;
    public SpecPresenterImpl(MainContract.XSubView  xSubview) {
        this.xSubview=xSubview;
    }

    @Override
    public void requsetData() {
        OkHttpUtils.getInstance().getNetData(url+ App.PAGE, new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                Gson gson=new Gson();
                WondBean wondBean = gson.fromJson(ss, WondBean.class);
                List<WondBean.VideoBean> video = wondBean.getVideo();
                xSubview.showDatasWond(video);


            }
        });


    }
}
