package com.example.administrator.pandachannels.fragmentlive.presenter;

import com.example.administrator.pandachannels.fragmentlive.fragment.ManyFragment;
import com.example.administrator.pandachannels.fragmentlive.model.entity.ManyBean;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.example.administrator.pandachannels.framework.utils.Urls;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by ASUS-PC on 2017/9/15.
 */

public class ManyFraPersenterImpl implements MainContract.SubPresenter {
    MainContract.XSubView xSubview;
    public ManyFraPersenterImpl(MainContract.XSubView  xSubview) {
        this.xSubview=xSubview;
    }
    @Override
    public void requsetData() {

        OkHttpUtils.getInstance().getNetData(Urls.PANDALIVEMULTI, new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                Gson  gson=new Gson();
                ManyBean manyBean = gson.fromJson(ss, ManyBean.class);
                List<ManyBean.ListBean> list = manyBean.getList();
                xSubview.showDatas1(list);

            }
        });




    }
}
