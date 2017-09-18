package com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.presenter;

import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.moble.BeanTaishan;
import com.example.administrator.pandachannels.fragmentchinese.fragmentclassify.utils.Url;
import com.example.administrator.pandachannels.framework.contract.MainContract;
import com.example.administrator.pandachannels.framework.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:111
 * Time:2017/9/15
 * Motto: where my heart get peace,where my self get home.
 */
public class SubPresenterimpl_Fenghuang implements MainContract.SubPresenter {
    MainContract.SubView subview;
    ArrayList<BeanTaishan.LiveBean> list=new ArrayList<>();
    public SubPresenterimpl_Fenghuang(MainContract.SubView subview) {
        this.subview = subview;
    }

    @Override
    public void requsetData() {
        subview.showLoading();
        OkHttpUtils.getInstance().getNetData(Url.FENGHUANG, new OkHttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {
                Gson gson=new Gson();
                BeanTaishan beanTaishan = gson.fromJson(ss, BeanTaishan.class);
                List<BeanTaishan.LiveBean> live = beanTaishan.getLive();
                list.addAll(live);
                //p层请求完数据，调用V层方法展示数据
                subview.dissmissLoading();
                subview.showData(list);

            }
        });

    }
}

