package com.example.administrator.pandachannels.fragmentlive.presenter;

import com.example.administrator.pandachannels.fragmentlive.App;
import com.example.administrator.pandachannels.fragmentlive.model.entity.WondBean;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS-PC on 2017/9/15.
 */

public class WonfulPersenterImpl implements MainContract.SubPresenter {
    private List<WondBean.VideoBean> mlist=new ArrayList<>();
    private String url="http://api.cntv.cn/video/videolistById?\n" +
            "vsid=VSET100167216881&n=7&serviceId=panda&o=desc&of=time&p=";
    MainContract.XSubView xSubview;

    public WonfulPersenterImpl(MainContract.XSubView xSubview) {
        this.xSubview=xSubview;
    }

    @Override
    public void requsetData() {


        OkHttpUtils.getInstance().getNetData(url+ App.PAGE, new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                Gson gson=new Gson();
                WondBean wondBean = gson.fromJson(ss, WondBean.class);
                List<WondBean.VideoBean> videolist = wondBean.getVideo();
                mlist.addAll(videolist);

                xSubview.showDatasWond(mlist);



            }
        });


    }
}
