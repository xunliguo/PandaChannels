package com.example.administrator.pandachannels.fragmentlive.presenter;

import com.example.administrator.pandachannels.fragmentlive.fragment.PanadafileFrament;
import com.example.administrator.pandachannels.fragmentlive.model.entity.WondBean;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by ASUS-PC on 2017/9/15.
 */

public class PandlifPersenterimpl implements MainContract.SubPresenter {
    MainContract.XSubView xSubview;
    public PandlifPersenterimpl(MainContract.XSubView  xSubview) {
        this.xSubview=xSubview;
    }

    @Override
    public void requsetData() {
        OkHttpUtils.getInstance().getNetData("http://api.cntv.cn/video/videolistById?\n" +
                "vsid=VSET100340574858&n=7&serviceId=panda&o=desc&of=time&p=1", new OkHttpUtils.CallBacks() {
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
