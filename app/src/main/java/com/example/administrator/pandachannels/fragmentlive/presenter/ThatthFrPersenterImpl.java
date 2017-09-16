package com.example.administrator.pandachannels.fragmentlive.presenter;

import com.example.administrator.pandachannels.fragmentlive.App;
import com.example.administrator.pandachannels.fragmentlive.fragment.Thatthing_fragment;
import com.example.administrator.pandachannels.fragmentlive.model.entity.WondBean;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by ASUS-PC on 2017/9/15.
 */

public class ThatthFrPersenterImpl implements MainContract.SubPresenter {
    MainContract.XSubView xSubview;
    private String url="http://api.cntv.cn/video/videolistById?\n" + "vsid=VSET100237714751&n=7&serviceId=panda&o=desc&of=time&p=";
    public ThatthFrPersenterImpl(MainContract.XSubView xSubview) {
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
